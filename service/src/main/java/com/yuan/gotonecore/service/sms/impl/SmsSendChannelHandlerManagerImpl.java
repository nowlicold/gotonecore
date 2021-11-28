/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.service.sms.impl;

import java.util.List;

import com.yuan.gotonecore.api.sms.model.enums.SmsChannelEnum;
import com.yuan.gotonecore.service.sms.channel.SmsChannelHandler;
import com.yuan.gotonecore.service.sms.channel.SmsSendChannelHandlerManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 
 * @author fangbianmian
 *
 * @version $Id: SmsSendChannelHandlerManagerImpl.java, v 0.1 2017年2月24日
 *          上午10:34:25 Administrator Exp $
 */
@Service
@Slf4j
public class SmsSendChannelHandlerManagerImpl implements SmsSendChannelHandlerManager {


	/**
	 * 短信通道处理类集合
	 */
	private List<SmsChannelHandler> handlers;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bench.app.gotone.core.service.sms.channel.
	 * SmsSendChannelHandlerManager
	 * #getChannelHandler(com.bench.app.gotone.core.model.enums.SmsChannleEnum)
	 */
	public SmsChannelHandler getChannelHandler(SmsChannelEnum channel) {
		for (SmsChannelHandler handler : handlers) {
			if (handler.support(channel))
				return handler;
		}
		log.error("无法找到短信通道处理类,channel=" + channel);
		return null;
	}
}
