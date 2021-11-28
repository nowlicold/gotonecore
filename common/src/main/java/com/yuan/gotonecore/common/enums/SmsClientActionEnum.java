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
 * @version $Id: SmsClientActionEnum.java, v 0.1 2014-9-27 下午3:36:16 cold Exp
 *          $
 */
public enum SmsClientActionEnum implements EnumBase {

	LOGIN("登录"), ;

	private String message;

	private SmsClientActionEnum(String message) {
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
