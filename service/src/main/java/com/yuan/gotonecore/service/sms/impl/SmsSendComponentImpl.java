/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.service.sms.impl;

import com.bench.cache.AppCacheComponent;
import com.bench.lang.base.IpUtils;
import com.bench.lang.base.convert.ConvertManager;
import com.bench.runtime.convert.ConverterManager;
import com.bench.lang.base.date.utils.DateUtils;
import com.bench.lang.base.object.utils.ObjectUtils;
import com.bench.lang.base.properties.utils.PropertiesUtils;
import com.bench.lang.base.string.utils.StringUtils;
import com.bench.lang.base.utils.MobilePhoneNumberUtils;
import com.bench.lang.base.uuid.utils.UUIDUtils;
import com.bench.lang.base.velocity.VelocityHelper;
import com.yuan.gotonecore.api.model.enums.ErrorCodeEnum;
import com.yuan.gotonecore.api.model.enums.MessageStatusEnum;
import com.yuan.gotonecore.api.sms.model.SmsChannelConfig;
import com.yuan.gotonecore.api.sms.model.SmsConfig;
import com.yuan.gotonecore.api.sms.model.SmsConfigInChannel;
import com.yuan.gotonecore.api.sms.model.SmsOutHis;
import com.yuan.gotonecore.api.sms.model.enums.SmsChannelEnum;
import com.yuan.gotonecore.api.sms.request.SmsBatchSendRequest;
import com.yuan.gotonecore.api.sms.request.SmsResendRequest;
import com.yuan.gotonecore.api.sms.request.SmsSendRequest;
import com.yuan.gotonecore.api.sms.result.SmsResult;
import com.yuan.gotonecore.api.sms.result.SmsSendResult;
import com.yuan.gotonecore.repository.entity.SmsOutDO;
import com.yuan.gotonecore.repository.entity.SmsOutHisDO;
import com.yuan.gotonecore.repository.mapper.SmsOutHisMapper;
import com.yuan.gotonecore.repository.mapper.SmsOutMapper;
import com.yuan.gotonecore.service.SmsOutHisQueryComponent;
import com.yuan.gotonecore.service.enums.AppCacheAreaNameEnum;
import com.yuan.gotonecore.service.sms.*;
import com.yuan.gotonecore.service.sms.channel.SmsChannelHandler;
import com.yuan.gotonecore.service.sms.channel.SmsSendChannelHandlerManager;
import com.yuan.gotonecore.service.sms.request.SmsSendFrequencyCheckRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.dao.CannotAcquireLockException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/**
 * @author cold
 * @version $Id: SmsSendComponentImpl.java, v 0.1 2011-9-28 下午04:28:28 cold Exp $
 */
@Service
@Slf4j
public class SmsSendComponentImpl implements SmsSendComponent {

	private String[] ACK_CODE_TAGS = new String[] { "${ackCode}", "$ackCode", "${!ackCode}", "$!ackCode" };

	/**
	 * 带发送短信Mapper
	 */
	@Autowired
	private SmsOutMapper smsOutMapper;

	/**
	 * 已发送短信Mapper
	 */
	@Autowired
	private SmsOutHisMapper smsOutHisMapper;

	/**
	 * 短信配置查询组件
	 */
	@Autowired
	private SmsConfigQueryComponent smsConfigQueryComponent;


	@Autowired
	private AppCacheComponent appCacheComponent;

	/**
	 * 短信通道处理器管理类
	 */
	@Autowired
	private SmsSendChannelHandlerManager smsSendChannelHandlerManager;

	/**
	 * 短信通道配置查询组件
	 */
	@Autowired
	private SmsChannelConfigQueryComponent smsChannelConfigQueryComponent;

	@Autowired
	private SmsConfigInChannelQueryComponent smsConfigInChannelQueryComponent;

	/**
	 * 发送短信线程执行器
	 */
	@Autowired
	private Executor sendSmsThreadPoolExecutor;

	@Autowired
	private TransactionTemplate transactionTemplate;

	@Autowired
	private SmsBlackListQueryComponent smsBlackListQueryComponent;

	@Autowired
	private SmsSendFrequencyCheckComponent smsSendFrequencyCheckComponent;

	@Autowired
	private SmsOutHisQueryComponent smsOutHisQueryComponent;

