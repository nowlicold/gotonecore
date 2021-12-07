/*
 * Bench.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.service.mail.impl;
import com.bench.lang.base.date.utils.DateUtils;
import com.bench.lang.base.string.utils.StringUtils;
import com.yuan.gotonecore.api.result.GotoneCoreServiceResult;
import com.yuan.gotonecore.common.GotoneCoreModel;
import com.yuan.gotonecore.common.MailModel;
import com.yuan.gotonecore.common.constants.GotoneMaxSendTime;
import com.yuan.gotonecore.common.enums.ErrorCodeEnum;
import com.yuan.gotonecore.common.enums.GtMessageTypeEnum;
import com.yuan.gotonecore.common.enums.MessageStatusEnum;
import com.yuan.gotonecore.common.exceptions.GotoneCoreException;
import com.yuan.gotonecore.common.msg.MsgMailSendSuccessPayload;
import com.yuan.gotonecore.repository.entity.MailOutBodyDO;
import com.yuan.gotonecore.repository.entity.MailOutDO;
import com.yuan.gotonecore.repository.entity.MailOutHistoryBodyDO;
import com.yuan.gotonecore.repository.entity.MailOutHistoryDO;
import com.yuan.gotonecore.repository.mapper.MailOutBodyMapper;
import com.yuan.gotonecore.repository.mapper.MailOutHistoryBodyMapper;
import com.yuan.gotonecore.repository.mapper.MailOutHistoryMapper;
import com.yuan.gotonecore.repository.mapper.MailOutMapper;
import com.yuan.gotonecore.service.mail.MailOperationComponent;
import com.yuan.gotonecore.service.mail.converter.MailConverter;
import com.yuan.gotonecore.service.msg.PushMessageChannel;
import com.yuan.gotonecore.service.template.MessageSenderCallback;
import com.yuan.gotonecore.service.template.MessageSenderTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Date;

/**
 * 邮件发送数据处理
 * 
 * @author cold
 * 
 * @version $Id: GotoneOperationTemplate.java, v 0.1 2009-10-08 下午02:35:58
 *          cold Exp $
 */
@Service
@Slf4j
public class MailOperationComponentImpl implements MailOperationComponent {


	/** mailOutMapper */
	@Autowired
	private MailOutMapper mailOutMapper;
	@Autowired
	private MailOutBodyMapper mailOutBodyMapper;

	/** mailOutHistoryMapper */
	@Autowired
	private MailOutHistoryMapper mailOutHistoryMapper;
	@Autowired
	private MailOutHistoryBodyMapper mailOutHistoryBodyMapper;

	/** transactionTemplate */
	@Autowired
	protected TransactionTemplate transactionTemplate;

	/** 消息发送 */
	@Autowired
	private MessageSenderTemplate messageSenderTemplate;

	/** 事件引擎 */
	@Autowired
	private PushMessageChannel pushMessageChannel;

