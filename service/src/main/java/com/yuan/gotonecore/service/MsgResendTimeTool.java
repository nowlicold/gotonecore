/*
 * Bench.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.service;

import com.bench.lang.base.date.utils.DateUtils;
import com.bench.repository.mapper.SystemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 消息重发时间生成类。
 * <p>
 * 
 * @author min.weixm
 * @version $Id: MsgResendTimeTool.java, v 0.1 2009-9-16 下午11:18:01 min.weixm
 *          Exp $
 */
@Service
public class MsgResendTimeTool {
	/** 消息重发策略 */
	@Autowired
	private com.yuan.gotonecore.service.MessageRetryPolicy messageRetryPolicy;
	@Resource
	private SystemMapper systemMapper;

	/**
	 * 得到下次发送时间
	 * 
	 * @param sendtime
	 * @return
	 */
	public Date getGmtResend(int sendtime) {
		long[] retryIntervals = messageRetryPolicy.getOtherRetryIntervals();
		long retryInterval = retryIntervals[(int) sendtime];
		return DateUtils.addSeconds(systemMapper.getCurrentDate(), retryInterval);
	}

}
