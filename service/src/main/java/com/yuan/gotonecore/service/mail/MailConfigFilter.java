package com.yuan.gotonecore.service.mail;

import com.yuan.gotonecore.common.mail.MailConfig;

/**
 * 邮件配置过滤器
 * 
 * @author cold
 * 
 * @version $Id: MailConfigFilter.java, v 0.1 2012-11-10 下午12:59:39 cold Exp
 *          $
 */
public interface MailConfigFilter {

	/**
	 * 是否接受
	 * 
	 * @param mailConfig
	 * @return
	 */
	public boolean accept(MailConfig mailConfig);
}
