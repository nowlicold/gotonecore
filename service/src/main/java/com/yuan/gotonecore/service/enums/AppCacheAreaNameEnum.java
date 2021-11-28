package com.yuan.gotonecore.service.enums;
import com.bench.common.cache.app.AppCacheAreaName;
import com.bench.common.enums.EnumBase;

/**
 * @className AppCacheAreaNameEnum
 * @autor cold
 * @DATE 2021/6/21 19:44
 **/
public enum AppCacheAreaNameEnum implements AppCacheAreaName,EnumBase {
    IP_SMS_SEND_PER_HOUR_RECORD_CACHE("IP短信发送记录缓存"),

    IP_SMS_SEND_PER_DAY_RECORD_CACHE("IP短信发送记录缓存"),

    SMS_OUT_ID_AND_IP_CACHE("短信发送缓存"),
    ;
    private String message;

    private int value;

    AppCacheAreaNameEnum(String message){
        this.message = message;
    }
    @Override
    public String message() {
        return message;
    }

    @Override
    public Number value() {
        return value;
    }
}
