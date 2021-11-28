/**
 * Bench.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.service.template;

import com.yuan.gotonecore.api.result.GotoneCoreServiceResult;
import com.yuan.gotonecore.common.GotoneCoreModel;
import com.yuan.gotonecore.common.enums.GtMessageTypeEnum;
import com.yuan.gotonecore.common.exceptions.GotoneCoreException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * 沟通消息监听发送端处理模板接口实现
 * 
 * @author zouyuxia
 *
 * @version $Id: MessageSenderTemplateImpl.java, v 0.1 2017年2月27日 上午11:14:39
 *          zouyuxia Exp $
 */
@Service
public class MessageSenderTemplateImpl implements MessageSenderTemplate {

	@Autowired
	private TransactionTemplate transactionTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @seecom.Bench.gotone.core.service.template.MessageSenderTemplate#
	 * sendMessageWithTransaction
	 * (com.Bench.gotone.common.service.enums.GtMessageTypeEnum, long,
	 * com.Bench.gotone.core.service.template.MessageSenderCallback)
	 */
	public GotoneCoreServiceResult sendMessage(final GtMessageTypeEnum msgType, final long id, final MessageSenderCallback senderCallback) {
		final GotoneCoreServiceResult result = new GotoneCoreServiceResult();
		result.setSuccess(true);
		result.setId(id);
		transactionTemplate.execute(new TransactionCallback<GotoneCoreServiceResult>() {
			public GotoneCoreServiceResult doInTransaction(TransactionStatus status) {
				try {
					// 锁定并加载模型
					GotoneCoreModel gotoneModel = senderCallback.lockModel(id);
					// 执行发送处理
					GotoneCoreServiceResult sendResult = senderCallback.sendMessage(gotoneModel);

					// 发送后处理
					if (sendResult.isSuccess()) {
						senderCallback.dealAfterSendSuccess(sendResult, gotoneModel);
						return result;
					} else {
						senderCallback.dealAfterSendFailed(sendResult, gotoneModel);
						result.setSuccess(false);
						result.setDetailMessage(sendResult.getDetailMessage());
						result.setErrorCode(sendResult.getErrorCode());
						return result;
					}

				} catch (GotoneCoreException e) {
					status.setRollbackOnly();
					result.setSuccess(false);
					result.setErrorCode(e.getErrorCode());
					result.setDetailMessage(e.getMessage());
					return result;
				}
			}
		});
		return result;
	}

}
