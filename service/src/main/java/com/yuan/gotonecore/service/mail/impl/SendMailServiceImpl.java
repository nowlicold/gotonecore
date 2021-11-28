/*
 * Bench.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.service.mail.impl;
import com.bench.lang.base.properties.utils.PropertiesUtils;
import com.bench.lang.base.string.utils.StringUtils;
import com.bench.lang.base.velocity.VelocityHelper;
import com.bench.runtime.convert.ConverterManager;
import com.yuan.gotonecore.api.request.MailSendRequest;
import com.yuan.gotonecore.api.result.GotoneCoreServiceResult;
import com.yuan.gotonecore.common.Activity;
import com.yuan.gotonecore.common.enums.ErrorCodeEnum;
import com.yuan.gotonecore.common.enums.MailBodyPatternTypeEnum;
import com.yuan.gotonecore.common.enums.MessageStatusEnum;
import com.yuan.gotonecore.common.exceptions.GotoneCoreException;
import com.yuan.gotonecore.common.mail.MailConfig;
import com.yuan.gotonecore.repository.entity.MailOutBodyDO;
import com.yuan.gotonecore.repository.entity.MailOutDO;
import com.yuan.gotonecore.repository.mapper.MailOutBodyMapper;
import com.yuan.gotonecore.repository.mapper.MailOutMapper;
import com.yuan.gotonecore.service.ActivityQueryComponent;
import com.yuan.gotonecore.service.MsgResendTimeTool;
import com.yuan.gotonecore.service.mail.MailConfigQueryComponent;
import com.yuan.gotonecore.service.mail.MailOperationComponent;
import com.yuan.gotonecore.service.mail.SendMailService;
import com.yuan.gotonecore.service.validator.MailValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.concurrent.Executor;

/**
 * Gotone邮件接口实现类
 * 
 * @author cold
 * 
 * @version $Id: SendMailServiceImpl.java, v 0.1 2009-9-06 下午02:35:58 cold Exp $
 */
@Service
@Slf4j
public class SendMailServiceImpl implements SendMailService {

	/** logger */

	// ---------------------- 验证器 -----------------//
	/** 邮件入参验证器 */
	@Autowired
	private MailValidator mailValidator;

	@Autowired
	private ConverterManager converterManager;

	@Autowired
	private MailConfigQueryComponent mailConfigQueryComponent;

	@Autowired
	private ActivityQueryComponent activityQueryComponent;
	@Autowired
	private MsgResendTimeTool msgResendTimeTool;
	@Autowired
	private MailOutMapper mailOutMapper;
	@Autowired
	protected TransactionTemplate transactionTemplate;
	@Autowired
	private MailOutBodyMapper mailOutBodyMapper;

	/**
	 * 发送邮件线程执行器
	 */
	@Autowired
	private Executor sendMailThreadPoolExecutor;

