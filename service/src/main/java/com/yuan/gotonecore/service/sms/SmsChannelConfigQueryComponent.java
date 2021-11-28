package com.yuan.gotonecore.service.sms;

import com.yuan.gotonecore.api.sms.model.SmsChannelConfig;
import com.yuan.gotonecore.api.sms.model.enums.SmsChannelEnum;

import java.util.List;

/**
 * @className SmsChannelConfigQueryComponent
 * @autor cold
 * @DATE 2021/6/22 0:36
 **/
public interface SmsChannelConfigQueryComponent {

    /**
     * 根据通道获取短信短信通道配置
     *
     * @param channel
     * @return
     */
    public SmsChannelConfig getByChannelCode(SmsChannelEnum channel);

    /**
     * 根据手机号码，短信通道配置码，选择一个通道发送
     *
     * @param cell
     * @param channels
     * @return
     */
    public SmsChannelConfig selectSmsChannel(String cell, SmsChannelEnum[] channels);

    /**
     * 获取所有有效的
     *
     * @return
     */
    public List<SmsChannelConfig> getAllEnabled();
}
