/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.service.mail;

/**
 * 
 * @author cold
 * 
 * @version $Id: RegisterKeyComponent.java, v 0.1 2011-1-28 上午11:24:34 cold
 *          Exp $
 */
public interface RegisterKeyComponent {

	/**
	 * 邮件发送客户端注册key在config表中的名称
	 */
	public static final String MAIL_SEND_CLIENT_REGISTER_KEY_CONFIG_NAME = "MAIL_SEND_CLIENT_REGISTER_KEY";

	/**
	 * 短信发送客户端注册key在config表中的名称
	 */
	public static final String SMS_SEND_CLIENT_REGISTER_KEY_CONFIG_NAME = "SMS_SEND_CLIENT_REGISTER_KEY";

	public boolean validateKey(String key, String configName);
}