	@Autowired
	private MailConverter mailConverter;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.Bench.gotone.core.service.component.GotoneOperationComponent#execute
	 * (java.lang.String, boolean)
	 */
	public GotoneCoreServiceResult executeSend(long id) {
		return messageSenderTemplate.sendMessage(GtMessageTypeEnum.MSG_EMAIL, id, new MessageSenderCallback() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see com.bench.app.gotone.core.service.template.
			 * MessageSenderCallback#lockModel(long)
			 */
			public GotoneCoreModel lockModel(long id) throws GotoneCoreException {
				// 加载数据
				MailOutDO mailOutDO = null;
				try {
					mailOutDO = mailOutMapper.findMailMsgByIdForUpdate(id);
				}
				// 如果记录已经锁定则忽略之
				catch (Exception ce) {
					log.error("当前需要处理的数据已经从数据库移除，或被别的服务器已经锁定捞取：id={}",id);
					throw new GotoneCoreException(ErrorCodeEnum.MAIL_OUT_LOCK_FAILED.errorCode(), "当前需要处理的数据已经从数据库移除，或被别的服务器已经锁定捞取：id=" + id);
				}
				// 异常处理
				if (mailOutDO == null) {
					log.error("当前需要处理的数据已经从数据库移除，或被别的服务器已经锁定捞取：id={}",id);
					throw new GotoneCoreException(ErrorCodeEnum.MAIL_OUT_NOT_EXISTS.errorCode(), "当前需要处理的数据已经从数据库移除，或被别的服务器已经锁定捞取：id=" + id);
				}

				return mailConverter.convertToModel(mailOutDO);
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see com.bench.app.gotone.core.service.template.
			 * MessageSenderCallback
			 * #sendMessage(com.bench.app.gotone.core.model.GotoneCoreModel)
			 */
			public GotoneCoreServiceResult sendMessage(GotoneCoreModel gotoneCoreModel) {
				GotoneCoreServiceResult result = new GotoneCoreServiceResult();
				MailModel mailModel = (MailModel) gotoneCoreModel;
				HtmlEmail htmlEmail = null;
				try {
					htmlEmail = constructHtmlEmail(mailModel);
				} catch (GotoneCoreException e) {
					result.setSuccess(false);
					result.setErrorCode(e.getErrorCode());
					result.setDetailMessage(e.getMessage());
					return result;
				}
				// 发邮件
				try {
					htmlEmail.send();
					result.setSuccess(true);
					return result;
				} catch (EmailException e) {
					log.error("邮件发送失败,id=" + mailModel.getId(), e);
					result.setSuccess(false);
					result.setErrorCode(ErrorCodeEnum.MAIL_SEND_ERROR.errorCode());
					result.setDetailMessage(e.getMessage());
					return result;
				}
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see com.bench.app.gotone.core.service.template.
			 * MessageSenderCallback #dealAfterSendSuccess(com.bench.app.gotone
			 * .core.model.result.GotoneCoreServiceResult,
			 * com.bench.app.gotone.core.model.GotoneCoreModel)
			 */
			public void dealAfterSendSuccess(GotoneCoreServiceResult sendResult, GotoneCoreModel gotoneCoreModel) {
				// TODO Auto-generated method stub
				final MailModel mailModel = (MailModel) gotoneCoreModel;
				// 将当前发送记录保存到历史库中
				final MailOutHistoryDO mailHistoryDO = getMailOutHistoryDO(mailModel, MessageStatusEnum.S.name());
				mailHistoryDO.setGmtCreate(null);
				mailHistoryDO.setGmtModified(null);
				final MailOutHistoryBodyDO historyBodyDO = new MailOutHistoryBodyDO();
				historyBodyDO.setId(mailModel.getId());
				historyBodyDO.setMailBody(mailModel.getMailContent());
				transactionTemplate.execute(new TransactionCallback<Integer>() {
					/*
					 * (non-Javadoc)
					 * 
					 * @see org.springframework.transaction.support.
					 * TransactionCallback #doInTransaction(org.springframework
					 * .transaction.TransactionStatus)
					 */
					public Integer doInTransaction(TransactionStatus status) {
						// TODO Auto-generated method stub
						mailOutHistoryMapper.insert(mailHistoryDO);
						mailOutHistoryBodyMapper.insert(historyBodyDO);
						// 删除发送库中的记录
						mailOutMapper.deleteMailMsgById(mailModel.getId());
						// 发送邮件发送成功事件
						MsgMailSendSuccessPayload msgMailSendSuccessPayload = new MsgMailSendSuccessPayload();
						msgMailSendSuccessPayload.setMailOutId(mailModel.getId());
						pushMessageChannel.sendMsgMailSendSuccess().send(MessageBuilder.withPayload(msgMailSendSuccessPayload).build());
						return 1;
					}

				});

			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see com.bench.app.gotone.core.service.template.
			 * MessageSenderCallback #dealAfterSendFailed(com.bench.app.gotone
			 * .core.model.result.GotoneCoreServiceResult,
			 * com.bench.app.gotone.core.model.GotoneCoreModel)
			 */
			public void dealAfterSendFailed(GotoneCoreServiceResult sendResult, GotoneCoreModel gotoneCoreModel) {
				// TODO Auto-generated method stub
				/*
				 * 如果当前发送次数已经达到最大发送次数，将数据迁移至历史库中，并删除邮件重发库中的数据
				 * 同时，将历史库中数据的状态位更新为“F”
				 */
				MailModel mailModel = (MailModel) gotoneCoreModel;
				if (gotoneCoreModel.getSendTimes() >= GotoneMaxSendTime.MAIL_MAX_SEND_TIME) {
					// 将当前发送记录保存到历史库中
					final MailOutHistoryDO mailHistoryDO = getMailOutHistoryDO(mailModel, MessageStatusEnum.F.name());
					final MailOutHistoryBodyDO historyBodyDO = new MailOutHistoryBodyDO();
					historyBodyDO.setId(mailModel.getId());
					historyBodyDO.setMailBody(mailModel.getMailContent());
					// 持久化数据到历史库中
					mailOutHistoryMapper.insert(mailHistoryDO);
					mailOutHistoryBodyMapper.insert(historyBodyDO);
					mailOutMapper.deleteMailMsgById(gotoneCoreModel.getId());

				}
				// 数据发送失败，将数据发送状态置为重试，累积当前发送次数
				else {
					mailOutMapper.updateSendFailed(MessageStatusEnum.R.name(), gotoneCoreModel.getSendTimes() + 1,
							DateUtils.addSeconds(new Date(), mailModel.getMailConfig().getRetryIntervalSeconds()), gotoneCoreModel.getId());
				}
			}

		});
	}

