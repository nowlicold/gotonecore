/*
 * Bench.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.common.enums;


import com.bench.common.enums.EnumBase;

/**
 * 通知事件主题常量
 * 
 * @author cold
 * 
 * @version $Id: EventTopicEnum.java, v 0.1 2009-9-16 下午02:35:58 min.weixm Exp $
 */
public enum EventNameEnum implements EnumBase {

	/* 邮件发送后事件 */
	EVT_MAIL_SEND_SUCCESS_EVENT(),
	;

	@Override
	public String message() {
		return null;
	}

	@Override
	public Number value() {
		return null;
	}
}
