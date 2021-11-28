/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.api.sms.model.enums;

import com.bench.common.enums.EnumBase;

/**
 * 短信客户端发送状态
 * 
 * @author cold
 * 
 * @version $Id: SmsClientSendStatusEnum.java, v 0.1 2014-9-26 下午12:36:56
 *          cold Exp $
 */
public enum SmsClientSendStatusEnum implements EnumBase {

	READY("准备发送", false),

	SENDING("正在发送", false),

	SUCCESS("发送成功", true),

	RETRY("重试", false),

	FAILED("发送失败", true),

	;

	private SmsClientSendStatusEnum(String messsage, boolean end) {
		this.messsage = messsage;
		this.end = end;
	}

	private String messsage;

	private boolean end;

	public boolean end() {
		return this.end;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bench.common.enums.EnumBase#message()
	 */
	public String message() {
		// TODO Auto-generated method stub
		return messsage;
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
