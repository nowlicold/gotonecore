/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.common.app.enums;

import com.bench.common.enums.EnumBase;

/**
 * 
 * 应用状态
 * 
 * @author cold
 *
 * @version $Id: AppConfigStatusEnum.java, v 0.1 2015年9月16日 下午4:50:10 cold
 *          Exp $
 */
public enum AppConfigStatusEnum implements EnumBase {

	ENABLED("有效"),

	DISABLED("无效");

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

	private AppConfigStatusEnum(String message) {
		this.message = message;
	}

}
