package com.yuan.gotonecore.service.sms.impl;

import java.util.List;

import com.bench.lang.base.string.utils.StringUtils;
import com.yuan.gotonecore.api.sms.model.SmsBlackList;
import com.yuan.gotonecore.api.sms.model.enums.SmsInterceptObjectTypeEnum;
import com.yuan.gotonecore.repository.mapper.SmsBlackListMapper;
import com.yuan.gotonecore.service.sms.SmsBlackListConvert;
import com.yuan.gotonecore.service.sms.SmsBlackListQueryComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author cold
 * @version : SmsBlackListQueryComponentImpl, v 0.1 2019/5/16 0016 15:54 cold Exp $$
 */
@Service
public class SmsBlackListQueryComponentImpl implements SmsBlackListQueryComponent {


    @Autowired
    private SmsBlackListMapper smsBlackListMapper;

    /**
     * 根据拦截对象类型和对象值查询
     *
     * @param smsInterceptObjectTypeEnum
     * @param value
     * @return
     */
    @Override
    public List<SmsBlackList> getEnabledByInterceptTypeAndValue(SmsInterceptObjectTypeEnum smsInterceptObjectTypeEnum, String value) {
        if (smsInterceptObjectTypeEnum == null || StringUtils.isEmpty(value)) {
            return null;
        }
        return SmsBlackListConvert.convertList(smsBlackListMapper.selectEnabledByInterceptTypeAndValue(smsInterceptObjectTypeEnum.name(), value));
    }

    /**
     * 根据id查询有效的
     *
     * @param id
     * @return
     */
    @Override
    public SmsBlackList getEnabledById(String id) {
        return SmsBlackListConvert.convert(smsBlackListMapper.selectEnabledById(id));
    }
}
