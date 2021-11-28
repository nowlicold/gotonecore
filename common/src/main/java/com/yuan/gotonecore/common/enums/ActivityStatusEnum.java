/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.common.enums;

import com.bench.common.enums.EnumBase;

/**
 * 活动状态枚举
 * 
 * @author cold
 * 
 * @version $Id: ActivityStatusEnum.java, v 0.1 2012-10-26 下午5:14:23 cold Exp
 *          $
 */
public enum ActivityStatusEnum implements EnumBase {

	ENABLED("有效"),

	PAUSED("暂停"),

	DISABLED("无效");

	private ActivityStatusEnum(String message) {
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
		return 0;
	}

}
