/*
 * Bench.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.service.mail;

import com.yuan.gotonecore.api.request.MailConfigAddRequest;
import com.yuan.gotonecore.api.request.MailConfigModifyRequest;
import com.yuan.gotonecore.api.result.MailConfigOperateResult;

/**
 * 邮件配置管理组件
 * 
 * @author cold
 * 
 * @version $Id: MailConfigManageComponent.java, v 0.1 2012-10-25 下午5:16:25
 *          cold Exp $
 */
public interface MailConfigManageComponent {

	/**
	 * 注册邮件配置
	 * 
	 * @param
	 */
	public MailConfigOperateResult add(MailConfigAddRequest request);

	/**
	 * 修改邮件配置
	 * 
	 * @param
	 */
	public MailConfigOperateResult modify(MailConfigModifyRequest request);

}
