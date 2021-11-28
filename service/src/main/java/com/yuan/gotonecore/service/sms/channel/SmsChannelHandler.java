/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.service.sms.channel;

import com.yuan.gotonecore.api.sms.model.enums.SmsChannelEnum;
import com.yuan.gotonecore.api.sms.result.SmsResult;
import com.yuan.gotonecore.repository.entity.SmsOutDO;

/**
 * 短信通道处理器
 * 
 * @author cold
 *
 * @version $Id: SmsChannelHandler.java, v 0.1 2017年2月24日 上午9:28:29
 *          Administrator Exp $
 */
public interface SmsChannelHandler {

	/**
	 * 是否支持
	 * 
	 * @param channel
	 * @return
	 */
	public boolean support(SmsChannelEnum channel);

	/**
	 * 发送短信
	 * 
	 * @param mobile
	 *            手机号
	 * @param message
	 *            短信内容
	 * @param smsOutDO
	 *            短信Id
	 */
	public SmsResult send(String[] mobile, String message, SmsOutDO smsOutDO);
}
