/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.service.mail.task;
import com.bench.lang.base.number.utils.NumberUtils;
import com.bench.xtask.BenchDistributeTask;
import com.bench.xtask.annotation.DistributeTask;
import com.yuan.gotonecore.common.enums.GotoneChannelEnum;
import com.yuan.gotonecore.common.enums.MailSendClientStatusEnum;
import com.yuan.gotonecore.common.enums.MessageStatusEnum;
import com.yuan.gotonecore.repository.mapper.MailOutMapper;
import com.yuan.gotonecore.repository.mapper.MailSendClientMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * EDM邮件分发线程，将系统中未分配的EDM邮件分发给邮件发送端
 * 
 * @author cold
 * 
 * @version $Id: GotoneEdmMailAssignTask.java, v 0.1 2011-1-27 下午03:30:17
 *          cold Exp $
 */
@DistributeTask(cronExpression = "0/50 * * * * ? *")
@Component
@Slf4j
public class EdmMailAssignTask implements BenchDistributeTask {

	/** mailOutMapper */
	@Autowired
	private MailOutMapper mailOutMapper;
	@Autowired
	private MailSendClientMapper mailSendClientMapper;
	@Autowired
	private TransactionTemplate transactionTemplate;

	/** logger */

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bench.platform.scheduler.task.Task#execute()
	 */
	public void execute() {
		// TODO Auto-generated method stub

		// 捞取客户端
		final List<Map<String, Object>> sendClientMapList = this.mailSendClientMapper.selectIdCurrentAmountByStatus(MailSendClientStatusEnum.LIVE.name());
		if (sendClientMapList.size() == 0) {
			log.info("没有存活的客户端，无法进行邮件发送分配");
			return;
		}

		if (log.isInfoEnabled()) {
			log.info("存活的发送客户端，size=" + sendClientMapList.size());
		}

		transactionTemplate.execute(new TransactionCallback<Integer>() {
			public Integer doInTransaction(TransactionStatus status) {
				// TODO Auto-generated method stub
				// 捞取可分配的消息
				List<Long> mailIdList = null;
				try {
					mailIdList = mailOutMapper.findAssianableMailIdByChannelForUpdate(GotoneChannelEnum.EDM.name());
				} catch (Exception e) {
					log.warn("捞取可分配的邮件，锁定失败，不执行");
					return 1;
				}
				if (mailIdList.size() == 0) {
					log.warn("没有需要分配的邮件，不执行");
					return 0;
				}
				if (log.isInfoEnabled()) {
					log.info("开始捞取mail消息进行分配: size=" + mailIdList.size());
				}

				// 统计总剩余量
				long totalCount = mailIdList.size();
				// 最小积压量的客户端ID
				long minAmountClientId = -1;
				long minAmount = -1;
				List<Map<String, Object>> removeSendClientList = new ArrayList<Map<String, Object>>();
				for (Map<String, Object> map : sendClientMapList) {
					long currentAmount = NumberUtils.toLong(map.get("CURRENT_AMOUNT"));
					// 如果总容量大于100，则不在进行分配
					if (currentAmount > 100) {
						removeSendClientList.add(map);
						continue;
					}
					totalCount += currentAmount;
					if (minAmountClientId == -1 || minAmount < currentAmount) {
						minAmountClientId = NumberUtils.toLong(map.get("ID"));
						minAmount = currentAmount;
					}
				}
				sendClientMapList.removeAll(removeSendClientList);

				// 计算平年均
				long average = totalCount / sendClientMapList.size();
				// 平均值不能大于100
				if (average > 100) {
					average = 100;
				}

				// 平均分发
				int index = 0;
				List<Long> assignMailIdList = new ArrayList<Long>();
				// 循环发送客户端,分配邮件ID
				for (Map<String, Object> map : sendClientMapList) {
					assignMailIdList.clear();
					long currentAmount = NumberUtils.toLong(map.get("CURRENT_AMOUNT"));
					long clientId = NumberUtils.toLong(map.get("ID"));
					long assignCount = average - currentAmount;
					// 分配邮
					for (int i = 0; i < assignCount && i < mailIdList.size(); i++) {
						assignMailIdList.add(mailIdList.get(index++));
						if (minAmountClientId == clientId)
							minAmount++;
					}
					if (assignMailIdList.size() > 0) {
						mailOutMapper.updateAssignInfoByIds(clientId, MessageStatusEnum.P.name(), assignMailIdList);
						// 更新当前数量
						mailSendClientMapper.addCurrentAmountById(assignMailIdList.size(), clientId);
					}
				}
				// 将剩余数量分配给最小的发送客户端
				assignMailIdList.clear();
				if (minAmount < 100) {
					for (; minAmount < 100 && index < mailIdList.size(); index++, minAmount++) {
						assignMailIdList.add(mailIdList.get(index));
					}
					if (assignMailIdList.size() > 0) {
						mailOutMapper.updateAssignInfoByIds(minAmountClientId, MessageStatusEnum.P.name(), assignMailIdList);
						// 更新当前数量
						mailSendClientMapper.addCurrentAmountById(assignMailIdList.size(), minAmountClientId);
					}
				}

				return 1;
			}

		});

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bench.platform.scheduler.task.Task#isMultiInstance()
	 */
	public boolean isMultiInstance() {
		// TODO Auto-generated method stub
		return false;
	}

}
