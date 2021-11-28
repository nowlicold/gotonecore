package com.yuan.gotonecore.service.enums;

import com.bench.common.enums.EnumBase;

/**
 * @className ConfigNameEnum
 * @autor cold
 * @DATE 2021/6/25 0:18
 **/
public enum ConfigNameEnum implements EnumBase {
    CHANNEL_VALIDATE_CODE_CONFIG("通道验证码配置"),

    DEFALUT_SMS_CHANNEL_NAME("默认短信通道名"),

    SMS_SEND_INTERCEPT_RULE("未知")

    ;
    ConfigNameEnum(String message){
        this.message = message;
    }
    private String message;

    @Override
    public String message() {
        return message;
    }

    @Override
    public Number value() {
        return null;
    }
}
