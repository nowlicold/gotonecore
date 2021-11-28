package com.yuan.gotonecore.common.enums;

import com.bench.common.enums.EnumBase;

/**
 * @author fangbianmian
 * @version : LockNamePrefixEnum, v 0.1 2019/5/17 0017 17:30 fangbianmian Exp $$
 */
public enum LockNamePrefixEnum implements EnumBase {

    SMS_SEND_FREQUENCY_CHECK_("短信发送频率检查前缀"),
    ;

    private String message;

    private LockNamePrefixEnum(String message) {
        this.message = message;
    }

    public String message() {
        return this.message;
    }

    public Number value() {
        return null;
    }
}
