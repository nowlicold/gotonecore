/**
 * Bench.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.common.enums;

/**
 * 沟通平台操作枚举
 * @author jian.wujian
 *
 * @version $Id: GotoneConsoleOperate.java, v 0.1 2009-10-10 下午05:20:29 jian.wujian Exp $
 */
public enum ConsoleOperateEnum {

    ADD("add", "新增"),

    REMOVE("remove", "删除"),

    UPDATE("update", "修改");

    private final String value;

    private final String description;

    /**
     * 私有构造方法
     * @param code
     * @param description
     */
    private ConsoleOperateEnum(String value, String description) {
        this.value = value;
        this.description = description;
    }

    /**
     * @return Returns the value.
     */
    public String getValue() {
        return value;
    }

    /**
     * @return Returns the description.
     */
    public String getDescription() {
        return description;
    }
}
