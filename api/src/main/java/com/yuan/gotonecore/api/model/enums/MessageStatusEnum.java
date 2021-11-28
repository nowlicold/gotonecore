/**
 * Bench.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.api.model.enums;


import com.bench.lang.base.string.utils.StringUtils;
import com.bench.common.enums.EnumBase;

/**
 * 沟通消息对象状态枚举
 * 
 * @author cold
 * 
 * @version $Id: MessageStatusEnum.java, v 0.1 2009-9-7 下午04:21:50 cold
 *          Exp $
 */
public enum MessageStatusEnum implements EnumBase {
	// INIT
	I("初始态"),

	// WAIT_REPORT
	W("等待状态报告"),

	// PREPARE
	P("准备发送"),

	// EXECUTE
	E("正在发送"),

	// RETRY
	R("重试"),

	// ABORT
	A("放弃"),

	// SUCCESS
	S("发送成功"),

	O("超过重试次数"),

	// FAILURE
	F("发送失败");

	private String message = null;

	/**
	 * 私有构造方法
	 *
	 * @param message
	 */
	private MessageStatusEnum(String message) {
		this.message = message;
	}

	public static MessageStatusEnum safeValueOf(String name) {
		if (StringUtils.isBlank(name)) {
			return null;
		}
		name = name.trim();
		for (MessageStatusEnum type : values()) {
			if (type.name().equals(name))
				return type;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bench.common.enums.EnumBase#message()
	 */
	public String message() {
		// TODO Auto-generated method stub
		return message;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bench.common.enums.EnumBase#value()
	 */
	public Number value() {
		// TODO Auto-generated method stub
		return null;
	}

}
