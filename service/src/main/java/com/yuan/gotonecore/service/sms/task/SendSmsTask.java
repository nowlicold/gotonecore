/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.service.sms.task;

import java.util.List;
import java.util.concurrent.Executor;

import com.bench.lang.base.list.utils.ListUtils;
import com.bench.lang.base.math.utils.MathUtils;
import com.bench.xtask.BenchDistributeTask;
import com.bench.xtask.annotation.DistributeTask;
import com.yuan.gotonecore.repository.mapper.SmsOutMapper;
import com.yuan.gotonecore.service.sms.SmsSendComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 发送短信task
 * 
 * @author fangbianmian
 *
 * @version $Id: SendSmsTask.java, v 0.1 2017年2月23日 下午6:24:20 Administrator Exp $
 */
@Slf4j
@DistributeTask(repeatIntervalMillseconds = 2000)
@Component
public class SendSmsTask implements BenchDistributeTask {


	/**
	 * 待发送短信Mapper
	 */
	@Autowired
	private SmsOutMapper smsOutMapper;

	/**
	 * 短信发送component
	 */
	@Autowired
	private SmsSendComponent smsSendComponent;

	/**
	 * 发送短信线程执行器
	 */
	@Autowired
	private Executor sendSmsTaskThreadPoolExecutor;

	public void execute() {
		List<Long> ids = smsOutMapper.selectReadyToSendIds(100);
		List<List<Long>> averageList = MathUtils.average(ids, 4);
		for (final List<Long> eachList : averageList) {
			if (ListUtils.isEmpty(eachList)) {
				continue;
			}
			for (final Long id : eachList) {
				sendSmsTaskThreadPoolExecutor.execute(new Runnable() {
					public void run() {
						try {
							smsSendComponent.send(id);
						} catch (Exception e) {
							log.error("发送短信异常,id=" + id, e);
						}
					}
				});
			}
		}
	}

	public boolean isMultiInstance() {
		return false;
	}
}