	@Autowired
	private MailOperationComponent mailOperationComponent;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.Bench.gotone.common.service.facade.BenchGotoneGatewayFacade# doMailSend ( com.Bench.gotone.common.service.enums.domain.communication. MailMessageBody )
	 */
	public GotoneCoreServiceResult doMailSend(MailSendRequest request) {

		if (log.isInfoEnabled()) {
			log.info("准备邮件发送：request=" + request);
		}
		GotoneCoreServiceResult result = new GotoneCoreServiceResult();

		// 验证地址
		try {
			mailValidator.validateAddress(request.getReceiver());
		} catch (GotoneCoreException e) {
			result.setSuccess(false);
			result.setErrorCode(e.getErrorCode());
			result.setDetailMessage(e.getMessage());
			return result;
		}

		// 判断该邮件发送请求若是自带内容：则自带内容发送方式
		if (StringUtils.isNotEmpty(request.getMailContent()) && StringUtils.equals(request.getMailBodyPattern().name(), MailBodyPatternTypeEnum.BY_CONTENT.name())) {
			// 保存到数据库

			Activity bodyActivity = null;
			MailConfig subjectMailConfig = null;
			if (!StringUtils.isEmpty(request.getActivityCode())) { // 设置活动id,这种情况可以没有后面默认设置为2
				bodyActivity = activityQueryComponent.getCachedByCode(request.getActivityCode());
				if (bodyActivity == null) {
					result.setSuccess(false);
					result.setErrorCode(ErrorCodeEnum.ACTIVITY_NOT_EXISTS.errorCode());
					return result;
				}
			}

			MailOutDO mailOutDO = new MailOutDO();
			converterManager.convert(request, mailOutDO);
			if (bodyActivity != null) {
				mailOutDO.setActivityId(bodyActivity.getId());
			} else {
				mailOutDO.setActivityId(2);
			}

			// 设置邮件主题
			if (!StringUtils.isEmpty(request.getMailSubject())) { // 自带了邮件主题
				mailOutDO.setMailSubject(request.getMailSubject());
			} else { // 选择自带内容发送，但是没带邮件主题 ：则根据带来的MailConfigName拿指定的邮件配置主题
				if (!StringUtils.isEmpty(request.getMailConfigName())) {
					subjectMailConfig = mailConfigQueryComponent.getCachedMailConfigByConfigName(request.getMailConfigName());
					if (subjectMailConfig == null) {
						result.setSuccess(false);
						result.setErrorCode(ErrorCodeEnum.MAIL_CONFIG_NOT_EXISTS.errorCode());
						return result;
					}
					mailOutDO.setMailSubject(subjectMailConfig.getSubject());
				} else { // 都没传过来，则直接报错：无法确定邮件主题
					result.setSuccess(false);
					result.setErrorCode(ErrorCodeEnum.MAIL_NOT_SUBJECT.errorCode());
					return result;
				}

			}

			mailOutDO.setStatus(MessageStatusEnum.I.name());
			mailOutDO.setGmtResend(msgResendTimeTool.getGmtResend(0));
			mailOutDO.setMailBodyPattern(request.getMailBodyPattern().name());
			final long mailOutId = mailOutMapper.insert(mailOutDO);

			MailOutBodyDO mailOutBodyDO = new MailOutBodyDO();
			mailOutBodyDO.setId(mailOutId);
			mailOutBodyDO.setMailBody(request.getMailContent());
			mailOutBodyMapper.insert(mailOutBodyDO);

			result.setId(mailOutId);
			// 如果是立即发送的,则马上发送
			if (request.getChannel().sendImmediately()) {
				sendMailThreadPoolExecutor.execute(new Runnable() {
					@Override
					public void run() {
						mailOperationComponent.executeSendNow(mailOutId);

					}
				});
			}
			result.setSuccess(true);
			return result;
		} else { // 否则就是模板渲染发送：
			MailConfig mailConfig = null;
			Activity activity = null;
			if (!StringUtils.isEmpty(request.getMailConfigName())) {
				mailConfig = mailConfigQueryComponent.getCachedMailConfigByConfigName(request.getMailConfigName());
				if (mailConfig == null) {
					result.setSuccess(false);
					result.setErrorCode(ErrorCodeEnum.MAIL_CONFIG_NOT_EXISTS.errorCode());
					return result;
				}
				activity = activityQueryComponent.getById(mailConfig.getActivityId());
			} else if (!StringUtils.isEmpty(request.getActivityCode())) {
				activity = activityQueryComponent.getCachedByCode(request.getActivityCode());
				if (activity == null) {
					result.setSuccess(false);
					result.setErrorCode(ErrorCodeEnum.ACTIVITY_NOT_EXISTS.errorCode());
					return result;
				}
				mailConfig = mailConfigQueryComponent.getCachedRandomEnabledMailConfigByActivityId(activity.getId());
				if (mailConfig == null) {
					result.setSuccess(false);
					result.setErrorCode(ErrorCodeEnum.MAIL_CONFIG_NOT_EXISTS.errorCode());
					return result;
				}
			}
			// 保存到数据库
			MailOutDO mailOutDO = new MailOutDO();
			converterManager.convert(request, mailOutDO);
			mailOutDO.setTemplateArgs(PropertiesUtils.convert2String(request.getTemplateArgs(), false));
			mailOutDO.setActivityId(activity.getId());
			mailOutDO.setMailConfigId(mailConfig.getId());
			mailOutDO.setMailSubject(VelocityHelper.getInstance().evaluate(request.getTemplateArgs(), mailConfig.getSubject()));
			mailOutDO.setStatus(MessageStatusEnum.I.name());
			mailOutDO.setGmtResend(msgResendTimeTool.getGmtResend(0));
			mailOutDO.setMailBodyPattern(MailBodyPatternTypeEnum.BY_TEMPLATE.name());
			final long mailOutId = mailOutMapper.insert(mailOutDO);
			result.setId(mailOutId);

			// 如果是立即发送的,则马上发送
			if (request.getChannel().sendImmediately()) {
				sendMailThreadPoolExecutor.execute(new Runnable() {
					@Override
					public void run() {
						mailOperationComponent.executeSend(mailOutId);

					}
				});

			}
			result.setSuccess(true);
			return result;
		}

	}

}
