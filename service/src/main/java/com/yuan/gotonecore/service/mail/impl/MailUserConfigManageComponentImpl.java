/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.service.mail.impl;
import com.bench.runtime.convert.ConverterManager;
import com.yuan.gotonecore.api.request.MailUserConfigAddRequest;
import com.yuan.gotonecore.api.request.MailUserConfigModifyRequest;
import com.yuan.gotonecore.api.result.MailUserConfigOperateResult;
import com.yuan.gotonecore.common.enums.ErrorCodeEnum;
import com.yuan.gotonecore.common.enums.MailUserConfigStatusEnum;
import com.yuan.gotonecore.repository.entity.MailUserConfigDO;
import com.yuan.gotonecore.repository.mapper.MailUserConfigMapper;
import com.yuan.gotonecore.service.mail.MailUserConfigManageComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author cold
 * 
 * @version $Id: MailUserConfigManageComponentImpl.java, v 0.1 2012-10-26
 *          下午2:03:06 cold Exp $
 */
@Service
public class MailUserConfigManageComponentImpl implements MailUserConfigManageComponent {
	@Autowired
	private MailUserConfigMapper mailUserConfigMapper;

	@Autowired
	private ConverterManager converterManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bench.app.gotone.core.service.common.MailUserConfigManageComponent
	 * #add (com.bench.app.gotone.common.service.facade.request.
	 * MailUserConfigAddRequest )
	 */
	public MailUserConfigOperateResult add(MailUserConfigAddRequest request) {
		// TODO Auto-generated method stub
		MailUserConfigOperateResult result = new MailUserConfigOperateResult();
		result.setSuccess(true);
		if (mailUserConfigMapper.selectCountByFromAddAndMailServerId(request.getMailServerId(), request.getFromAddr()) > 0) {
			result.setSuccess(false);
			result.setErrorCode(ErrorCodeEnum.MAIL_USER_CONFIG_EXISTED.errorCode());
			return result;
		}

		MailUserConfigDO mailUserDO = new MailUserConfigDO();
		converterManager.convert(request, mailUserDO);
		mailUserDO.setServersideEnabled(true);
		mailUserDO.setStatus(MailUserConfigStatusEnum.ENABLED.name());
		result.setId(mailUserConfigMapper.insert(mailUserDO));
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bench.app.gotone.core.service.common.MailUserConfigManageComponent
	 * #modify(com.bench.app.gotone.common.service.facade.request.
	 * MailUserConfigModifyRequest)
	 */
	public MailUserConfigOperateResult modify(MailUserConfigModifyRequest request) {
		// TODO Auto-generated method stub
		MailUserConfigOperateResult result = new MailUserConfigOperateResult();
		result.setSuccess(true);
		MailUserConfigDO userConfigDO = this.mailUserConfigMapper.selectById(request.getId());
		if (userConfigDO == null) {
			result.setSuccess(false);
			result.setErrorCode(ErrorCodeEnum.MAIL_USER_CONFIG_NOT_EXISTS.errorCode());
			return result;
		}
		this.mailUserConfigMapper.modify(request.getPassword(), request.getFromAddr(), request.getMailServerId(), request.getFromName(), request.getUserType(),
				request.getStatus().name(), request.isServersideEnabled(), request.getServiceSideDisabledReason(), request.getId());
		result.setId(request.getId());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bench.app.gotone.core.service.common.MailUserConfigManageComponent
	 * #setStatus(long,
	 * com.bench.app.gotone.core.model.enums.MailUserConfigStatusEnum,
	 * java.lang.String)
	 */
	public MailUserConfigOperateResult setStatus(long id, MailUserConfigStatusEnum status, String operator) {
		// TODO Auto-generated method stub
		MailUserConfigOperateResult result = new MailUserConfigOperateResult();
		result.setSuccess(true);
		MailUserConfigDO userConfigDO = this.mailUserConfigMapper.selectById(id);
		if (userConfigDO == null) {
			result.setSuccess(false);
			result.setErrorCode(ErrorCodeEnum.MAIL_USER_CONFIG_NOT_EXISTS.errorCode());
			return result;
		}
		this.mailUserConfigMapper.modifyStatus(status.name(), id);
		return result;
	}
}
