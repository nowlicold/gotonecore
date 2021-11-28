/**
 * Bench.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.service;

import org.springframework.stereotype.Service;

/**
 * 消息重发策略对象
 * <p>
 * 目前只支持默认重发策略：
 * </p>
 * 
 * @author jian.wujian
 * 
 * @version $Id: MessageRetryPolicy.java, v 0.1 2009-9-16 下午09:21:09 jian.wujian
 *          Exp $
 */
@Service
public class MessageRetryPolicy {

	/** 默认短信重发间隔:20s,40s,60s,180s,300s.单位：秒 */
	private long[] retryIntervals = new long[]{20,40,60,180,300};

	/** 旺旺、邮件、贸易通重发时间间隔: 60,300,1800,3600.单位：秒 */
	private long[] otherRetryIntervals = new long[]{60,300,1800,3600};

	/**
	 * Getter method for property <tt>otherRetryIntervals</tt>.
	 * 
	 * @return property value of otherRetryIntervals
	 */
	public long[] getOtherRetryIntervals() {
		return otherRetryIntervals;
	}

	/**
	 * Setter method for property <tt>otherRetryIntervals</tt>.
	 * 
	 *
	 */
	public void setOtherRetryIntervals(long[] otherRetryIntervals) {
		this.otherRetryIntervals = otherRetryIntervals;
	}
}
