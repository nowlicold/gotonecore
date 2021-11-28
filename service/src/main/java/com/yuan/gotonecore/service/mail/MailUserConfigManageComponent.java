/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.service.mail;
import com.yuan.gotonecore.api.request.MailUserConfigAddRequest;
import com.yuan.gotonecore.api.request.MailUserConfigModifyRequest;
import com.yuan.gotonecore.api.result.MailUserConfigOperateResult;
import com.yuan.gotonecore.common.enums.MailUserConfigStatusEnum;

/**
 * 邮件发送用户配置管理组件
 * 
 * @author cold
 * 
 * @version $Id: MailUserConfigManageComponent.java, v 0.1 2012-10-25 下午6:16:40
 *          cold Exp $
 */
public interface MailUserConfigManageComponent {

	/**
	 * 新增邮件用户配置
	 * 
	 * @param request
	 * @return
	 */
	public MailUserConfigOperateResult add(MailUserConfigAddRequest request);

	/**
	 * 新增邮件用户配置
	 * 
	 * @param request
	 * @return
	 */
	public MailUserConfigOperateResult modify(MailUserConfigModifyRequest request);

	/**
	 * 设置状态
	 * 
	 * @param id
	 * @param status
	 * @param operator
	 * @return
	 */
	public MailUserConfigOperateResult setStatus(long id, MailUserConfigStatusEnum status, String operator);

}
