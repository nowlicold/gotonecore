package com.yuan.gotonecore.service.mail;

import com.yuan.gotonecore.api.request.MailSendClientRegisterRequest;
import com.yuan.gotonecore.api.result.MailSendClientOperateResult;
import com.yuan.gotonecore.api.result.MailSendClientRegisterResult;

/**
 * 邮件发送客户端管理组件
 * 
 * @author cold
 * 
 * @version $Id: MailSendClientComponent.java, v 0.1 2011-1-26 下午01:19:29
 *          cold Exp $
 */
public interface MailSendClientManageComponent {

	/**
	 * 注册邮件发送客户端
	 * 
	 * @param request
	 * @return
	 */
	public MailSendClientRegisterResult register(MailSendClientRegisterRequest request);

	/**
	 * 邮件客户端心跳通知
	 * 
	 * @param clientId
	 */
	public MailSendClientOperateResult notifyLive(String clientId);

	/**
	 * 客户端死亡通知
	 * 
	 * @param clientId
	 */
	public void notifyDead(String clientId);

}
