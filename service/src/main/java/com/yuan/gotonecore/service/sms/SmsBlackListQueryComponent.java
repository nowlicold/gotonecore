package com.yuan.gotonecore.service.sms;

import com.yuan.gotonecore.api.sms.model.SmsBlackList;
import com.yuan.gotonecore.api.sms.model.enums.SmsInterceptObjectTypeEnum;

import java.util.List;

/**
 * @className SmsBlackListQueryComponent
 * @autor cold
 * @DATE 2021/6/25 0:24
 **/
public interface SmsBlackListQueryComponent {
    /**
     * 根据拦截对象类型和对象值查询
     *
     * @param smsInterceptObjectTypeEnum
     * @param value
     * @return
     */
    public List<SmsBlackList> getEnabledByInterceptTypeAndValue(SmsInterceptObjectTypeEnum smsInterceptObjectTypeEnum, String value);

    /**
     * 根据id查询有效的
     *
     * @param id
     * @return
     */
    public SmsBlackList getEnabledById(String id);

}
