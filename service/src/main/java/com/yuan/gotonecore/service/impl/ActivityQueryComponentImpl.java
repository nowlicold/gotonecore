/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bench.common.model.PageVO;
import com.bench.lang.base.object.utils.ObjectUtils;
import com.yuan.gotonecore.api.request.ActivityQueryRequest;
import com.yuan.gotonecore.common.Activity;
import com.yuan.gotonecore.repository.entity.ActivityDO;
import com.yuan.gotonecore.repository.mapper.ActivityMapper;
import com.yuan.gotonecore.service.ActivityQueryComponent;
import com.yuan.gotonecore.service.convert.ActivityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 
 * @author cold
 * 
 * @version $Id: ActivityQueryComponentImpl.java, v 0.1 2012-10-26 下午5:21:21
 *          cold Exp $
 */
@Service
public class ActivityQueryComponentImpl implements ActivityQueryComponent, ApplicationRunner {

	@Autowired
	private ActivityMapper activityMapper;
	@Autowired
	private ActivityConverter activityConverter;

	private Date lastActivityGmtModified;

	private Map<String, Activity> byActivityCodeCacheMap = new HashMap<String, Activity>();

	private Map<Integer, Activity> byIdCacheMap = new HashMap<Integer, Activity>();

	private List<Activity> activityList = new ArrayList<Activity>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bench.app.gotone.core.service.common.ActivityQueryComponent#getById
	 * (long)
	 */
	public Activity getById(Integer activityId) {
		// TODO Auto-generated method stub
		ActivityDO activityDO = activityMapper.getById(activityId);
		return activityDO == null ? null : activityConverter.convert(activityDO);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bench.app.gotone.core.service.common.ActivityQueryComponent#search
	 * (com.bench.app.gotone.common.service.facade.request.ActivityQueryRequest)
	 */
	public PageVO<Activity> search(ActivityQueryRequest searchRequest) {
		// TODO Auto-generated method stub
		Page< ActivityDO> page = new Page<>(searchRequest.getCurrent(), searchRequest.getSize());

		List<ActivityDO> activityDOList = this.activityMapper.search(searchRequest.getActivityName(), searchRequest.getActivityCode(),
				ObjectUtils.toString(searchRequest.getStatus()), searchRequest.getBeginModifiedDate(), searchRequest.getEndModifiedDate(), page);
		for (ActivityDO dataDO : activityDOList) {
			activityList.add(this.activityConverter.convert(dataDO));
		}
		return new PageVO<>(activityList,page.getCurrent(),page.getSize(),page.getPages(),page.getTotal());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bench.app.gotone.core.service.ActivityQueryComponent#getByCode(java
	 * .lang.String)
	 */
	public Activity getByCode(String activityCode) {
		// TODO Auto-generated method stub
		ActivityDO activityDO = activityMapper.getByActivityCode(activityCode);
		return activityDO == null ? null : activityConverter.convert(activityDO);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bench.app.gotone.core.service.ActivityQueryComponent#refreshCacheData
	 * ()
	 */
	public void refreshCacheData() {
		// TODO Auto-generated method stub
		// 加载邮件配置
		Date currentGmtModifed = activityMapper.selectMaxGmtModified();
		List<ActivityDO> updateActivityDOList = null;
		if (lastActivityGmtModified == null) {
			updateActivityDOList = activityMapper.selectAll();
		} else if (!lastActivityGmtModified.equals(currentGmtModifed)) {
			updateActivityDOList = activityMapper.selectGreaterThanModifiedDate(lastActivityGmtModified);
		}
		if (updateActivityDOList != null) {
			for (ActivityDO activityDO : updateActivityDOList) {
				Activity activity = this.activityConverter.convert(activityDO);
				this.byActivityCodeCacheMap.put(activity.getActivityCode(), activity);
				byIdCacheMap.put(activity.getId(), activity);
				activityList.add(activity);
			}
			lastActivityGmtModified = currentGmtModifed;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bench.app.gotone.core.service.ActivityQueryComponent#getCachedById
	 * (long)
	 */
	public Activity getCachedById(Integer activityId) {
		// TODO Auto-generated method stub
		return byIdCacheMap.get(activityId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bench.app.gotone.core.service.ActivityQueryComponent#getCachedByCode
	 * (java.lang.String)
	 */
	public Activity getCachedByCode(String activityCode) {
		// TODO Auto-generated method stub
		return this.byActivityCodeCacheMap.get(activityCode);
	}

	public List<Activity> getCachedAllActivity() {
		// TODO Auto-generated method stub
		return this.activityList;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		this.refreshCacheData();
	}
}
