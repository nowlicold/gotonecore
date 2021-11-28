/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.api.sms.model.enums;

import com.bench.common.enums.EnumBase;

/**
 * 短信发送通道模式枚举
 * 
 * @author cold
 * 
 * @version $Id: SmsChannelRunModeEnum, v 0.1 2011-9-28 下午05:56:15 cold Exp $
 */
public enum SmsChannelRunModeEnum implements EnumBase {

	INITIATIVE("主动发送,即由服务端直接发送"),

	PASSIVE("被动发送,即由服务端调度后,再由客户端发送"), ;

	private String message;

	private SmsChannelRunModeEnum(String message) {
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
