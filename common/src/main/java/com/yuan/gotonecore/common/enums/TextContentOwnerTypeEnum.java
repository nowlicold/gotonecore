package com.yuan.gotonecore.common.enums;

import com.bench.common.enums.EnumBase;

/**
 * 文本所有者类型枚举
 * 
 * @author cold
 * 
 * @version $Id: TextContentOwnerTypeEnum.java, v 0.1 2011-1-23 下午03:30:31
 *          cold Exp $
 */
public enum TextContentOwnerTypeEnum implements EnumBase {

	VM("VM");

	private String message;

	private TextContentOwnerTypeEnum(String message) {
		this.message = message;
	}

	public String message() {
		// TODO Auto-generated method stub
		return message;
	}

	public Number value() {
		// TODO Auto-generated method stub
		return 0;
	}
}