	@Autowired
	private ConverterManager converterManager;

	/*
	 * (non-Javadoc)
	 *
	 * @see com.bench.app.gotone.core.service.sms.SmsSendComponent#send(com.bench .app.gotone.common.service.facade.request.SmsSendRequest)
	 */
	public SmsSendResult send(SmsSendRequest request) {
		SmsSendResult result = new SmsSendResult();
		if (StringUtils.isNotEmpty(request.getIp())) {
			if (!IpUtils.isValidIp(request.getIp())) {
				result.setSuccess(false);
				result.setErrorCode(ErrorCodeEnum.IP_NOT_VALID.errorCode());
				return result;
			}
		}
		SmsConfig smsConfig = smsConfigQueryComponent.getCachedByConfigName(request.getSmsConfigName());
		if (smsConfig == null) {
			result.setSuccess(false);
			result.setErrorCode(ErrorCodeEnum.SMS_CONFIG_NOT_FOUND.errorCode());
			return result;
		}
		// 找到一条之前发送的,未验证可用的短信
		SmsOutDO previousSmsOutDO = smsOutMapper.selectByBizIdSmsConfigIdWithIntervalSeconds(request.getBizId(), smsConfig.getId());
		if (previousSmsOutDO != null) {
			result.setSuccess(true);
			result.setWaitNextPrepareSeconds(DateUtils.getDiffSeconds(DateUtils.addSeconds(previousSmsOutDO.getGmtCreate(), smsConfig.getIntervalSeconds()), new Date()));
			result.setSmsId(previousSmsOutDO.getSmsId());
			return result;
		}

		// 可验证的已发送短信
		SmsOutHisDO previousSmsOutHisDO = smsOutHisMapper.selectValidateableByBizIdSmsConfigIdWithIntervalSeconds(request.getBizId(), smsConfig.getId());
		if (previousSmsOutHisDO != null) {
			result.setSuccess(true);
			result.setWaitNextPrepareSeconds(
					DateUtils.getDiffSeconds(DateUtils.addSeconds(previousSmsOutHisDO.getGmtCreate(), smsConfig.getIntervalSeconds()), new Date()));
			result.setSmsId(previousSmsOutHisDO.getSmsId());
			return result;
		}

		// 如果需要控制发送频度
		if (smsConfig.getIntervalSeconds() > 0) {
			// 计算在频度时间内已经发送的数量，发送后已经移动到历史库了
			previousSmsOutHisDO = smsOutHisMapper.selectByBizIdSmsConfigIdWithIntervalSeconds(request.getBizId(), smsConfig.getId());
			if (previousSmsOutHisDO != null) {
				result.setSuccess(false);
				result.setSmsId(previousSmsOutHisDO.getSmsId());
				result.setErrorCode(ErrorCodeEnum.SMS_SEND_DUPLICATE_IN_INTERVAL_SECONDS.errorCode());
				// 计算剩余时间
				result.setWaitNextPrepareSeconds(DateUtils.getDiffSeconds(DateUtils.addSeconds(
						previousSmsOutDO == null ? previousSmsOutHisDO.getGmtCreate() : previousSmsOutDO.getGmtCreate(), smsConfig.getIntervalSeconds()), new Date()));
				return result;
			}
		}

		// 如果模板中含有验证码，但是请求中没有，则系统自动生成1个
		SmsOutDO smsOutDO = new SmsOutDO();

		// 如果成功，计算下次发送剩余时间
		result.setWaitNextPrepareSeconds(smsConfig.getIntervalSeconds());
		// 复制属性
		converterManager.convert(request, smsOutDO);

		if (StringUtils.isEmpty(request.getAckCode()) && StringUtils.containsAny(smsConfig.getContent(), ACK_CODE_TAGS)) {
			smsOutDO.setAckCode(RandomStringUtils.randomNumeric(6));
		}
		smsOutDO.setSmsConfigId(smsConfig.getId());
		smsOutDO.setProperties(PropertiesUtils.convert2String(request.getProperties(), false));
		smsOutDO.setTemplateArgs(PropertiesUtils.convert2String(request.getTemplateArgs(), false));
		smsOutDO.setReceiver(request.getCell());
		smsOutDO.setStatus(MessageStatusEnum.I.name());
		smsOutDO.setSendChannel(ObjectUtils.toString(request.getSendChannel()));
		smsOutDO.setSendChannelSpecified(!StringUtils.isEmpty(smsOutDO.getSendChannel()));
		// 延迟1秒
		smsOutDO.setGmtResend(DateUtils.addSeconds(new Date(), 1));
		if (smsConfig.isSmsOutNeedUniqueId()) {
			smsOutDO.setUniqueId(request.getCell() + "_" + smsOutDO.getSmsId());
		}
		final long id = smsOutMapper.insert(smsOutDO);
		// 传了ip,在redis存一下id对应的ip
		if (StringUtils.isNotEmpty(request.getIp())) {
			appCacheComponent.putObjectWithExpire(AppCacheAreaNameEnum.SMS_OUT_ID_AND_IP_CACHE, ObjectUtils.toString(id), request.getIp(), 6 * 60 * 60);

		}
		result.setSmsId(smsOutDO.getSmsId());
		result.setId(id);
		result.setSuccess(true);
		if (request.isSendImmediately()) {
			/**************************
			 * 立即发送
			 **************************/
			sendSmsThreadPoolExecutor.execute(new Runnable() {
				public void run() {
					// TODO Auto-generated method stub
					send(id);
				}

			});
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.bench.app.gotone.core.service.sms.SmsSendComponent#send(long)
	 */
	public SmsResult send(final long smsId) {
		final SmsResult result = new SmsResult();
		transactionTemplate.execute(new TransactionCallback<SmsResult>() {
			/*
			 * (non-Javadoc)
			 *
			 * @see org.springframework.transaction.support.TransactionCallback# doInTransaction (org.springframework.transaction.TransactionStatus)
			 */
			public SmsResult doInTransaction(TransactionStatus status) {
				// TODO Auto-generated method stub
				// 锁定smsoutDO
				SmsOutDO smsOutDO = null;
				try {
					smsOutDO = smsOutMapper.selectByIdForUpdate(smsId);
				} catch (Exception e) {
					result.setSuccess(false);
					result.setErrorCode(ErrorCodeEnum.SMS_OUT_LOCK_FAILED.errorCode());
					return result;
				}
				if (smsOutDO == null) {
					result.setSuccess(false);
					result.setErrorCode(ErrorCodeEnum.SMS_OUT_NOT_FOUND.errorCode());
					return result;
				}

				SmsConfig smsConfig = smsConfigQueryComponent.getCachedById(smsOutDO.getSmsConfigId());
				/************************
				 * 选择通道
				 ***********************/
				SmsChannelConfig smsChannelConfig = null;
				// 如果未指定，则要选择通道
				if (!smsOutDO.isSendChannelSpecified()) {
					smsChannelConfig = smsChannelConfigQueryComponent.selectSmsChannel(smsOutDO.getReceiver(), smsConfig.getSendChannels());
				}
				// 否则，直接获取通道
				else {
					smsChannelConfig = smsChannelConfigQueryComponent.getByChannelCode(SmsChannelEnum.valueOf(smsOutDO.getSendChannel()));
				}
				if (smsChannelConfig == null) {
					smsOutMapper.updateSendFaild(DateUtils.addSeconds(new Date(), smsConfig.getRetryIntervalSeconds()), "无法选择短信通道", null, smsOutDO.getId());
				}
				/**
				 * 渲染需要处理的消息
				 */
				Map<String, Object> parametersMap = new HashMap<String, Object>();
				parametersMap.putAll(PropertiesUtils.restoreMap(smsOutDO.getTemplateArgs()));
				if (!StringUtils.isEmpty(smsOutDO.getAckCode()))
					parametersMap.put("ackCode", smsOutDO.getAckCode());
				String content = null;
				try {
					SmsConfigInChannel smsConfigInChannel = smsConfigInChannelQueryComponent.getEnabledBySmsConfigIdAndChannel(smsConfig.getId(),
							smsChannelConfig.getChannel());
					content = VelocityHelper.getInstance().evaluate(parametersMap, smsConfigInChannel.getContent());

				} catch (Exception e) {
					log.error("短信渲染失败,id=" + smsConfig.getId() + ",parameterMap=" + parametersMap, e);
					result.setSuccess(false);
					result.setErrorCode(ErrorCodeEnum.SMS_MESSAGE_RENDER_ERROR.errorCode());
					return result;
				}
				content = StringUtils.trimWithLine(content);
				// 内容添加前/后缀
				if (!StringUtils.isEmpty(smsChannelConfig.getContentAppendPrefix())) {
					content = StringUtils.trimWithLine(smsChannelConfig.getContentAppendPrefix()) + content;
				}
				if (!StringUtils.isEmpty(smsChannelConfig.getContentAppendSuffix())) {
					content = content + StringUtils.trimWithLine(smsChannelConfig.getContentAppendSuffix());
				}

				// 如果已经超过最大允许次数了，直接设置为O
				if (smsOutDO.getSendTimes() > smsConfig.getMaxTryCount()) {
					return handleMoveToHis(result, smsOutDO, smsConfig, content, "超过最大允许次数:" + smsConfig.getMaxTryCount());
				} // 如果是虚拟手机号
				else if (MobilePhoneNumberUtils.isVirtual(smsOutDO.getReceiver())) {
					return handleMoveToHis(result, smsOutDO, smsConfig, content, "虚拟手机号" + smsConfig.getMaxTryCount());
				}
				/*************************
				 * 执行发送
				 *************************/
				SmsChannelHandler handler = smsSendChannelHandlerManager.getChannelHandler(smsChannelConfig.getChannel());
				SmsResult sendResult = handler.send(new String[] { smsOutDO.getReceiver() }, content, smsOutDO);
				// 如果发送成功
				if (sendResult.isSuccess()) {
					// 删除旧记录
					smsOutMapper.deleteById(smsOutDO.getId());
					// 移动到历史库
					SmsOutHisDO hisDO = new SmsOutHisDO();
					BeanCopier.create(SmsOutDO.class, SmsOutHis.class, false).copy(smsOutDO, hisDO, null);
					hisDO.setSendChannel(smsChannelConfig.getChannel().name());
					hisDO.setContent(content);
					hisDO.setSendResult(StringUtils.subBytes(sendResult.getDetailMessage(), 4000));
					smsOutHisMapper.insert(hisDO);

					// 发送成功后检查
					SmsSendFrequencyCheckRequest smsSendFrequencyCheckRequest = new SmsSendFrequencyCheckRequest();
					smsSendFrequencyCheckRequest.setGmtSend(smsOutHisQueryComponent.queryById(hisDO.getId()).getGmtSendSuccess());
					smsSendFrequencyCheckRequest
							.setIp((String) appCacheComponent.getObject(AppCacheAreaNameEnum.SMS_OUT_ID_AND_IP_CACHE, ObjectUtils.toString(smsOutDO.getId())));
					smsSendFrequencyCheckComponent.check(smsSendFrequencyCheckRequest);

					result.setSuccess(true);
					return result;
				}
				// 发送失败
				else {
					log.error("发送短信失败,id=" + smsOutDO.getId() + ",result=" + sendResult);
					smsOutMapper.updateSendFaild(DateUtils.addSeconds(new Date(), smsConfig.getRetryIntervalSeconds()),
							StringUtils.subBytes(sendResult.getDetailMessage(), 4000), smsChannelConfig.getChannel().name(), smsOutDO.getId());
					result.setSuccess(false);
					result.setErrorCode(sendResult.getErrorCode());
					return result;
				}
			}

			private SmsResult handleMoveToHis(final SmsResult result, SmsOutDO smsOutDO, SmsConfig smsConfig, String content, String sendResult) {
				// 移动到历史库
				SmsOutHisDO hisDO = new SmsOutHisDO();
				BeanCopier.create(SmsOutDO.class, SmsOutHisDO.class, false).copy(smsOutDO, hisDO, null);
				hisDO.setContent(content);
				hisDO.setSendResult(sendResult);
				hisDO.setStatus(MessageStatusEnum.O.name());
				smsOutHisMapper.insert(hisDO);
				// 删除旧记录
				smsOutMapper.deleteById(smsOutDO.getId());
				result.setSuccess(true);
				return result;
			}
		});
		return result;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.bench.app.gotone.core.service.sms.SmsSendComponent#resend(com.bench .app.gotone.common.service.facade.request.SmsResendRequest)
	 */
	public SmsSendResult resend(SmsResendRequest request) {
		// TODO Auto-generated method stub
		final SmsSendResult result = new SmsSendResult();
		// 查找到历史短信
		SmsOutHisDO smsOutHisDO = smsOutHisMapper.selectById(request.getId());
		if (smsOutHisDO == null) {
			result.setSuccess(false);
			result.setErrorCode(ErrorCodeEnum.SMS_OUT_HIS_NOT_FOUND.errorCode());
			return result;
		}

		// 保存消息到数据库
		SmsOutDO smsOutDO = new SmsOutDO();
		BeanCopier.create(SmsOutDO.class, SmsOutHisDO.class, false).copy(smsOutHisDO, smsOutDO, null);
		smsOutDO.setStatus(MessageStatusEnum.I.name());
		smsOutDO.setSendChannel(request.getChannel().name());
		smsOutDO.setSendChannelSpecified(true);
		smsOutDO.setResendFromId(request.getId());
		smsOutDO.setSmsId(UUIDUtils.getRandomUUID());
		// 延迟1秒
		smsOutDO.setGmtResend(DateUtils.addSeconds(new Date(), 1));
		final long id = smsOutMapper.insert(smsOutDO);
		result.setSmsId(smsOutDO.getSmsId());
		result.setId(id);
		result.setSuccess(true);
		/**************************
		 * 立即发送
		 **************************/
		sendSmsThreadPoolExecutor.execute(new Runnable() {
			public void run() {
				// TODO Auto-generated method stub
				send(id);
			}

		});
		return result;

	}

	/**
	 * 批量发送
	 *
	 * @param request
	 * @return
	 */
	@Override
	public SmsSendResult batchSend(SmsBatchSendRequest request) {
		SmsSendResult result = new SmsSendResult();

		SmsConfig smsConfig = smsConfigQueryComponent.getCachedByConfigName(request.getSmsConfigName());
		if (smsConfig == null) {
			result.setSuccess(false);
			result.setErrorCode(ErrorCodeEnum.SMS_CONFIG_NOT_FOUND.errorCode());
			return result;
		}
		List<SmsOutDO> doList = new ArrayList<>();

		for (String cell : request.getCells()) {
			if (!MobilePhoneNumberUtils.isValid(cell, false)) {
				result.setSuccess(false);
				result.setDetailMessage("cell=" + cell + ",不符合手机号格式");
				return result;
			}
			// 如果模板中含有验证码，但是请求中没有，则系统自动生成1个
			SmsOutDO smsOutDO = new SmsOutDO();
			// 如果成功，计算下次发送剩余时间
			result.setWaitNextPrepareSeconds(smsConfig.getIntervalSeconds());
			BeanCopier.create(SmsBatchSendRequest.class, SmsOutDO.class, false).copy(request, smsOutDO, null);
			if (StringUtils.isEmpty(request.getAckCode()) && StringUtils.containsAny(smsConfig.getContent(), ACK_CODE_TAGS)) {
				smsOutDO.setAckCode(RandomStringUtils.randomNumeric(6));
			}
			smsOutDO.setSmsConfigId(smsConfig.getId());
			smsOutDO.setProperties(PropertiesUtils.convert2String(request.getProperties(), false));
			smsOutDO.setTemplateArgs(PropertiesUtils.convert2String(request.getTemplateArgs(), false));
			smsOutDO.setStatus(MessageStatusEnum.I.name());
			smsOutDO.setSendChannel(ObjectUtils.toString(request.getSendChannel()));
			smsOutDO.setSendChannelSpecified(!StringUtils.isEmpty(smsOutDO.getSendChannel()));
			// 延迟1秒
			smsOutDO.setGmtResend(DateUtils.addSeconds(new Date(), 1));
			smsOutDO.setReceiver(cell);
			smsOutDO.setSmsId(UUIDUtils.getRandomUUID());
			smsOutDO.setUniqueId(cell + "_" + smsOutDO.getSmsId());
			smsOutDO.setBizId(cell + "_" + smsOutDO.getSmsId());
			doList.add(smsOutDO);
		}
		smsOutMapper.insertBatch(doList);
		result.setSuccess(true);
		return result;
	}

	@Override
	public void ThredTest() {
		System.out.println(sendSmsThreadPoolExecutor);
	}

}
