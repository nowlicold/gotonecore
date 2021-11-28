package com.yuan.gotonecore.service.sms.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.bench.lang.base.IpUtils;
import com.bench.lang.base.string.utils.StringUtils;
import com.yuan.gotonecore.api.model.enums.ErrorCodeEnum;
import com.yuan.gotonecore.api.sms.model.SmsBlackList;
import com.yuan.gotonecore.api.sms.model.enums.SmsInterceptObjectTypeEnum;
import com.yuan.gotonecore.api.sms.request.SmsBlackListCreateRequest;
import com.yuan.gotonecore.api.sms.result.SmsBlackListOperateResult;
import com.yuan.gotonecore.repository.entity.SmsBlackListDO;
import com.yuan.gotonecore.repository.mapper.SmsBlackListMapper;
import com.yuan.gotonecore.service.sms.SmsBlackListManageComponent;
import com.yuan.gotonecore.service.sms.SmsBlackListQueryComponent;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @className SmsBlackListManageComponentImpl
 * @autor cold
 * @DATE 2021/6/25 0:35
 **/
@Service
public class SmsBlackListManageComponentImpl implements SmsBlackListManageComponent {

    @Autowired
    private SmsBlackListMapper smsBlackListMapper;


    @Autowired
    private TransactionTemplate transactionTemplate;


    @Autowired
    private SmsBlackListQueryComponent smsBlackListQueryComponent;

    /**
     * 创建短信黑名单
     *
     * @param request
     * @return
     */
    @Override
    public SmsBlackListOperateResult create(SmsBlackListCreateRequest request) {
        SmsBlackListOperateResult result = new SmsBlackListOperateResult();
        if (request.getInterceptObjectType() == null || StringUtils.isEmpty(request.getInterceptObjectValue()) || request.getGmtRemove() == null) {
            result.setErrorCode(ErrorCodeEnum.PARAMETER_MISSING.errorCode());
            result.setSuccess(false);
            return result;
        }
        if (request.getInterceptObjectType() == SmsInterceptObjectTypeEnum.IP) {
            if (!IpUtils.isValidIp(request.getInterceptObjectValue())) {
                result.setErrorCode(ErrorCodeEnum.IP_NOT_VALID.errorCode());
                result.setSuccess(false);
                return result;
            }
        }
        transactionTemplate.execute(status -> {
            SmsBlackListDO smsBlackListDO = new SmsBlackListDO();
            BeanCopier.create(SmsBlackListCreateRequest.class, SmsBlackListDO.class, false).copy(request,smsBlackListDO,null);
            smsBlackListDO.setId(IdWorker.getIdStr());
            smsBlackListMapper.insert(smsBlackListDO);
            result.setSuccess(true);
            return result;
        });
        return result;
    }

    /**
     * 移除黑名单
     *
     * @param id
     * @return
     */
    @Override
    public SmsBlackListOperateResult remove(String id) {
        SmsBlackListOperateResult result = new SmsBlackListOperateResult();
        SmsBlackList smsBlackList = smsBlackListQueryComponent.getEnabledById(id);
        //有效的不出在，说明已移除
        if (smsBlackList == null) {
            result.setSuccess(true);
            return result;
        }
        transactionTemplate.execute(status -> {
            SmsBlackListDO smsBlackListDO;
            try {
                smsBlackListDO = smsBlackListMapper.selectByIdForUpdate(id);
            } catch (Exception e) {
                result.setSuccess(false);
                result.setErrorCode(ErrorCodeEnum.DATA_LOCK_FAILED.errorCode());
                return result;
            }
            if (smsBlackListDO == null) {
                result.setSuccess(false);
                result.setErrorCode(ErrorCodeEnum.SMS_BLACK_LIST_NOT_EXIST.errorCode());
                return result;
            }
            smsBlackListMapper.updateDisableById(id);
            result.setId(id);
            result.setSuccess(true);
            return result;
        });
        return result;
    }
}
