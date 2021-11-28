/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.service;

import com.bench.common.model.PageVO;
import com.yuan.gotonecore.api.request.ActivityQueryRequest;
import com.yuan.gotonecore.common.Activity;

import java.util.List;

/**
 * 获取组件
 * 
 * @author cold
 * 
 * @version $Id: ActivityComponent.java, v 0.1 2012-10-25 下午6:16:47 cold Exp
 *          $
 */
public interface ActivityQueryComponent {

	/**
	 * 活动ID
	 * 
	 * @param activityId
	 * @return
	 */
	public Activity getById(Integer activityId);

	/**
	 * 活动ID
	 * 
	 * @param activityId
	 * @return
	 */
	public Activity getCachedById(Integer activityId);

	/**
	 * 活动ID
	 * 
	 * @param
	 * @return
	 */
	public Activity getCachedByCode(String activityCode);

	/**
	 * 活动ID
	 * 
	 * @param
	 * @return
	 */
	public Activity getByCode(String activityCode);

	/**
	 * 重载缓存数据
	 */
	public void refreshCacheData();

	/**
	 * 查询活动
	 * 
	 * @param request
	 * @return
	 */
	public PageVO<Activity> search(ActivityQueryRequest request);
	
	/**
	 * 获取所有活动
	 * @return
	 */
	public List<Activity> getCachedAllActivity();
}
