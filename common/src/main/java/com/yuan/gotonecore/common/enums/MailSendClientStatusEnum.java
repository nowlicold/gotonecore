/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.common.enums;

import com.bench.common.enums.EnumBase;

/**
 * 
 * @author cold
 * 
 * @version $Id: MailSendClientStatusEnum.java, v 0.1 2011-1-27 下午03:04:09
 *          cold Exp $
 */
public enum MailSendClientStatusEnum implements EnumBase {

	LIVE("存活"),

	DEAD("死亡");

	private String message;

	private MailSendClientStatusEnum(String message) {
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
