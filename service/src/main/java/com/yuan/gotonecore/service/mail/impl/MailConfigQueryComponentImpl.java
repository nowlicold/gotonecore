/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.service.mail.impl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bench.common.model.PageVO;
import com.bench.xtask.BenchDistributeTask;
import com.bench.xtask.annotation.DistributeTask;
import com.yuan.gotonecore.api.request.MailConfigSearchRequest;
import com.yuan.gotonecore.common.mail.MailConfig;
import com.yuan.gotonecore.common.mail.MailSimpleConfig;
import com.yuan.gotonecore.repository.entity.MailConfigDO;
import com.yuan.gotonecore.repository.mapper.MailConfigBodyMapper;
import com.yuan.gotonecore.repository.mapper.MailConfigMapper;
import com.yuan.gotonecore.service.mail.MailConfigFilter;
import com.yuan.gotonecore.service.mail.MailConfigQueryComponent;
import com.yuan.gotonecore.service.mail.converter.MailConfigConverter;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 
 * @author fangbianmian
 *
 * @version $Id: MailConfigQueryComponentImpl.java, v 0.1 2017年2月23日 下午1:39:01
 *          Administrator Exp $
 */
@Service
@DistributeTask(repeatIntervalMillseconds = 10000)
public class MailConfigQueryComponentImpl implements MailConfigQueryComponent, BenchDistributeTask, ApplicationRunner  {

