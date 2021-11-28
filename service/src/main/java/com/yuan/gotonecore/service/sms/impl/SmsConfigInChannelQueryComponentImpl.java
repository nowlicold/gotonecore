/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.service.sms.impl;

import java.util.Date;
import java.util.List;

import com.bench.cache.local.AbstractGmtModifiedRefreshableCacheComponent;
import com.yuan.gotonecore.api.sms.model.SmsConfigInChannel;
import com.yuan.gotonecore.api.sms.model.enums.SmsChannelEnum;
import com.yuan.gotonecore.repository.mapper.SmsConfigInChannelMapper;
import com.yuan.gotonecore.service.sms.SmsConfigInChannelConvert;
import com.yuan.gotonecore.service.sms.SmsConfigInChannelQueryComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author cold
 *
 * @version $Id: SmsConfigInChannelQueryComponentImpl.java, v 0.1 2016年5月13日
 *          下午4:22:27 cold Exp $
 */
@Service
public class SmsConfigInChannelQueryComponentImpl extends AbstractGmtModifiedRefreshableCacheComponent<SmsConfigInChannel, Long>
		implements SmsConfigInChannelQueryComponent {

	/**
	 * 短信配置在通道方的配置Mapper
	 */
	@Autowired
	private SmsConfigInChannelMapper smsConfigInChannelMapper;


	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bench.app.gotonecore.core.service.sms.
	 * SmsConfigInChannelQueryComponent #getEnabledBySmsConfigIdAndChannel(long,
	 * com.bench.app.gotonecore.core.model.enums.SmsChannelEnum)
	 */
	public SmsConfigInChannel getEnabledBySmsConfigIdAndChannel(long smsConfigId, SmsChannelEnum channelEnum) {
		for (SmsConfigInChannel configInChannel : super.getAll()) {
			if (configInChannel.isEnabled() && configInChannel.getSmsConfigId() == smsConfigId && configInChannel.getChannel() == channelEnum) {
				return configInChannel;
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bench.platform.config.cache.refresh.impl.
	 * AbstractGmtModifiedBasedMemoryCacheRefreshComponent#loadAll()
	 */
	@Override
	protected List<SmsConfigInChannel> loadAll() {

		return SmsConfigInChannelConvert.convertList(this.smsConfigInChannelMapper.selectAll());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bench.platform.config.cache.refresh.impl.
	 * AbstractGmtModifiedBasedMemoryCacheRefreshComponent
	 * #loadLargeThanGmtModified(java.util.Date)
	 */
	@Override
	protected List<SmsConfigInChannel> loadLargeThan(Date gmtModified) {
		return SmsConfigInChannelConvert.convertList(this.smsConfigInChannelMapper.selectByMaxGmtModified(gmtModified));
	}

}
