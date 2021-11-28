/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.service.mail.impl;

import com.bench.runtime.convert.ConverterManager;
import com.yuan.gotonecore.api.request.MailServerConfigAddRequest;
import com.yuan.gotonecore.api.request.MailServerConfigModifyRequest;
import com.yuan.gotonecore.api.result.MailServerConfigOperateResult;
import com.yuan.gotonecore.common.enums.ErrorCodeEnum;
import com.yuan.gotonecore.repository.entity.MailServerConfigDO;
import com.yuan.gotonecore.repository.mapper.MailServerConfigMapper;
import com.yuan.gotonecore.service.mail.MailServerConfigManageComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author cold
 * 
 * @version $Id: TransportConfigComponentImpl.java, v 0.1 2010-12-10 下午07:17:51
 *          cold Exp $
 */
@Service
public class MailServerConfigManageComponentImpl implements MailServerConfigManageComponent {

	@Autowired
	private ConverterManager converterManager;
	@Autowired
	private MailServerConfigMapper mailServerConfigMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bench.app.gotone.core.service.common.TransportConfigComponent#add
	 * (com.
	 * bench.app.gotone.common.service.facade.request.TransportConfigAddRequest)
	 */
	public MailServerConfigOperateResult add(MailServerConfigAddRequest request) {
		// TODO Auto-generated method stub
		MailServerConfigOperateResult result = new MailServerConfigOperateResult();
		result.setSuccess(true);
		// 检查是否存在
		MailServerConfigDO existedMailServerConfigDO = mailServerConfigMapper.selectByHostPort(request.getHost(), request.getPort());
		if (existedMailServerConfigDO != null) {
			result.setSuccess(false);
			result.setId(existedMailServerConfigDO.getId());
			result.setErrorCode(ErrorCodeEnum.MAIL_SERVER_EXISTED.errorCode());
			return result;
		}
		MailServerConfigDO mailServerConfigDO = new MailServerConfigDO();
		this.converterManager.convert(request, mailServerConfigDO);
		long id = this.mailServerConfigMapper.insert(mailServerConfigDO);
		result.setId(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bench.app.gotone.core.service.common.TransportConfigComponent#modify
	 * (com .bench.app.gotone.common.service.facade.request.
	 * TransportConfigModifyRequest )
	 */
	public MailServerConfigOperateResult modify(MailServerConfigModifyRequest request) {
		// TODO Auto-generated method stub
		MailServerConfigOperateResult result = new MailServerConfigOperateResult();
		result.setSuccess(true);
		// 检查是否存在
		MailServerConfigDO existedMailServerConfigDO = mailServerConfigMapper.selectByHostPort(request.getHost(), request.getPort());
		if (existedMailServerConfigDO != null && existedMailServerConfigDO.getId() != request.getId()) {
			result.setSuccess(false);
			result.setId(existedMailServerConfigDO.getId());
			result.setErrorCode(ErrorCodeEnum.MAIL_SERVER_EXISTED.errorCode());
			return result;
		}
		MailServerConfigDO mailServerConfigDO = this.mailServerConfigMapper.selectById(request.getId());
		if (mailServerConfigDO == null) {
			result.setSuccess(false);
			result.setErrorCode(ErrorCodeEnum.MAIL_CONFIG_NOT_EXISTS.errorCode());
			return result;
		}
		this.mailServerConfigMapper
				.modify(request.getHost(), request.getPort(), request.getTimeout(), request.getConnectTimeout(), request.getDomainName(), request.getId());
		result.setId(request.getId());
		return result;
	}

}
