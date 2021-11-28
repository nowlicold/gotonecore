/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.service.mail.impl;
import com.bench.lang.base.number.utils.NumberUtils;
import com.bench.lang.base.object.utils.ObjectUtils;
import com.bench.lang.base.properties.utils.PropertiesUtils;
import com.bench.lang.base.velocity.VelocityHelper;
import com.bench.runtime.convert.ConverterManager;
import com.yuan.gotonecore.common.MailTaskEntry;
import com.yuan.gotonecore.common.enums.ErrorCodeEnum;
import com.yuan.gotonecore.common.enums.MessageStatusEnum;
import com.yuan.gotonecore.common.exceptions.GotoneCoreException;
import com.yuan.gotonecore.common.mail.MailConfig;
import com.yuan.gotonecore.common.msg.MsgMailSendSuccessPayload;
import com.yuan.gotonecore.repository.entity.MailOutDO;
import com.yuan.gotonecore.repository.entity.MailOutHistoryDO;
import com.yuan.gotonecore.repository.mapper.MailOutHistoryMapper;
import com.yuan.gotonecore.repository.mapper.MailOutMapper;
import com.yuan.gotonecore.repository.mapper.MailSendClientMapper;
import com.yuan.gotonecore.service.mail.MailConfigQueryComponent;
import com.yuan.gotonecore.service.mail.MailSendClientQueryComponent;
import com.yuan.gotonecore.service.mail.MailTaskComponent;
import com.yuan.gotonecore.service.msg.PushMessageChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author cold
 * 
 * @version $Id: MailTaskComponentImpl.java, v 0.1 2011-1-28 下午02:36:31 cold
 *          Exp $
 */
@Service
public class MailTaskComponentImpl implements MailTaskComponent {
	@Autowired
	private MailOutMapper mailOutMapper;
	@Autowired
	private MailOutHistoryMapper mailOutHistoryMapper;
	@Autowired
	private MailSendClientMapper mailSendClientMapper;

	@Autowired
	private ConverterManager converterManager;
	@Autowired
	private TransactionTemplate transactionTemplate;
	@Autowired
	private MailConfigQueryComponent mailConfigQueryComponent;
	@Autowired
	private MailSendClientQueryComponent mailSendClientQueryComponent;

	/** 事件引擎 */
	@Autowired
	private PushMessageChannel pushMessageChannel;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bench.app.gotone.core.component.MailTaskComponent#clientGetForExecute
	 * (java.lang.String)
	 */
	public List<MailTaskEntry> clientGetForExecute(final String clientId) {
		// TODO Auto-generated method stub
		if (!mailSendClientQueryComponent.isLive(clientId)) {
			return new ArrayList<MailTaskEntry>();
		}
		// 获取id
		long longClientId = mailSendClientMapper.selectIdByClientId(clientId);
		if (longClientId <= 0)
			return new ArrayList<MailTaskEntry>();
		// 查找邮件ID
		List<Map<String, Object>> mailTaskEntryMapList = mailOutMapper.findAssignedMailIdsBySendClientId(longClientId);
		List<MailTaskEntry> returnList = new ArrayList<MailTaskEntry>();
		// 更新正在执行
		if (mailTaskEntryMapList.size() > 0) {
			List<Integer> mailIdList = new ArrayList();
			for (Map<String, Object> map : mailTaskEntryMapList) {
				MailTaskEntry entry = new MailTaskEntry();
				entry.setMailId(NumberUtils.toInt(map.get("ID")));
				entry.setMailConfigId(NumberUtils.toInt(map.get("MAIL_CONFIG_ID")));
				entry.setActivityId(mailConfigQueryComponent.getCachedMailConfigById(entry.getMailConfigId()).getActivityId());
				entry.setReceiverAddr(ObjectUtils.toString(map.get("RECEIVER")));
				returnList.add(entry);
				mailIdList.add(entry.getMailId());
			}
			mailOutMapper.updateStatusByMailIds(MessageStatusEnum.E.name(), mailIdList);
		}
		return returnList;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bench.app.gotone.core.component.MailTaskComponent#sendFinish(java
	 * .lang.String, long)
	 */
	public ErrorCodeEnum notifySendFinish(String clientId, final Integer mailId) {
		// TODO Auto-generated method stub
		// 获取id
		if (!mailSendClientQueryComponent.isLive(clientId)) {
			return ErrorCodeEnum.CLIENT_DEAD;
		}
		final long longClientId = mailSendClientMapper.selectIdByClientId(clientId);
		Object object = transactionTemplate.execute(new TransactionCallback() {
			public Object doInTransaction(TransactionStatus status) {
				// TODO Auto-generated method stub
				// TODO Auto-generated method stub
				MailOutDO mailOutDO = mailOutMapper.findMailMsgByIdForUpdate(mailId);
				if (mailOutDO == null) {
					return ErrorCodeEnum.MAIL_NOT_FOUND;
				}
				// 非当前客户端的邮件
				if (mailOutDO.getSendClientId() != longClientId) {
					return ErrorCodeEnum.CLIENT_MISMATCH;
				}

				// 删除当前记录， 移动到历史库
				final MailOutHistoryDO historyDO = new MailOutHistoryDO();
				converterManager.convert(mailOutDO, historyDO);
				historyDO.setGmtSchedule(new Date());
				mailOutHistoryMapper.insert(historyDO);
				mailOutMapper.deleteMailMsgById(mailId);

				// 更新当前数量
				mailSendClientMapper.subtractCurrentAmountById(1, longClientId);

				// 发送事件
				MsgMailSendSuccessPayload msgMailSendSuccessPayload = new MsgMailSendSuccessPayload();
				msgMailSendSuccessPayload.setMailOutId(mailOutDO.getId());
				pushMessageChannel.sendMsgMailSendSuccess().send(MessageBuilder.withPayload(msgMailSendSuccessPayload).build());
				return null;
			}
		});

		return object == null ? null : (ErrorCodeEnum) object;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.bench.app.gotone.core.component.MailTaskComponent#
	 * getRenderedMailContent (java.lang.String, long)
	 */
	public String getRenderedMailContent(String clientId, Integer mailId) throws GotoneCoreException {
		// TODO Auto-generated method stub
		final long longClientId = mailSendClientMapper.selectIdByClientId(clientId);
		MailOutDO mailOutDO = mailOutMapper.findMailMsgById(mailId);
		if (mailOutDO == null) {
			return ErrorCodeEnum.MAIL_NOT_FOUND.name();
		}
		// 非当前客户端的邮件
		if (mailOutDO.getSendClientId() != longClientId) {
			return ErrorCodeEnum.CLIENT_MISMATCH.name();
		}
		Map<String, String> map = PropertiesUtils.restoreMap(mailOutDO.getTemplateArgs());
		// step 4: 加载配置
		MailConfig mailConfig = mailConfigQueryComponent.getCachedMailConfigById(mailOutDO.getMailConfigId());
		return VelocityHelper.getInstance().evaluate(map,mailConfig.getContent());
	}

}
