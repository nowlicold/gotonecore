package com.yuan.gotonecore.common;

import com.bench.common.cache.local.IdGmtModifiedRefreshableCacheObject;
import com.bench.common.model.BaseModel;
import com.yuan.gotonecore.common.enums.SmsChannelEnum;

import java.util.Date;

/**
 * 短信配置
 * 
 * @author cold
 *
 * @version $Id: SmsConfig.java, v 0.1 2017年2月22日 下午2:56:36 cold Exp $
 */
public class SmsConfig extends BaseModel implements IdGmtModifiedRefreshableCacheObject<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8654352474472915370L;

	/**
	 * 短信ID
	 */
	private long id;

	/**
	 * 配置ID
	 */
	private String configName;

	/**
	 * 短信内容
	 */
	private String content;

	/**
	 * 发送通道
	 */
	private SmsChannelEnum[] sendChannels;

	/**
	 * 间隔时间
	 */
	private long intervalSeconds;

	/**
	 * 验证码超时时间
	 */
	private long ackCodeTimeoutSeconds;

	/**
	 * 验证码最大验证次数
	 */
	private int ackCodeMaxValidate;

	/**
	 * 创建时间
	 */
	private Date gmtCreate;

	/**
	 * 修改时间
	 */
	private Date gmtModified;

	/**
	 * 开始发送时间
	 */
	private String sendStartTime;

	/**
	 * 停止发送时间
	 */
	private String sendEndTime;

	/**
	 * 最大尝试次数
	 */
	private int maxTryCount;

	/**
	 * 发送失败后，重试间隔秒数
	 */
	private long retryIntervalSeconds;

	/**
	 * 短信发送是否需要唯一id
	 */
	private boolean smsOutNeedUniqueId;

	/**
	 * @return Returns the id.
	 */
	public Long getId() {
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
	 * @return Returns the intervalSeconds.
	 */
	public long getIntervalSeconds() {
		return intervalSeconds;
	}

	/**
	 * @param intervalSeconds
	 *            The intervalSeconds to set.
	 */
	public void setIntervalSeconds(long intervalSeconds) {
		this.intervalSeconds = intervalSeconds;
	}

	/**
	 * @return Returns the ackCodeTimeoutSeconds.
	 */
	public long getAckCodeTimeoutSeconds() {
		return ackCodeTimeoutSeconds;
	}

	/**
	 * @param ackCodeTimeoutSeconds
	 *            The ackCodeTimeoutSeconds to set.
	 */
	public void setAckCodeTimeoutSeconds(long ackCodeTimeoutSeconds) {
		this.ackCodeTimeoutSeconds = ackCodeTimeoutSeconds;
	}

	/**
	 * @return Returns the ackCodeMaxValidate.
	 */
	public int getAckCodeMaxValidate() {
		return ackCodeMaxValidate;
	}

	/**
	 * @param ackCodeMaxValidate
	 *            The ackCodeMaxValidate to set.
	 */
	public void setAckCodeMaxValidate(int ackCodeMaxValidate) {
		this.ackCodeMaxValidate = ackCodeMaxValidate;
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
	 * @return Returns the sendStartTime.
	 */
	public String getSendStartTime() {
		return sendStartTime;
	}

	/**
	 * @param sendStartTime
	 *            The sendStartTime to set.
	 */
	public void setSendStartTime(String sendStartTime) {
		this.sendStartTime = sendStartTime;
	}

	/**
	 * @return Returns the sendEndTime.
	 */
	public String getSendEndTime() {
		return sendEndTime;
	}

	/**
	 * @param sendEndTime
	 *            The sendEndTime to set.
	 */
	public void setSendEndTime(String sendEndTime) {
		this.sendEndTime = sendEndTime;
	}

	/**
	 * @return Returns the maxTryCount.
	 */
	public int getMaxTryCount() {
		return maxTryCount;
	}

	/**
	 * @param maxTryCount
	 *            The maxTryCount to set.
	 */
	public void setMaxTryCount(int maxTryCount) {
		this.maxTryCount = maxTryCount;
	}

	public long getRetryIntervalSeconds() {
		return retryIntervalSeconds;
	}

	public void setRetryIntervalSeconds(long retryIntervalSeconds) {
		this.retryIntervalSeconds = retryIntervalSeconds;
	}

	public SmsChannelEnum[] getSendChannels() {
		return sendChannels;
	}

	public void setSendChannels(SmsChannelEnum[] sendChannels) {
		this.sendChannels = sendChannels;
	}

	/**
	 * @return Returns the smsOutNeedUniqueId.
	 */
	public boolean isSmsOutNeedUniqueId() {
		return smsOutNeedUniqueId;
	}

	/**
	 * @param smsOutNeedUniqueId
	 *            The smsOutNeedUniqueId to set.
	 */
	public void setSmsOutNeedUniqueId(boolean smsOutNeedUniqueId) {
		this.smsOutNeedUniqueId = smsOutNeedUniqueId;
	}

}
