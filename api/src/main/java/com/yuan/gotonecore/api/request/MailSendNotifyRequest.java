/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.api.request;

/**
 * 
 * @author cold
 * 
 * @version $Id: MailSendNotifyRequest.java, v 0.1 2011-1-26 下午01:23:35 cold
 *          Exp $
 */
public class MailSendNotifyRequest {

	/**
	 * 邮件id
	 */
	private long mailId;

	/**
	 * 是否成功
	 */
	private boolean success;

	public long getMailId() {
		return mailId;
	}

	public void setMailId(long mailId) {
		this.mailId = mailId;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
}
