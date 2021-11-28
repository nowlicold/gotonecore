/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.service.mail.impl;
import com.yuan.gotonecore.api.request.MailSendClientRegisterRequest;
import com.yuan.gotonecore.api.result.MailSendClientOperateResult;
import com.yuan.gotonecore.api.result.MailSendClientRegisterResult;
import com.yuan.gotonecore.service.mail.MailSendClientManageComponent;
import org.springframework.stereotype.Service;

/**
 * TODO 先不实现
 * 
 * @author yiyi
 *
 * @version $Id: MailSendClientManageComponentImpl.java, v 0.1 2018年4月22日
 *          下午5:30:11 yiyi Exp $
 */
@Service
public class MailSendClientManageComponentImpl implements MailSendClientManageComponent {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bench.app.gotone.core.base.core.service.service.mail.
	 * MailSendClientManageComponent
	 * #register(com.bench.app.gotone.core.base.facade
	 * .api.request.MailSendClientRegisterRequest)
	 */
	@Override
	public MailSendClientRegisterResult register(MailSendClientRegisterRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bench.app.gotone.core.base.core.service.service.mail.
	 * MailSendClientManageComponent#notifyLive(java.lang.String)
	 */
	@Override
	public MailSendClientOperateResult notifyLive(String clientId) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bench.app.gotone.core.base.core.service.service.mail.
	 * MailSendClientManageComponent#notifyDead(java.lang.String)
	 */
	@Override
	public void notifyDead(String clientId) {
		// TODO Auto-generated method stub

	}

}
