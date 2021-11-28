package com.yuan.gotonecore.service.sms.impl;

import com.bench.lang.base.date.utils.DateUtils;
import com.bench.lang.base.string.utils.StringUtils;
import com.yuan.gotonecore.api.model.enums.ErrorCodeEnum;
import com.yuan.gotonecore.api.sms.model.SmsConfig;
import com.yuan.gotonecore.api.sms.request.SmsAckCodeValidateRequest;
import com.yuan.gotonecore.api.sms.result.SmsAckCodeValidateResult;
import com.yuan.gotonecore.api.sms.result.SmsResult;
import com.yuan.gotonecore.repository.entity.SmsOutHisDO;
import com.yuan.gotonecore.repository.mapper.SmsOutHisMapper;
import com.yuan.gotonecore.repository.mapper.SmsOutMapper;
import com.yuan.gotonecore.service.sms.SmsAckCodeValidateComponent;
import com.yuan.gotonecore.service.sms.SmsConfigQueryComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @className SmsAckCodeValidateComponentImpl
 * @autor cold
 * @DATE 2021/6/20 0:02
 **/
@Slf4j
@Service
public class SmsAckCodeValidateComponentImpl implements SmsAckCodeValidateComponent {
    @Autowired
    private TransactionTemplate transactionTemplate;
    @Autowired
    private SmsOutHisMapper smsOutHisMapper;
    @Autowired
    private SmsOutMapper smsOutMapper;

