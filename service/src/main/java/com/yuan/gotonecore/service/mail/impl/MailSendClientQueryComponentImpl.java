/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.service.mail.impl;
import com.bench.lang.base.string.utils.StringUtils;
import com.yuan.gotonecore.common.enums.MailSendClientStatusEnum;
import com.yuan.gotonecore.repository.mapper.MailSendClientMapper;
import com.yuan.gotonecore.service.mail.MailSendClientQueryComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author cold
 * 
 * @version $Id: MailSendClientQueryComponentImpl.java, v 0.1 2012-10-29
 *          下午4:37:31 cold Exp $
 */
@Service
public class MailSendClientQueryComponentImpl implements MailSendClientQueryComponent {
	@Autowired
	private MailSendClientMapper gtMailSendClientMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bench.app.gotone.core.service.client.MailSendClientQueryComponent
	 * #isLive(java.lang.String)
	 */
	public boolean isLive(String clientId) {
		// TODO Auto-generated method stub
		return StringUtils.equals(gtMailSendClientMapper.selectStatusByClientId(clientId), MailSendClientStatusEnum.LIVE.name());
	}

}
