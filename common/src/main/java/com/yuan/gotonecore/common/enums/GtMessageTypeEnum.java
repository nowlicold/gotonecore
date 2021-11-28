/*
 * Bench.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.common.enums;

/**
 * 消息类别枚举。
 * 
 * @author min.weixm
 * @version $Id: GtMessageTypeEnum.java, v 0.1 2009-09-02 下午01:19:53 min.weixm
 *          Exp $
 */
public enum GtMessageTypeEnum {

	/** 短消息 */
	MSG_SMS("SMS", "短消息"),

	/** 邮件 */
	MSG_EMAIL("MAIL", "邮件"), ;

	/** value */
	private String value = null;

	/** message */
	private String message = null;

	/**
	 * GtMessageTypeEnum
	 * 
	 * @param value
	 * @param message
	 */
	private GtMessageTypeEnum(String value, String message) {
		this.value = value;
		this.message = message;
	}

	/**
	 * Getter method for property <tt>value</tt>.
	 * 
	 * @return property value of value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Getter method for property <tt>message</tt>.
	 * 
	 * @return property value of message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * 通过枚举<code>value</code>获得枚举
	 * 
	 * @param value
	 * @return
	 */
	public static GtMessageTypeEnum getByValue(String value) {
		if (value == null) {
			return null;
		}
		for (GtMessageTypeEnum result : values()) {
			if (result.getValue().equals(value)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * 通过枚举<code>name</code>获得枚举
	 * 
	 * @param message
	 * @return
	 */
	public static GtMessageTypeEnum getByMessage(String message) {
		if (message == null) {
			return null;
		}
		for (GtMessageTypeEnum result : values()) {
			if (result.getMessage().equals(message)) {
				return result;
			}
		}
		return null;
	}
}