	public GotoneCoreServiceResult executeSendNow(long id) {
		return messageSenderTemplate.sendMessage(GtMessageTypeEnum.MSG_EMAIL, id, new MessageSenderCallback() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see com.bench.app.gotone.core.service.template.
			 * MessageSenderCallback#lockModel(long)
			 */
			public GotoneCoreModel lockModel(long id) throws GotoneCoreException {
				// 加载数据
				MailOutDO mailOutDO = null;
				MailOutBodyDO mailOutBodyDO = null;
				try {
					mailOutDO = mailOutMapper.findMailMsgByIdForUpdate(id);
					mailOutBodyDO = mailOutBodyMapper.selectById(id);
				}
				// 如果记录已经锁定则忽略之
				catch (Exception ce) {
					throw new GotoneCoreException(ErrorCodeEnum.MAIL_OUT_LOCK_FAILED.errorCode(), "当前需要处理的数据已经从数据库移除，或被别的服务器已经锁定捞取：id=" + id);
				}
				// 异常处理
				if (mailOutDO == null) {
					throw new GotoneCoreException(ErrorCodeEnum.MAIL_OUT_NOT_EXISTS.errorCode(), "当前需要处理的数据已经从数据库移除，或被别的服务器已经锁定捞取：id=" + id);
				}

				return mailConverter.convertToBodyModel(mailOutDO, mailOutBodyDO);
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see com.bench.app.gotone.core.service.template.
			 * MessageSenderCallback
			 * #sendMessage(com.bench.app.gotone.core.model.GotoneCoreModel)
			 */
			public GotoneCoreServiceResult sendMessage(GotoneCoreModel gotoneCoreModel) {
				GotoneCoreServiceResult result = new GotoneCoreServiceResult();
				MailModel mailModel = (MailModel) gotoneCoreModel;
				HtmlEmail htmlEmail = null;
				try {
					htmlEmail = constructHtmlEmail(mailModel);
					htmlEmail.setSubject(mailModel.getMailSubject());
				} catch (GotoneCoreException e) {
					result.setSuccess(false);
					result.setErrorCode(e.getErrorCode());
					result.setDetailMessage(e.getMessage());
					return result;
				}
				// 发邮件
				try {
					htmlEmail.send();
					result.setSuccess(true);
					return result;
				} catch (EmailException e) {
					log.error("邮件发送失败,id=" + mailModel.getId(), e);
					result.setSuccess(false);
					result.setErrorCode(ErrorCodeEnum.MAIL_SEND_ERROR.errorCode());
					result.setDetailMessage(e.getMessage());
					return result;
				}
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see com.bench.app.gotone.core.service.template.
			 * MessageSenderCallback #dealAfterSendSuccess(com.bench.app.gotone
			 * .core.model.result.GotoneCoreServiceResult,
			 * com.bench.app.gotone.core.model.GotoneCoreModel)
			 */
			public void dealAfterSendSuccess(GotoneCoreServiceResult sendResult, GotoneCoreModel gotoneCoreModel) {
				// TODO Auto-generated method stub
				final MailModel mailModel = (MailModel) gotoneCoreModel;
				// 将当前发送记录保存到历史库中
				final MailOutHistoryDO mailHistoryDO = getMailOutHistoryDO(mailModel, MessageStatusEnum.S.name());
				final MailOutHistoryBodyDO historyBodyDO = new MailOutHistoryBodyDO();
				historyBodyDO.setId(mailModel.getId());
				historyBodyDO.setMailBody(mailModel.getMailContent());
				transactionTemplate.execute(new TransactionCallback<Integer>() {
					/*
					 * (non-Javadoc)
					 * 
					 * @see org.springframework.transaction.support.
					 * TransactionCallback #doInTransaction(org.springframework
					 * .transaction.TransactionStatus)
					 */
					public Integer doInTransaction(TransactionStatus status) {
						// TODO Auto-generated method stub
						mailOutHistoryMapper.insert(mailHistoryDO);
						mailOutHistoryBodyMapper.insert(historyBodyDO);
						// 删除发送库中的记录
						mailOutMapper.deleteMailMsgById(mailModel.getId());
						mailOutBodyMapper.deleteMailBodyById(mailModel.getId());
						MsgMailSendSuccessPayload msgMailSendSuccessPayload = new MsgMailSendSuccessPayload();
						msgMailSendSuccessPayload.setMailOutId(mailModel.getId());
						pushMessageChannel.sendMsgMailSendSuccess().send(MessageBuilder.withPayload(msgMailSendSuccessPayload).build());
						return 1;
					}

				});

			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see com.bench.app.gotone.core.service.template.
			 * MessageSenderCallback #dealAfterSendFailed(com.bench.app.gotone
			 * .core.model.result.GotoneCoreServiceResult,
			 * com.bench.app.gotone.core.model.GotoneCoreModel)
			 */
			public void dealAfterSendFailed(GotoneCoreServiceResult sendResult, GotoneCoreModel gotoneCoreModel) {
				// TODO Auto-generated method stub
				/*
				 * 如果当前发送次数已经达到最大发送次数，将数据迁移至历史库中，并删除邮件重发库中的数据
				 * 同时，将历史库中数据的状态位更新为“F”
				 */
				MailModel mailModel = (MailModel) gotoneCoreModel;
				if (gotoneCoreModel.getSendTimes() >= GotoneMaxSendTime.MAIL_MAX_SEND_TIME) {
					// 将当前发送记录保存到历史库中
					final MailOutHistoryDO mailHistoryDO = getMailOutHistoryDO(mailModel, MessageStatusEnum.F.name());
					final MailOutHistoryBodyDO historyBodyDO = new MailOutHistoryBodyDO();
					historyBodyDO.setId(mailModel.getId());
					historyBodyDO.setMailBody(mailModel.getMailContent());
					// 持久化数据到历史库中
					mailOutHistoryMapper.insert(mailHistoryDO);
					mailOutHistoryBodyMapper.insert(historyBodyDO);
					// 删除发送表内容
					mailOutMapper.deleteMailMsgById(gotoneCoreModel.getId());
					mailOutBodyMapper.deleteMailBodyById(mailModel.getId());

				}
				// 数据发送失败，将数据发送状态置为重试，累积当前发送次数
				else {
					mailOutMapper.updateSendFailed(MessageStatusEnum.R.name(), gotoneCoreModel.getSendTimes() + 1,
							DateUtils.addSeconds(new Date(), mailModel.getMailConfig().getRetryIntervalSeconds()), gotoneCoreModel.getId());
				}
			}

		});
	}