	public static final MailConfigFilter ENABLED_FILTER = new MailConfigFilter() {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.bench.app.gotone.core.service.mail.MailConfigFilter#accept(com
		 * .bench.app.gotone.core.model.mail.MailConfig)
		 */
		public boolean accept(MailConfig mailConfig) {
			// TODO Auto-generated method stub
			return mailConfig.isEnabled();
		}

	};
	@Autowired
	private MailConfigMapper mailConfigMapper;

	private Date lastMailConfigGmtModified;
	@Autowired
	private MailConfigConverter mailConfigConverter;
	@Resource
	private MailConfigBodyMapper mailConfigBodyMapper;

	private Map<String, MailConfig> byConfigNameCacheMap = new HashMap<String, MailConfig>();

	private Map<Integer, MailConfig> byIdCacheMap = new HashMap<Integer, MailConfig>();

	private List<MailConfig> mailConfigList = new ArrayList<MailConfig>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bench.app.gotone.core.service.common.MailConfigQueryComponent#
	 * getCachedMailConfig(java.lang.String)
	 */
	public MailConfig getCachedMailConfigByConfigName(String configName) {
		// TODO Auto-generated method stub
		return byConfigNameCacheMap.get(configName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bench.app.gotone.core.service.common.MailConfigQueryComponent#
	 * refreshCacheData()
	 */
	public void refreshCacheData() {
		// TODO Auto-generated method stub
		// 加载邮件配置
		Date currentGmtModifed = mailConfigMapper.selectMaxGmtModified();
		List<MailConfigDO> updateMailConfigDOList = null;
		if (lastMailConfigGmtModified == null) {
			updateMailConfigDOList = mailConfigMapper.selectAll();
		} else if (!lastMailConfigGmtModified.equals(currentGmtModifed)) {
			updateMailConfigDOList = mailConfigMapper.selectGreaterThanModifiedDate(lastMailConfigGmtModified);
		}
		if (updateMailConfigDOList != null) {
			for (MailConfigDO mailConfigDO : updateMailConfigDOList) {
				MailConfig mailConfig = this.mailConfigConverter.convert(mailConfigDO);
				mailConfig.setContent(mailConfigBodyMapper.selectById(mailConfigDO.getId()).getMailContent());
				byConfigNameCacheMap.put(mailConfig.getConfigName(), mailConfig);
				byIdCacheMap.put(mailConfig.getId(), mailConfig);
				mailConfigList.add(mailConfig);
			}
			lastMailConfigGmtModified = currentGmtModifed;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bench.app.gotone.core.service.common.MailConfigQueryComponent#
	 * getMailConfig(java.lang.String)
	 */
	public MailConfig getMailConfigByConfigName(String configName) {
		// TODO Auto-generated method stub
		MailConfigDO mailConfigDO = this.mailConfigMapper.selectByConfigName(configName);
		if (mailConfigDO == null)
			return null;
		MailConfig mailConfig = mailConfigConverter.convert(mailConfigDO);
		mailConfig.setContent(mailConfigBodyMapper.selectById(mailConfigDO.getId()).getMailContent());
		return mailConfig;
	}

	public PageVO<MailSimpleConfig> search(MailConfigSearchRequest searchRequest) {
		// TODO Auto-generated method stub
		Page< MailConfigDO > page = new Page<>(searchRequest.getCurrent(), searchRequest.getSize());
		List<MailConfigDO> mailConfigDOList = this.mailConfigMapper.search(searchRequest.getId(), searchRequest.getConfigId(), searchRequest.getTitle(),
				searchRequest.getCharset(), searchRequest.getFromName(), searchRequest.getActivityId(), searchRequest.getBeginModifiedDate(),
				searchRequest.getEndModifiedDate(), page);
		List<MailSimpleConfig> mailConfigList = new ArrayList<>();
		for (MailConfigDO gtMailConfigDO : mailConfigDOList) {
			mailConfigList.add(this.mailConfigConverter.convert(gtMailConfigDO));
		}
		return new PageVO<>(mailConfigList,page.getCurrent(),page.getSize(),page.getPages(),page.getTotal());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bench.app.gotone.core.service.MailConfigQueryComponent#
	 * getMailConfigById (long)
	 */
	public MailConfig getMailConfigById(long id) {
		// TODO Auto-generated method stub
		MailConfigDO mailConfigDO = this.mailConfigMapper.selectById(id);
		if (mailConfigDO == null)
			return null;
		MailConfig mailConfig = mailConfigConverter.convert(mailConfigDO);
		mailConfig.setContent(mailConfigBodyMapper.selectById(mailConfigDO.getId()).getMailContent());
		return mailConfig;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bench.app.gotone.core.service.MailConfigQueryComponent#
	 * getCachedMailConfigById(long)
	 */
	public MailConfig getCachedMailConfigById(Integer id) {
		// TODO Auto-generated method stub
		return byIdCacheMap.get(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bench.app.gotone.core.service.mail.MailConfigQueryComponent#
	 * getCachedRandomMailConfigByActivityId(long,
	 * com.bench.app.gotone.core.service.mail.MailConfigFilter)
	 */
	public MailConfig getCachedRandomMailConfigByActivityId(Integer activityId, MailConfigFilter filter) {
		// TODO Auto-generated method stub
		List<MailConfig> mailConfigList = new ArrayList<MailConfig>();
		for (MailConfig mailConfig : this.byIdCacheMap.values()) {
			if (mailConfig.getActivityId() == activityId && filter.accept(mailConfig)) {
				mailConfigList.add(mailConfig);
			}
		}
		return mailConfigList.get(RandomUtils.nextInt(0,mailConfigList.size() - 1));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bench.app.gotone.core.service.mail.MailConfigQueryComponent#
	 * getCachedRandomEnabledMailConfigByActivityId(long)
	 */
	public MailConfig getCachedRandomEnabledMailConfigByActivityId(Integer activityId) {
		// TODO Auto-generated method stub
		return getCachedRandomMailConfigByActivityId(activityId, ENABLED_FILTER);
	}

	public void execute() {
		// TODO Auto-generated method stub
		this.refreshCacheData();
	}

	public boolean isMultiInstance() {
		// TODO Auto-generated method stub
		return false;
	}

	public List<MailConfig> getAllCachedMailConfig() {
		// TODO Auto-generated method stub
		return this.mailConfigList;
	}


	@Override
	public void run(ApplicationArguments args)  {
		this.refreshCacheData();

	}
}
