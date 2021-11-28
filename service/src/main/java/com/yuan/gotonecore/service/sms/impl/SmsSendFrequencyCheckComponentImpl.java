package com.yuan.gotonecore.service.sms.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bench.cache.AppCacheComponent;
import com.bench.lang.base.date.utils.DateUtils;
import com.bench.lang.base.list.utils.ListUtils;
import com.bench.lang.base.number.utils.NumberUtils;
import com.bench.lang.base.string.utils.StringUtils;
import com.bench.lock.LockComponent;
import com.bench.lock.LockExecuter;
import com.yuan.gotonecore.api.model.enums.ErrorCodeEnum;
import com.yuan.gotonecore.api.sms.model.SmsBlackList;
import com.yuan.gotonecore.api.sms.model.enums.SmsInterceptObjectTypeEnum;
import com.yuan.gotonecore.api.sms.request.SmsBlackListCreateRequest;
import com.yuan.gotonecore.service.enums.AppCacheAreaNameEnum;
import com.yuan.gotonecore.service.enums.ConfigNameEnum;
import com.yuan.gotonecore.service.enums.GotonecoreLockAppNameEnum;
import com.yuan.gotonecore.service.sms.SmsBlackListManageComponent;
import com.yuan.gotonecore.service.sms.SmsBlackListQueryComponent;
import com.yuan.gotonecore.service.sms.SmsSendFrequencyCheckComponent;
import com.yuan.gotonecore.service.sms.request.SmsSendFrequencyCheckRequest;
import com.yuan.gotonecore.service.sms.result.SmsSendFrequencyCheckResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cold
 * @version : SmsSendFrequencyConsultComponentImpl, v 0.1 2019/5/16 0016 16:27 cold Exp $$
 */
@Service
public class SmsSendFrequencyCheckComponentImpl implements SmsSendFrequencyCheckComponent {

    private static final String SMS_SEND_PER_HOUR = "smsSendPerHour";
    private static final String SMS_SEND_PER_DAY = "smsSendPerDay";

    @Autowired
    private AppCacheComponent appCacheComponent;

    @Autowired
    private SmsBlackListQueryComponent smsBlackListQueryComponent;

    @Autowired
    private SmsBlackListManageComponent smsBlackListManageComponent;

    @Autowired
    private LockComponent lockComponent;

    /**
     * 检查
     *
     * @param request
     * @return
     */
    @Override
    public SmsSendFrequencyCheckResult check(SmsSendFrequencyCheckRequest request) {
        SmsSendFrequencyCheckResult result = new SmsSendFrequencyCheckResult();
        String ip = request.getIp();

        //短信发送拦截规则
        //对现在接口做兼容，在传了ip的时候才进行判断，不传即不对ip做频率限制
        if (StringUtils.isNotEmpty(ip)) {
            lockComponent.appTryLockForExecute(GotonecoreLockAppNameEnum.GOTONECORE,request.getIp(), new LockExecuter() {
                @Override
                public void lockedExecute() {
                    List<SmsBlackList> smsBlackList = smsBlackListQueryComponent.getEnabledByInterceptTypeAndValue(SmsInterceptObjectTypeEnum.IP, ip);
                    //已在黑名单中
                    if (ListUtils.isNotEmpty(smsBlackList)) {
                        result.setSuccess(false);
                        result.setErrorCode(ErrorCodeEnum.IP_IN_BLACK_LIST.errorCode());
                        result.setDetailMessage(ip + "该ip被拉黑，会于" + DateUtils.getNewFormatDateString(smsBlackList.get(0).getGmtRemove()) + "解除黑名单");
                        return;
                    }
                    //一小时内发送频率
                    checkPerHourForIP(request.getGmtSend(), ip, 20);
                    //一天内发送频率检查
                    checkPerDayForIP(request.getGmtSend(), ip, 20*24);
                }

                @Override
                public void canNotLockExecute() {
                    result.setSuccess(false);
                    result.setErrorCode(ErrorCodeEnum.DATA_LOCK_FAILED.errorCode());
                }
            });
        }
        result.setSuccess(true);
        return result;
    }

    /**
     * 检查手机号一天的发送频率
     *
     * @param gmtSend
     * @param ip
     * @param numbers
     */
    private void checkPerDayForIP(Date gmtSend, String ip, int numbers) {
        List<Date> ipSmsSendRecordListPerDay = (List<Date>) appCacheComponent.getObject(AppCacheAreaNameEnum.IP_SMS_SEND_PER_DAY_RECORD_CACHE, ip);
        if (ListUtils.isEmpty(ipSmsSendRecordListPerDay)) {
            ipSmsSendRecordListPerDay = new ArrayList<>();
        }
        ipSmsSendRecordListPerDay.add(gmtSend);
        appCacheComponent.putObjectWithExpire(AppCacheAreaNameEnum.IP_SMS_SEND_PER_DAY_RECORD_CACHE, ip, ipSmsSendRecordListPerDay, 24 * 60 * 60);
        //发送数量达到上限，拉入黑名单
        if (ipSmsSendRecordListPerDay.size() >= numbers) {
            createBlackList(SmsInterceptObjectTypeEnum.IP, ip, DateUtils.addHours(gmtSend, 24));
        }
    }

    /**
     * 检查手机号一小时的发送频率
     *
     * @param gmtSend
     * @param ip
     * @param numbers
     */
    private void checkPerHourForIP(Date gmtSend, String ip, int numbers) {
        List<Date> ipSmsSendRecordListPerHour = (List<Date>) appCacheComponent.getObject(AppCacheAreaNameEnum.IP_SMS_SEND_PER_HOUR_RECORD_CACHE, ip);
        if (ListUtils.isEmpty(ipSmsSendRecordListPerHour)) {
            ipSmsSendRecordListPerHour = new ArrayList<>();
        }
        ipSmsSendRecordListPerHour.add(gmtSend);
        appCacheComponent.putObjectWithExpire(AppCacheAreaNameEnum.IP_SMS_SEND_PER_HOUR_RECORD_CACHE, ip, ipSmsSendRecordListPerHour, 60 * 60);
        //发送数量达到上限，拉入黑名单
        if (ipSmsSendRecordListPerHour.size() >= numbers) {
            createBlackList(SmsInterceptObjectTypeEnum.IP, ip, DateUtils.addHours(gmtSend, 1));
        }
    }


    /**
     * 拉入黑名单
     *
     * @param smsInterceptObjectTypeEnum
     * @param value
     * @param gmtRemove
     */
    private void createBlackList(SmsInterceptObjectTypeEnum smsInterceptObjectTypeEnum, String value, Date gmtRemove) {
        SmsBlackListCreateRequest smsBlackListCreateRequest = new SmsBlackListCreateRequest();
        smsBlackListCreateRequest.setGmtRemove(gmtRemove);
        smsBlackListCreateRequest.setInterceptObjectType(smsInterceptObjectTypeEnum);
        smsBlackListCreateRequest.setInterceptObjectValue(value);
        smsBlackListManageComponent.create(smsBlackListCreateRequest);
    }
}
