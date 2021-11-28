package com.yuan.gotonecore.common.enums;

import com.bench.common.cache.app.AppCacheAreaName;
import com.bench.common.enums.EnumBase;

/**
 * app缓存名枚举
 *
 * @author fangbianmian
 * @version : AppCacheAreaNameEnum, v 0.1 2019/5/16 0016 16:52 fangbianmian Exp $$
 */
public enum AppCacheAreaNameEnum implements AppCacheAreaName, EnumBase {

    IP_SMS_SEND_PER_HOUR_RECORD_CACHE("IP短信发送记录缓存"),

    IP_SMS_SEND_PER_DAY_RECORD_CACHE("IP短信发送记录缓存"),

    SMS_OUT_ID_AND_IP_CACHE("短信发送缓存"),
    ;

    private String message;

    private AppCacheAreaNameEnum(String message) {
        this.message = message;
    }

    public String message() {
        // TODO Auto-generated method stub
        return message;
    }

    public Number value() {
        // TODO Auto-generated method stub
        return null;
    }
}
