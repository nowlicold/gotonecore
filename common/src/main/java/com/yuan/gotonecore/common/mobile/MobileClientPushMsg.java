/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.common.mobile;

import com.bench.common.model.BaseModel;
import com.yuan.gotonecore.common.enums.MobileClientPushMsgStatusEnum;

import java.util.Date;
import java.util.Map;

/**
 * 移动客户端消息推送
 * 
 * @author fangbianmian
 *
 * @version $Id: MobileClientPushMsg.java, v 0.1 2017年2月24日 下午2:46:38
 *          Administrator Exp $
 */
public class MobileClientPushMsg extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2725655431020916668L;

	/**
	 * 主键，PK
	 */
	private long id;

	/**
	 * 会员ID
	 */
	private String userId;

	/**
	 * 推送内容
	 */
	private String content;

	/**
	 * 创建时间
	 */
	private Date gmtCreate;

	/**
	 * 修改时间
	 */
	private Date gmtModified;

	/**
	 * 下次推送时间
	 */
	private Date gmtNextPush;

	/**
	 * 尝试次数
	 */
	private long tryCount;

	/**
	 * 推送结果
	 */
	private String pushResult;

	/**
	 * 状态
	 */
	private MobileClientPushMsgStatusEnum status;

	/**
	 * 源消息ID
	 */
	private String sourceMessageId;

	/**
	 * 源系统代码
	 */
	private String sourceAppName;

	/**
	 * 消息类型
	 */
	private Map<String, String> properties;

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
	 * @return Returns the userId.
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            The userId to set.
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return Returns the content.
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            The content to set.
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return Returns the gmtCreate.
	 */
	public Date getGmtCreate() {
		return gmtCreate;
	}

	/**
	 * @param gmtCreate
	 *            The gmtCreate to set.
	 */
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	/**
	 * @return Returns the gmtModified.
	 */
	public Date getGmtModified() {
		return gmtModified;
	}

	/**
	 * @param gmtModified
	 *            The gmtModified to set.
	 */
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	/**
	 * @return Returns the gmtNextPush.
	 */
	public Date getGmtNextPush() {
		return gmtNextPush;
	}

	/**
	 * @param gmtNextPush
	 *            The gmtNextPush to set.
	 */
	public void setGmtNextPush(Date gmtNextPush) {
		this.gmtNextPush = gmtNextPush;
	}

	/**
	 * @return Returns the tryCount.
	 */
	public long getTryCount() {
		return tryCount;
	}

	/**
	 * @param tryCount
	 *            The tryCount to set.
	 */
	public void setTryCount(long tryCount) {
		this.tryCount = tryCount;
	}

	/**
	 * @return Returns the pushResult.
	 */
	public String getPushResult() {
		return pushResult;
	}

	/**
	 * @param pushResult
	 *            The pushResult to set.
	 */
	public void setPushResult(String pushResult) {
		this.pushResult = pushResult;
	}

	/**
	 * @return Returns the status.
	 */
	public MobileClientPushMsgStatusEnum getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            The status to set.
	 */
	public void setStatus(MobileClientPushMsgStatusEnum status) {
		this.status = status;
	}

	/**
	 * @return Returns the sourceMessageId.
	 */
	public String getSourceMessageId() {
		return sourceMessageId;
	}

	/**
	 * @param sourceMessageId
	 *            The sourceMessageId to set.
	 */
	public void setSourceMessageId(String sourceMessageId) {
		this.sourceMessageId = sourceMessageId;
	}

	/**
	 * @return Returns the sourceAppName.
	 */
	public String getSourceAppName() {
		return sourceAppName;
	}

	/**
	 * @param sourceAppName
	 *            The sourceAppName to set.
	 */
	public void setSourceAppName(String sourceAppName) {
		this.sourceAppName = sourceAppName;
	}

	/**
	 * @return Returns the properties.
	 */
	public Map<String, String> getProperties() {
		return properties;
	}

	/**
	 * @param properties
	 *            The properties to set.
	 */
	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}

}
