/*
 * Bench.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.service.mail;

import com.yuan.gotonecore.api.request.MailSendRequest;
import com.yuan.gotonecore.api.result.GotoneCoreServiceResult;

/**
 * 邮件接口
 * 
 * @author cold
 * 
 * @version $Id: SendMailService.java, v 0.1 2009-9-06 下午02:35:58 cold Exp
 *          $
 */
public interface SendMailService {
	/**
	 * 发送邮件消息
	 * 
	 * @return boolean
	 * @param
	 */
	 GotoneCoreServiceResult doMailSend(MailSendRequest request);
	
}
