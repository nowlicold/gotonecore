package com.yuan.gotonecore.service.enums;

import com.bench.lock.enums.LockAppNameEnum;

/**
 * @className AppLockNameEnum
 * @autor cold
 * @DATE 2021/6/23 0:27
 **/
public enum GotonecoreLockAppNameEnum implements LockAppNameEnum {
    GOTONECORE("沟通核心");

    private String message;
    GotonecoreLockAppNameEnum(String message){
    this.message = message;
    }
    @Override
    public String message() {
        return null;
    }

    @Override
    public Number value() {
        return null;
    }
}
