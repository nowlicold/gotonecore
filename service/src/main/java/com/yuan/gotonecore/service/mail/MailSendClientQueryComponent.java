package com.yuan.gotonecore.service.mail;

/**
 * 邮件发送客户端查询组件
 * 
 * @author cold
 * 
 * @version $Id: MailSendClientQueryComponent.java, v 0.1 2011-1-26 下午01:19:29
 *          cold Exp $
 */
public interface MailSendClientQueryComponent {
	/**
	 * 判断client是否活跃
	 * 
	 * @param clientId
	 * @return
	 */
	public boolean isLive(String clientId);
}