    @Autowired
    private SmsConfigQueryComponent smsConfigQueryComponent;
    @Override
    public SmsAckCodeValidateResult validateAckCode(SmsAckCodeValidateRequest request) {
        final SmsAckCodeValidateResult result = new SmsAckCodeValidateResult();
        if (StringUtils.isEmpty(request.getSmsId())) {
            log.warn("短信无法验证，传递smsId为空,request=" + request);
            result.setSuccess(false);
            result.setErrorCode(ErrorCodeEnum.PARAMETER_MISSING.errorCode());
            result.setDetailMessage("没有传递smsId");
            return result;
        }
        transactionTemplate.execute(new TransactionCallback<SmsResult>() {
            public SmsResult doInTransaction(TransactionStatus status) {
                SmsOutHisDO outHisDO = null;
                try {
                    outHisDO = smsOutHisMapper.selectBySmsId(request.getSmsId());
                } catch (Exception e) {
                    result.setSuccess(false);
                    result.setErrorCode(ErrorCodeEnum.SMS_OUT_HIS_LOCK_FAILED.errorCode());
                    return result;
                }
                if (outHisDO == null) {
                    result.setSuccess(false);
                    if (smsOutMapper.selectCountBySmsId(request.getSmsId()) > 0) {
                        result.setErrorCode(ErrorCodeEnum.SMS_OUT_NOT_SEND_YET.errorCode());
                    } else {
                        result.setErrorCode(ErrorCodeEnum.SMS_OUT_HIS_NOT_FOUND.errorCode());
                    }
                    return result;
                }
                SmsConfig smsConfig = smsConfigQueryComponent.getCachedById(outHisDO.getSmsConfigId());
                result.setMaxAllowedValidateCount(smsConfig.getAckCodeMaxValidate());
                result.setCurrentValidateCount(outHisDO.getAckCodeValidateTryCount());
                // 验证userId
                if (!StringUtils.isEmpty(outHisDO.getUserId()) && !StringUtils.equals(outHisDO.getUserId(), request.getUserId())) {
                    result.setSuccess(false);
                    result.setErrorCode(ErrorCodeEnum.SMS_OUT_USER_MISMATCH.errorCode());
                    return result;
                }

                // 验证手机
                if (!StringUtils.equals(outHisDO.getReceiver(), request.getCell())) {
                    result.setSuccess(false);
                    result.setErrorCode(ErrorCodeEnum.SMS_OUT_RECEIVER_MISMATCH.errorCode());
                    return result;
                }

                // 验证bizId
                if (!StringUtils.equals(outHisDO.getBizId(), request.getBizId())) {
                    result.setSuccess(false);
                    result.setErrorCode(ErrorCodeEnum.SMS_OUT_BIZ_ID_MISMATCH.errorCode());
                    return result;
                }

                // 如果为空，则不支持
                if (StringUtils.isEmpty(outHisDO.getAckCode())) {
                    result.setSuccess(false);
                    result.setErrorCode(ErrorCodeEnum.SMS_OUT_ACK_CODE_NOT_SUPPORT.errorCode());
                    return result;
                }
                // 判断短信是否失效
                if (DateUtils.getDiffSeconds(DateUtils.now(), DateUtils.addSeconds(outHisDO.getGmtSendSuccess(), smsConfig.getAckCodeTimeoutSeconds())) > 0) {
                    result.setSuccess(false);
                    result.setErrorCode(ErrorCodeEnum.VALIDATE_CODE_EXPIRED.errorCode());
                    return result;
                }
                // 验证次数
                if (smsConfig.getAckCodeMaxValidate() > 0) {
                    // 如果已经大于了
                    if (outHisDO.getAckCodeValidateTryCount() + 1 > smsConfig.getAckCodeMaxValidate()) {
                        result.setSuccess(false);
                        result.setErrorCode(ErrorCodeEnum.SMS_OUT_ACK_CODE_VALIDATE_TOO_MUCH.errorCode());
                        result.setDetailMessage("短信验证码输错次数过多,请"
                                + +DateUtils.getDiffSeconds(DateUtils.addSeconds(outHisDO.getGmtSendSuccess(), smsConfig.getIntervalSeconds()), new Date()) + "秒后重新获取验证码");
                        result.setWaitNextPrepareSeconds(DateUtils.getDiffSeconds(DateUtils.addSeconds(outHisDO.getGmtSendSuccess(), smsConfig.getIntervalSeconds()),
                                new Date()));
                        return result;
                    }
                }
                // 是否已经验证过了
                if (outHisDO.getAckCodeValidateCount() > 0) {
                    result.setSuccess(false);
                    result.setErrorCode(ErrorCodeEnum.SMS_OUT_ACK_CODE_VALIDATE_TOO_MUCH.errorCode());
                    return result;
                }

                // 是否相等
                if (!StringUtils.equals(request.getAckCode(), outHisDO.getAckCode())) {
                    result.setSuccess(false);
                    // 如果已经大于了
                    if (outHisDO.getAckCodeValidateTryCount() + 1 >= smsConfig.getAckCodeMaxValidate()) {
                        result.setErrorCode(ErrorCodeEnum.SMS_OUT_ACK_CODE_VALIDATE_TOO_MUCH.errorCode());
                    } else {
                        result.setErrorCode(ErrorCodeEnum.SMS_OUT_ACK_CODE_VALIDATE_MISMATCH.errorCode());
                    }
                    // 构建错误信息文本
                    if (outHisDO.getAckCodeValidateTryCount() == 0) {

                        result.setDetailMessage("短信验证码校验错误,超过" + smsConfig.getAckCodeMaxValidate() + "次,"
                                + DateUtils.getDiffSeconds(DateUtils.addSeconds(outHisDO.getGmtSendSuccess(), smsConfig.getIntervalSeconds()), new Date()) + "秒内不可检验");
                    } else if (outHisDO.getAckCodeValidateTryCount() + 1 == smsConfig.getAckCodeMaxValidate()) {
                        result.setDetailMessage("短信验证码输错次数过多,请"
                                + +DateUtils.getDiffSeconds(DateUtils.addSeconds(outHisDO.getGmtSendSuccess(), smsConfig.getIntervalSeconds()), new Date()) + "秒后重新获取验证码");
                    } else {
                        result.setDetailMessage("短信验证码校验错误,您还有" + (smsConfig.getAckCodeMaxValidate() - 1 - outHisDO.getAckCodeValidateTryCount()) + "次机会");
                    }
                    smsOutHisMapper.updateAckCodeValidateFailed(outHisDO.getId());
                    result.setCurrentValidateCount(outHisDO.getAckCodeValidateTryCount() + 1);
                    result.setWaitNextPrepareSeconds(DateUtils.getDiffSeconds(DateUtils.addSeconds(outHisDO.getGmtSendSuccess(), smsConfig.getIntervalSeconds()),
                            new Date()));
                    return result;
                }
                // 验证超时
                if (smsConfig.getAckCodeTimeoutSeconds() > 0) {
                    if (DateUtils.getDiffSeconds(new Date(), outHisDO.getGmtSendSuccess()) > smsConfig.getAckCodeTimeoutSeconds()) {
                        result.setSuccess(false);
                        result.setErrorCode(ErrorCodeEnum.SMS_OUT_ACK_CODE_TIME_OUT.errorCode());
                        return result;
                    }
                }

                // 更新验证成功次数
                smsOutHisMapper.updateAckCodeValidateSuccess(outHisDO.getId());
                result.setCurrentValidateCount(outHisDO.getAckCodeValidateTryCount() + 1);
                result.setSuccess(true);
                return result;
            }});
        return null;
    }
}
