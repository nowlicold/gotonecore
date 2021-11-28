/*
 * Bench.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.service.mail.impl;

import com.bench.runtime.convert.ConverterManager;
import com.yuan.gotonecore.api.request.MailConfigAddRequest;
import com.yuan.gotonecore.api.request.MailConfigModifyRequest;
import com.yuan.gotonecore.api.result.MailConfigOperateResult;
import com.yuan.gotonecore.common.enums.ErrorCodeEnum;
import com.yuan.gotonecore.repository.entity.MailConfigBodyDO;
import com.yuan.gotonecore.repository.entity.MailConfigDO;
import com.yuan.gotonecore.repository.mapper.MailConfigBodyMapper;
import com.yuan.gotonecore.repository.mapper.MailConfigMapper;
import com.yuan.gotonecore.service.mail.MailConfigManageComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * 邮件配置组件实现
 * 
 * <p>
 * 
 * @author cold
 * @version $Id: MailConfigComponentImpl, v 0.1 2009-9-9 下午11:18:01 cold
 *          Exp $
 */
@Service
public class MailConfigManageComponentImpl implements MailConfigManageComponent {
	@Autowired
	private MailConfigMapper mailConfigMapper;
	@Autowired
	private MailConfigBodyMapper mailConfigBodyMapper;

	@Autowired
	private ConverterManager converterManager;
	@Autowired
	private TransactionTemplate transactionTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bench.app.gotone.core.service.common.MailConfigComponent#add(com.
	 * bench.app.gotone.common.service.facade.request.MailConfigAddRequest)
	 */
	public MailConfigOperateResult add(MailConfigAddRequest request) {
		// TODO Auto-generated method stub
		MailConfigOperateResult result = new MailConfigOperateResult();
		result.setSuccess(true);
		if (this.mailConfigMapper.selectByConfigName(request.getConfigName()) != null) {
			result.setSuccess(false);
			result.setErrorCode(ErrorCodeEnum.MAIL_CONFIG_EXISTED.errorCode());
			return result;
		}

		final MailConfigDO mailConfigDO = new MailConfigDO();
		final MailConfigBodyDO mailConfigBodyDO = new MailConfigBodyDO();
		mailConfigBodyDO.setMailContent(request.getContent());
		this.converterManager.convert(request, mailConfigDO);
		Long mailId = (Long) transactionTemplate.execute(new TransactionCallback<Long>() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see org.springframework.transaction.support.TransactionCallback#
			 * doInTransaction
			 * (org.springframework.transaction.TransactionStatus)
			 */
			public Long doInTransaction(TransactionStatus status) {
				// TODO Auto-generated method stub
				long mailId = mailConfigMapper.insert(mailConfigDO);
				mailConfigBodyDO.setId(mailId);
				mailConfigBodyMapper.insert(mailConfigBodyDO);
				return mailId;
			}

		});
		result.setMailId(mailId);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bench.app.gotone.core.service.common.MailConfigComponent#modify(com
	 * .bench.app.gotone.common.service.facade.request.MailConfigModifyRequest)
	 */
	public MailConfigOperateResult modify(final MailConfigModifyRequest request) {
		// TODO Auto-generated method stub
		MailConfigOperateResult result = new MailConfigOperateResult();
		result.setSuccess(true);
		MailConfigDO mailConfigDO = this.mailConfigMapper.selectById(request.getId());
		if (mailConfigDO == null) {
			result.setSuccess(false);
			result.setErrorCode(ErrorCodeEnum.MAIL_CONFIG_NOT_EXISTS.errorCode());
			return result;
		}
		transactionTemplate.execute(new TransactionCallback<Integer>() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see org.springframework.transaction.support.TransactionCallback#
			 * doInTransaction
			 * (org.springframework.transaction.TransactionStatus)
			 */
			public Integer doInTransaction(TransactionStatus status) {
				// TODO Auto-generated method stub
				mailConfigMapper.modify(request.getCharset(), request.getSubject(), request.getFromName(), request.getActivityId(), request.getConfigName(),
						request.isEnabled(), request.getRetryIntervalSeconds(), request.getId());
				mailConfigBodyMapper.modify(request.getContent(), request.getId());
				return 1;
			}

		});
		result.setMailId(request.getId());
		return result;
	}

}