	private HtmlEmail constructHtmlEmail(MailModel model) throws GotoneCoreException {

		HtmlEmail email = new HtmlEmail();
		email.setHostName(model.getMailServerConfig().getHost());
		email.setSmtpPort(model.getMailServerConfig().getPort());
		addMailTo(email, model.getReceiver());
		String fromName = model.getSendMailUserConfig().getFromName();
		if (StringUtils.isEmpty(fromName)) {
			fromName = model.getMailConfig().getFromName();
			if (StringUtils.isEmpty(fromName)) {
				fromName = model.getSendMailUserConfig().getFromAddr();
			}
		}
		try {
			email.setFrom(model.getSendMailUserConfig().getFromAddr(), fromName);
			email.addReplyTo(model.getSendMailUserConfig().getFromAddr());
		} catch (EmailException e) {
			throw new GotoneCoreException(ErrorCodeEnum.MAIL_ADDR_INVALID.errorCode(), "邮件地址不正确,addr=" + model.getSendMailUserConfig().getFromAddr(), e);
		}

		email.setSubject(model.getMailConfig().getSubject());
		// 邮件内容
		try {
			email.setHtmlMsg(model.getMailContent());
		} catch (EmailException e) {
			throw new GotoneCoreException(ErrorCodeEnum.MAIL_MESSAGE_BODY_ERROR.errorCode(), "邮件内容错误,content=" + model.getMailContent(), e);
		}
		// email.setTextMsg("您的邮件客户端 不支持HTML，邮件内容无法显示！");
		String charset = model.getMailConfig().getCharset();
		if (StringUtils.isEmpty(charset)) {
			charset = MailModel.DEFAULT_CAHRSET;
		}
		email.setCharset(((StringUtils.equals("utf-8", charset)) ? MailModel.DEFAULT_CAHRSET : charset));

		// email.setAuthentication(getUserName(model.getSendConfig().getFromAddr()),
		// model.getSendConfig() .getPassword());
		if (model.getSendMailUserConfig().getFromUserword() != null) {
			email.setAuthenticator(new DefaultAuthenticator(model.getSendMailUserConfig().getFromUserword(), model.getSendMailUserConfig().getPassword()));
		} else {
			email.setAuthenticator(new DefaultAuthenticator(getUserName(model.getSendMailUserConfig().getFromAddr()), model.getSendMailUserConfig().getPassword()));
		}

		return email;
	}

