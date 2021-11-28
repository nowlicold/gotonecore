/**
 * 
 */
package com.yuan.gotonecore.api.sms.request;

import io.swagger.annotations.ApiModelProperty;

/**
 * 短信配置更新请求
 * 
 * @author cold
 *
 * @version $Id: SmsConfigUpdateRequest.java, v 0.1 2017年3月16日 下午6:36:01
 *          Administrator Exp $
 */
public class SmsConfigUpdateRequest {
	/**
	 * 模板配置名
	 */
	@ApiModelProperty(value = "模板配置名")
	private String configName;

	/**
	 * 短信内容
	 */
	@ApiModelProperty(value = "短信内容")
	private String content;

	/**
	 * 发送通道，多个逗号间隔，系统按权重，可用性等进行排序后，返回一个通道，如果不配置，则再全部通道中查找
	 */
	@ApiModelProperty(value = "发送通道，多个逗号间隔，系统按权重，可用性等进行排序后，返回一个通道，如果不配置，则再全部通道中查找")
	private String sendChannels;

	/**
	 * 重复发送间隔时间，如果是5分钟，表明5分钟内只允许发送1次
	 */
	@ApiModelProperty(value = "重复发送间隔时间，如果是5分钟，表明5分钟内只允许发送1次")
	private long intervalSeconds;

	/**
	 * 验证ACKCode的超时时间，小于等于0表示不限制
	 */
	@ApiModelProperty(value = "验证ACKCode的超时时间，小于等于0表示不限制")
	private long ackCodeTimeoutSeconds;

	/**
	 * 验证码最多验证次数，小于等于0表示不限制
	 */
	@ApiModelProperty(value = "验证码最多验证次数，小于等于0表示不限制")
	private int ackCodeMaxValidate;

	/**
	 * 主键，PK
	 */
	@ApiModelProperty(value = "主键，PK")
	private long id;

	/**
	 * 开始发送时间，24小时制，08:00:00
	 */
	@ApiModelProperty(value = "开始发送时间，24小时制，08:00:00")
	private String sendStartTime;

	/**
	 * 截止发送时间，24小时制，22:00:00
	 */
	@ApiModelProperty(value = "截止发送时间，24小时制，22:00:00")
	private String sendEndTime;

	/**
	 * 最大发送重试次数
	 */
	@ApiModelProperty(value = "最大发送重试次数")
	private int maxTryCount;

	/**
	 * 发送失败后，重试间隔秒数
	 */
	@ApiModelProperty(value = "发送失败后，重试间隔秒数")
	private long retryIntervalSeconds;

	/**
	 * 短信发送是否需要唯一id
	 */
	@ApiModelProperty(value = "短信发送是否需要唯一id")
	private boolean smsOutNeedUniqueId;

	public String getConfigName() {
		return configName;
	}

	public void setConfigName(String configName) {
		this.configName = configName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSendChannels() {
		return sendChannels;
	}

	public void setSendChannels(String sendChannels) {
		this.sendChannels = sendChannels;
	}

	public long getIntervalSeconds() {
		return intervalSeconds;
	}

	public void setIntervalSeconds(long intervalSeconds) {
		this.intervalSeconds = intervalSeconds;
	}

	public long getAckCodeTimeoutSeconds() {
		return ackCodeTimeoutSeconds;
	}

	public void setAckCodeTimeoutSeconds(long ackCodeTimeoutSeconds) {
		this.ackCodeTimeoutSeconds = ackCodeTimeoutSeconds;
	}

	public int getAckCodeMaxValidate() {
		return ackCodeMaxValidate;
	}

	public void setAckCodeMaxValidate(int ackCodeMaxValidate) {
		this.ackCodeMaxValidate = ackCodeMaxValidate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSendStartTime() {
		return sendStartTime;
	}

	public void setSendStartTime(String sendStartTime) {
		this.sendStartTime = sendStartTime;
	}

	public String getSendEndTime() {
		return sendEndTime;
	}

	public void setSendEndTime(String sendEndTime) {
		this.sendEndTime = sendEndTime;
	}

	public int getMaxTryCount() {
		return maxTryCount;
	}

	public void setMaxTryCount(int maxTryCount) {
		this.maxTryCount = maxTryCount;
	}

	public long getRetryIntervalSeconds() {
		return retryIntervalSeconds;
	}

	public void setRetryIntervalSeconds(long retryIntervalSeconds) {
		this.retryIntervalSeconds = retryIntervalSeconds;
	}

	public boolean isSmsOutNeedUniqueId() {
		return smsOutNeedUniqueId;
	}

	public void setSmsOutNeedUniqueId(boolean smsOutNeedUniqueId) {
		this.smsOutNeedUniqueId = smsOutNeedUniqueId;
	}

}
