/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.api.sms.model.enums;

import com.bench.common.enums.EnumBase;

/**
 * 短信发送客户端发送日志类型
 * 
 * @author cold
 * 
 * @version $Id: SmsClientSendLogActionEnum.java, v 0.1 2014-9-27 上午10:06:58
 *          cold Exp $
 */
public enum SmsClientSendLogActionEnum implements EnumBase {

	APPLY("申请发送"),

	UPDATE_RESULT("更新发送结果"),

	GIVE_UP("放弃发送"), ;

	private String message;

	private SmsClientSendLogActionEnum(String message) {
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