	/**
	 * 添加多个邮件接收人
	 * 
	 * @param email
	 * @param to
	 * @throws EmailException
	 */
	private void addMailTo(HtmlEmail email, String to) throws GotoneCoreException {
		String[] addrList = to.split(",");
		for (String toAddr : addrList) {
			try {
				email.addTo(toAddr, toAddr);
			} catch (EmailException e) {
				throw new GotoneCoreException(ErrorCodeEnum.MAIL_ADDR_INVALID.errorCode(), "邮件地址不正确,addr=" + toAddr, e);
			}
		}
	}

	private String getUserName(String emailAddr) {
		int index = emailAddr.indexOf("@");
		if (index > 0) {
			return emailAddr.substring(0, index);
		}
		return emailAddr;
	}

	/**
	 * 构造MailOutHistoryDO
	 *
	 * @param model
	 * @param status
	 * @return
	 */
	private MailOutHistoryDO getMailOutHistoryDO(MailModel model, String status) {

		MailOutHistoryDO gtMailOutHistoryDO = mailConverter.convertModelToHistoryDO(model);
		// 捞取数据的历史库迁移
		gtMailOutHistoryDO.setGmtMailMsgCreate(model.getGmtCreate());

		gtMailOutHistoryDO.setStatus(status);

		return gtMailOutHistoryDO;
	}

}