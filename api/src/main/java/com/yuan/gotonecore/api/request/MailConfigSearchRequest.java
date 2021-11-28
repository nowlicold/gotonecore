/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.api.request;


import com.bench.common.model.PageRequest;

/**
 * 邮件配置分页查询
 * 
 * @author cold
 * 
 * @version $Id: MailConfigSearchRequest.java, v 0.1 2010-12-13 下午07:00:06
 *          cold Exp $
 */
public class MailConfigSearchRequest extends PageRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9008136398342478069L;

	private long id;

	private String configId;

	private String title;

	private String charset;

	private String fromName;

	/**
	 * 
	 */
	private String beginModifiedDate;

	/**
	 * 
	 */
	private String endModifiedDate;

	/**
	 * 发送活动ID
	 */
	private long activityId;

	public String getBeginModifiedDate() {
		return beginModifiedDate;
	}

	public void setBeginModifiedDate(String beginModifiedDate) {
		this.beginModifiedDate = beginModifiedDate;
	}

	public String getEndModifiedDate() {
		return endModifiedDate;
	}

	public void setEndModifiedDate(String endModifiedDate) {
		this.endModifiedDate = endModifiedDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getFromName() {
		return fromName;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	/**
	 * @return Returns the activityId.
	 */
	public long getActivityId() {
		return activityId;
	}

	/**
	 * @param activityId
	 *            The activityId to set.
	 */
	public void setActivityId(long activityId) {
		this.activityId = activityId;
	}

	/**
	 * @return Returns the configId.
	 */
	public String getConfigId() {
		return configId;
	}

	/**
	 * @param configId
	 *            The configId to set.
	 */
	public void setConfigId(String configId) {
		this.configId = configId;
	}

	/**
	 * @return Returns the id.
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            The id to set.
	 */
	public void setId(long id) {
		this.id = id;
	}

}
