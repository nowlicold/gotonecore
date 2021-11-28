package com.yuan.gotonecore.common.enums;

import com.bench.common.enums.EnumBase;

/**
 * 验证码通道枚举
 * 
 * @author cold
 *
 * @version $Id: ValidateCodeChannelEnum.java, v 0.1 2015年5月21日 下午8:52:05
 *          cold Exp $
 */
public enum ValidateCodeChannelEnum implements EnumBase {

	WEIXIN("微信"), ;

	private ValidateCodeChannelEnum(String message) {
		this.message = message;
	}

	private String message;

	public String message() {
		// TODO Auto-generated method stub
		return message;
	}

	public Number value() {
		// TODO Auto-generated method stub
		return null;
	}
}
