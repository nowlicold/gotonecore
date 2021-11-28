/*
 * Bench.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.service.mail;


import com.yuan.gotonecore.api.result.GotoneCoreServiceResult;

/**
 * 邮件发送数据处理
 * 
 * @author cold
 * 
 * @version $Id: GotoneOperationComponent.java, v 0.1 2009-10-08 下午02:35:58
 *          cold Exp $
 */
public interface MailOperationComponent {

	/**
	 * 捞取数据并执行
	 * 
	 * @param id
	 * @return
	 */
	public GotoneCoreServiceResult executeSend(long id);
	
	
	
	/**
	 * 根据所传的邮件内容直接发送邮件
	 * @param id
	 * @return
	 */
	public GotoneCoreServiceResult executeSendNow(long id);


}
