/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.service.mail.impl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bench.common.model.PageVO;
import com.bench.runtime.convert.ConverterManager;
import com.bench.xtask.BenchDistributeTask;
import com.bench.xtask.annotation.DistributeTask;
import com.yuan.gotonecore.api.request.MailServerConfigSearchRequest;
import com.yuan.gotonecore.common.mail.MailServerConfig;
import com.yuan.gotonecore.repository.entity.MailServerConfigDO;
import com.yuan.gotonecore.repository.mapper.MailServerConfigMapper;
import com.yuan.gotonecore.service.mail.MailServerConfigQueryComponent;
import com.yuan.gotonecore.service.mail.converter.MailServerConfigConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author cold
 * 
 * @version $Id: MailServerConfigQueryComponentImpl.java, v 0.1 2012-10-26
 *          上午11:14:23 cold Exp $
 */
@Service
@DistributeTask(repeatIntervalMillseconds = 11000)
public class MailServerConfigQueryComponentImpl implements MailServerConfigQueryComponent, BenchDistributeTask, ApplicationRunner {

	private Date lastGmtModified;

	@Autowired
	private ConverterManager converterManager;
	@Autowired
	private MailServerConfigConverter mailServerConfigConverter;
	@Autowired
	private MailServerConfigMapper mailServerConfigMapper;

	/** 构建邮件传输的Transport对象集 */
	private Map<Long, MailServerConfig> mailServerConfigMap = new HashMap<Long, MailServerConfig>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bench.app.gotone.core.service.common.MailServerConfigQueryComponent
	 * #refreshCacheData()
	 */
	public void refreshCacheData() {
		// TODO Auto-generated method stub
		Date currentGmtModifed = mailServerConfigMapper.selectMaxGmtModified();
		List<MailServerConfigDO> mailServerConfigDOList = null;
		Map<Long, MailServerConfig> temp = new HashMap<Long, MailServerConfig>();
		if (lastGmtModified == null || !lastGmtModified.equals(currentGmtModifed)) {
			mailServerConfigDOList = mailServerConfigMapper.selectAll();
			for (MailServerConfigDO configDO : mailServerConfigDOList) {
				MailServerConfig tc = new MailServerConfig();
				converterManager.convert(configDO, tc);
				temp.put(tc.getId(), tc);
			}
			this.mailServerConfigMap = temp;
			lastGmtModified = currentGmtModifed;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bench.app.gotone.core.service.common.MailServerConfigQueryComponent
	 * #search(com.bench.app.gotone.common.service.facade.request.
	 * MailServerConfigSearchRequest)
	 */
	public PageVO<MailServerConfig> search(MailServerConfigSearchRequest request) {
		// TODO Auto-generated method stub
		Page<MailServerConfigDO> page = new Page<>(request.getCurrent(),request.getSize());

		List<MailServerConfigDO> mailServerConfigDOList = this.mailServerConfigMapper.search(request.getId(), request.getHost(), request.getPort(),
				request.getConnectTimeout(), request.getTimeout(), request.getDomainName(), request.getBeginModifiedDate(), request.getEndModifiedDate(),page);


		PageVO<MailServerConfig> pageVO = new PageVO<MailServerConfig>(this.mailServerConfigConverter.convert(mailServerConfigDOList),page.getCurrent(),page.getSize(),page.getPages(),page.getTotal());

		return pageVO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bench.app.gotone.core.service.common.MailServerConfigQueryComponent
	 * #getCachedTransportConfig(long)
	 */
	public MailServerConfig getCachedMailServerConfig(long id) {
		// TODO Auto-generated method stub
		return mailServerConfigMap.get(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bench.app.gotone.core.service.common.MailServerConfigQueryComponent
	 * #getById(long)
	 */
	public MailServerConfig getById(long id) {
		// TODO Auto-generated method stub
		MailServerConfigDO configDO = this.mailServerConfigMapper.selectById(id);
		return configDO == null ? null : this.mailServerConfigConverter.convert(configDO);
	}

	/**
	 * @param lastGmtModified
	 *            The lastGmtModified to set.
	 */
	public void setLastGmtModified(Date lastGmtModified) {
		this.lastGmtModified = lastGmtModified;
	}

	public void execute() {
		// TODO Auto-generated method stub
		this.refreshCacheData();
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		this.refreshCacheData();

	}
}
