package com.yuan.gotonecore.service.sms;

import com.yuan.gotonecore.api.sms.model.SmsConfig;
import com.yuan.gotonecore.api.sms.request.SmsConfigQueryRequest;
import com.yuan.gotonecore.api.sms.result.SmsConfigPageQueryResult;

import java.util.List;

/**
 * @className SmsConfigQueryComponent
 * @autor cold
 * @DATE 2021/6/20 0:20
 **/
public interface SmsConfigQueryComponent {
    /**
     * 查询短信配置
     *
     * @param searchRequest
     * @return
     */
    public SmsConfigPageQueryResult search(SmsConfigQueryRequest searchRequest);

    /**
     * 根据id获取短信配置
     *
     * @param id
     * @return
     */
    public SmsConfig getById(long id);

    /**
     * 根据短信配置ID获取短信配
     *
     * @param configName
     * @return
     */
    public SmsConfig getByConfigName(String configName);

    /**
     * 根据配置id，获取缓存的短信配置
     *
     * @param configName
     * @return
     */
    public SmsConfig getCachedByConfigName(String configName);

    /**
     * 根据id，获取缓存的短信配置
     *
     * @param id
     * @return
     */
    public SmsConfig getCachedById(long id);

    /**
     * 根据id，获取缓存的短信配置
     *
     * @param ids
     * @return
     */
    public List<SmsConfig> getCachedByIds(List<Long> ids);
}
