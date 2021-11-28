/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.api.request;

/**
 * 新增邮件配置
 * 
 * @author cold
 * 
 * @version $Id: MailConfigAddRequest, v 0.1 2010-12-13 下午06:54:25 cold Exp $
 */
public class MailConfigModifyRequest {

	/**
	 * 主键，PK
	 */
	private long id;

	/**
	 * 邮件配置名
	 */
	private String configName;

	/**
	 * 编码
	 */
	private String charset;

	/**
	 * 主题
	 */
	private String subject;

	/**
	 * 发送人姓名
	 */
	private String fromName;

	/**
	 * 内容
	 */
	private String content;

	/**
	 * 操作人
	 */
	private String operator;

	/**
	 * 活动ID
	 */
	private long activityId;

	/**
	 * 是否有效
	 */
	private boolean enabled;

	private long retryIntervalSeconds;

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getFromName() {
		return fromName;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return Returns the operator.
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * @param operator
	 *            The operator to set.
	 */
	public void setOperator(String operator) {
		this.operator = operator;
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
	 * @return Returns the configName.
	 */
	public String getConfigName() {
		return configName;
	}

	/**
	 * @param configName
	 *            The configName to set.
	 */
	public void setConfigName(String configName) {
		this.configName = configName;
	}

	/**
	 * @return Returns the enabled.
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @param enabled
	 *            The enabled to set.
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public long getRetryIntervalSeconds() {
		return retryIntervalSeconds;
	}

	public void setRetryIntervalSeconds(long retryIntervalSeconds) {
		this.retryIntervalSeconds = retryIntervalSeconds;
	}
}
