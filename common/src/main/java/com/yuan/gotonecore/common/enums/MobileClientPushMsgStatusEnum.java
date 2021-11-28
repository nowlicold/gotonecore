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
 * @version $Id: MobileClientPushMsgStatusEnum.java, v 0.1 2016年1月22日 下午5:54:48
 *          cold Exp $
 */
public enum MobileClientPushMsgStatusEnum implements EnumBase {

	READY("准备推送"),

	RETRY("重试"),

	CANCEL("取消"),
	
	OVER_TRY_COUNT("超过重试次数"),

	SUCCESS("成功推送");

	private MobileClientPushMsgStatusEnum(String message) {
		this.message = message;
	}

	private String message;

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
