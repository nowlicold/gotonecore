/**
 * Bench.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.service.template;

import com.yuan.gotonecore.api.result.GotoneCoreServiceResult;
import com.yuan.gotonecore.common.enums.GtMessageTypeEnum;


/**
 * 沟通消息监听发送端处理模板接口
 * 
 * @author zouyuxia
 *
 * @version $Id: MessageSenderTemplate.java, v 0.1 2017年2月27日 上午11:14:21 zouyuxia Exp $
 */
public interface MessageSenderTemplate {

	/**
	 * 带事务的消息发送处理流程
	 * 
	 * @param msgType
	 * @param id
	 * @param senderCallback
	 */
	public GotoneCoreServiceResult sendMessage(GtMessageTypeEnum msgType, long id,
											   MessageSenderCallback senderCallback);
}
