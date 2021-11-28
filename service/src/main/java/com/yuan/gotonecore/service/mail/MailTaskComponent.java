/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.service.mail;

import com.yuan.gotonecore.common.MailTaskEntry;
import com.yuan.gotonecore.common.enums.ErrorCodeEnum;
import com.yuan.gotonecore.common.exceptions.GotoneCoreException;

import java.util.List;

/**
 * 邮件任务Task，响应client发送的模式
 * 
 * @author cold
 * 
 * @version $Id: MailTaskComponent.java, v 0.1 2011-1-27 下午08:12:30 cold Exp
 *          $
 */
public interface MailTaskComponent {

	/**
	 * 客户端获取要执行的邮件列表，邮件由P状态变更为E状态,如果客户端已死亡，则返回空列表
	 * 
	 * @param clientId
	 * @return
	 */
	public List<MailTaskEntry> clientGetForExecute(String clientId);

	/**
	 * 邮件发送完毕通知
	 *  @param clientId
	 * @param mailId
	 */
	public ErrorCodeEnum notifySendFinish(String clientId, Integer mailId);

	/**
	 * 获取合并后的邮件内容
	 * 
	 * @param mailId
	 * @return
	 */
	public String getRenderedMailContent(String clientId, Integer mailId) throws GotoneCoreException;

}
