package com.yuan.gotonecore.api.user.enums;

import com.bench.common.enums.EnumBase;

/**
 * @className UserOrderByEnum
 * @autor cold
 * @DATE 2021/5/23 19:38
 **/
public enum UserOrderByEnum implements EnumBase {
    GMT_CREATE_DESC("创建时间倒序","gmt_create desc")
    ;
    private String message;

    private String dbValue;

    UserOrderByEnum(String message,String dbValue){
        this.message = message;
        this.dbValue = dbValue;
    }
    @Override
    public String message() {
        return this.message;
    }

    public String dbValue(){
        return this.dbValue;
    }

    @Override
    public Number value() {
        return null;
    }
}
