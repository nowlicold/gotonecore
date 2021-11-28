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
 * @version $Id: GotoneChannelEnum.java, v 0.1 2011-1-27 下午03:22:49 cold Exp
 *          $
 */
public enum GotoneCoreChannelEnum implements EnumBase {

	DEFAULT("默认通道", true),

	EDM("EDM通道", false), ;

	/**
	 * 是否立即发送
	 */
	private boolean sendImmediately;

	private String message;

	private GotoneCoreChannelEnum(String message, boolean sendImmediately) {
		this.message = message;
		this.sendImmediately = sendImmediately;
	}

	public boolean sendImmediately() {
		// TODO Auto-generated method stub
		return sendImmediately;
	}

	public String message() {
		// TODO Auto-generated method stub
		return message;
	}

	public Number value() {
		// TODO Auto-generated method stub
		return null;
	}

}
