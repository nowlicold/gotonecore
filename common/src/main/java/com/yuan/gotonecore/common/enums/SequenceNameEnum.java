/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.common.enums;

import com.bench.common.enums.EnumBase;

/**
 * 序列名枚举
 * @author cold
 *
 * @version $Id: SequenceNameEnum.java, v 0.1 2018年9月14日 上午11:22:21 cold Exp $
 */
public enum SequenceNameEnum implements EnumBase {
	;

	private String message;

	SequenceNameEnum(String message) {
		this.message = message;
	}

	@Override
	public String message() {
		// TODO Auto-generated method stub
		return message;
	}

	@Override
	public Number value() {
		// TODO Auto-generated method stub
		return null;
	}
}
