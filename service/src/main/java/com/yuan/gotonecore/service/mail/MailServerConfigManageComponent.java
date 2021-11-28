package com.yuan.gotonecore.service.mail;

import com.yuan.gotonecore.api.request.MailServerConfigAddRequest;
import com.yuan.gotonecore.api.request.MailServerConfigModifyRequest;
import com.yuan.gotonecore.api.result.MailServerConfigOperateResult;

/**
 * 
 * 邮件服务器配置管理组件
 * 
 * @author cold
 * 
 * @version $Id: MailServerConfigManageComponent.java, v 0.1 2010-12-10
 *          下午07:10:48 cold Exp $
 */
public interface MailServerConfigManageComponent {

	/**
	 * 新增邮件通道配置
	 * 
	 * @param request
	 * @return
	 */
	public MailServerConfigOperateResult add(MailServerConfigAddRequest request);

	/**
	 * 修改邮件通道
	 * 
	 * @param request
	 * @return
	 */
	public MailServerConfigOperateResult modify(MailServerConfigModifyRequest request);

}
