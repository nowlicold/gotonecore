/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.common.enums;

import com.bench.common.enums.EnumBase;

/**
 * 邮件发送用户配置状态枚举
 * 
 * @author cold
 * 
 * @version $Id: MailUserConfigStatusEnum.java, v 0.1 2012-10-16 上午11:48:35
 *          cold Exp $
 */
public enum MailUserConfigStatusEnum implements EnumBase {
	ENABLED("有效"),

	DISABLED("无效");

	private String message;

	private MailUserConfigStatusEnum(String message) {
		this.message = message;
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
