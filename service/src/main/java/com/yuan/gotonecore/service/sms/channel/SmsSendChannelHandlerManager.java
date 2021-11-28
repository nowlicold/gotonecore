/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.service.sms.channel;


import com.yuan.gotonecore.api.sms.model.enums.SmsChannelEnum;

/**
 * 短信通道处理器管理类
 * 
 * @author cold
 *
 * @version $Id: SmsSendChannelHandlerManager.java, v 0.1 2017年2月24日 上午10:34:33
 *          Administrator Exp $
 */
public interface SmsSendChannelHandlerManager {

	/**
	 * 获取短信通道处理器
	 * 
	 * @param channel
	 * @return
	 */
	public SmsChannelHandler getChannelHandler(SmsChannelEnum channel);
}
