/*
 * Bench.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.service.mail;

import com.bench.common.model.PageVO;
import com.yuan.gotonecore.api.request.MailConfigSearchRequest;
import com.yuan.gotonecore.common.mail.MailConfig;
import com.yuan.gotonecore.common.mail.MailSimpleConfig;

import java.util.List;

/**
 * 邮件配置组件
 * 
 * @author cold
 * 
 * @version $Id: MailConfigComponent.java, v 0.1 2012-10-25 下午5:16:25 cold
 *          Exp $
 */
public interface MailConfigQueryComponent {

	/**
	 * 得到缓存的邮件配置
	 * 
	 * @param configName
	 * @return
	 */
	public MailConfig getCachedMailConfigByConfigName(String configName);

	/**
	 * 得到缓存的邮件配置
	 * 
	 * @param id
	 * @return
	 */
	public MailConfig getCachedMailConfigById(Integer id);

	/**
	 * 根据活动Id，得到缓存的随机邮件配置
	 * 
	 * @return
	 */
	public MailConfig getCachedRandomMailConfigByActivityId(Integer activityId, MailConfigFilter filter);

	/**
	 * 根据活动Id，得到缓存的随机邮件配置
	 * 
	 * @return
	 * @param activityId
	 */
	public MailConfig getCachedRandomEnabledMailConfigByActivityId(Integer activityId);

	/**
	 * 得到邮件配置
	 * 
	 * @return
	 */
	public MailConfig getMailConfigByConfigName(String configname);

	/**
	 * 得到邮件配置
	 * 
	 * @param id
	 * @return
	 */
	public MailConfig getMailConfigById(long id);

	/**
	 * 查询邮件配置
	 * 
	 * @param searchRequest
	 * @return
	 */
	public PageVO<MailSimpleConfig> search(MailConfigSearchRequest searchRequest);

	/**
	 * 刷新缓存数据
	 */
	public void refreshCacheData();
	
	/**
	 * 获取全部邮件配置
	 * @return
	 */
	public List<MailConfig> getAllCachedMailConfig();
}
