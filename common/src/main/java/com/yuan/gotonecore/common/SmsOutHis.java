/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.common;

import com.bench.lang.base.object.ToStringObject;
import com.yuan.gotonecore.common.enums.MessageStatusEnum;
import com.yuan.gotonecore.common.enums.SmsChannelEnum;

import java.util.Date;
import java.util.Map;

/**
 * 
 * 
 * @author cold
 *
 * @version $Id: SmsOutHis.java, v 0.1 2017年2月22日 下午2:57:39 cold Exp $
 */
public class SmsOutHis extends ToStringObject {
	/**
	 * 主键
	 */
	private long id;

	/**
	 * 接受人手机号码
	 */
	private String receiver;

	/**
	 * 用户号
	 */
	private String userId;

	/**
	 * 内容
	 */
	private String content;

	/**
	 * 状态
	 */
	private MessageStatusEnum status;

	/**
	 * 重发时间
	 */
	private Date gmtResend;

	/**
	 * 发送次数
	 */
	private int sendTimes;

	/**
	 * 修改时间
	 */
	private Date gmtModified;

	/**
	 * 创建时间
	 */
	private Date gmtCreate;

	/**
	 * 短信息使用模版ID
	 */
	private long smsConfigId;

	/**
	 * 消息属性
	 */
	private Map<String, String> properties;

	/**
	 * 消息模板参数
	 */
	private Map<String, String> templateArgs;

	/**
	 * 唯一业务号
	 */
	private String bizId;

	/**
	 * 校验码
	 */
	private String ackCode;

	/**
	 * 历史创建时间
	 */
	private Date gmtHisCreate;

	/**
	 * 成功发送时间
	 */
	private Date gmtSendSuccess;

	/**
	 * ACK_CODE验证成功次数
	 */
	private int ackCodeValidateCount;
	/**
	 * 发送结果
	 */
	private String sendResult;

	/**
	 * 发送通道
	 */
	private SmsChannelEnum sendChannel;

	/**
	 * 发送子通道，由通道自行设置
	 */
	private String sendSubChannel;

	/**
	 * 发送通道是否已指定，如果已指定，则不需要再次自动选择
	 */
	private boolean sendChannelSpecified;

	/**
	 * 如果是重发短信，这里记录重发哪条短信
	 */
	private long resendFromSmsId;

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
	 * @return Returns the receiver.
	 */
	public String getReceiver() {
		return receiver;
	}

	/**
	 * @param receiver
	 *            The receiver to set.
	 */
	public void setReceiver(String receiver) {
		this.receiver = receiver;
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
	 * @return Returns the status.
	 */
	public MessageStatusEnum getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            The status to set.
	 */
	public void setStatus(MessageStatusEnum status) {
		this.status = status;
	}

	/**
	 * @return Returns the gmtResend.
	 */
	public Date getGmtResend() {
		return gmtResend;
	}

	/**
	 * @param gmtResend
	 *            The gmtResend to set.
	 */
	public void setGmtResend(Date gmtResend) {
		this.gmtResend = gmtResend;
	}

	/**
	 * @return Returns the sendTimes.
	 */
	public int getSendTimes() {
		return sendTimes;
	}

	/**
	 * @param sendTimes
	 *            The sendTimes to set.
	 */
	public void setSendTimes(int sendTimes) {
		this.sendTimes = sendTimes;
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
	 * @return Returns the smsConfigId.
	 */
	public long getSmsConfigId() {
		return smsConfigId;
	}

	/**
	 * @param smsConfigId
	 *            The smsConfigId to set.
	 */
	public void setSmsConfigId(long smsConfigId) {
		this.smsConfigId = smsConfigId;
	}

	/**
	 * @return Returns the bizId.
	 */
	public String getBizId() {
		return bizId;
	}

	/**
	 * @param bizId
	 *            The bizId to set.
	 */
	public void setBizId(String bizId) {
		this.bizId = bizId;
	}

	/**
	 * @return Returns the ackCode.
	 */
	public String getAckCode() {
		return ackCode;
	}

	/**
	 * @param ackCode
	 *            The ackCode to set.
	 */
	public void setAckCode(String ackCode) {
		this.ackCode = ackCode;
	}

	/**
	 * @return Returns the gmtHisCreate.
	 */
	public Date getGmtHisCreate() {
		return gmtHisCreate;
	}

	/**
	 * @param gmtHisCreate
	 *            The gmtHisCreate to set.
	 */
	public void setGmtHisCreate(Date gmtHisCreate) {
		this.gmtHisCreate = gmtHisCreate;
	}

	/**
	 * @return Returns the gmtSendSuccess.
	 */
	public Date getGmtSendSuccess() {
		return gmtSendSuccess;
	}

	/**
	 * @param gmtSendSuccess
	 *            The gmtSendSuccess to set.
	 */
	public void setGmtSendSuccess(Date gmtSendSuccess) {
		this.gmtSendSuccess = gmtSendSuccess;
	}

	/**
	 * @return Returns the ackCodeValidateCount.
	 */
	public int getAckCodeValidateCount() {
		return ackCodeValidateCount;
	}

	/**
	 * @param ackCodeValidateCount
	 *            The ackCodeValidateCount to set.
	 */
	public void setAckCodeValidateCount(int ackCodeValidateCount) {
		this.ackCodeValidateCount = ackCodeValidateCount;
	}

	public String getSendResult() {
		return sendResult;
	}

	public void setSendResult(String sendResult) {
		this.sendResult = sendResult;
	}

	public SmsChannelEnum getSendChannel() {
		return sendChannel;
	}

	public void setSendChannel(SmsChannelEnum sendChannel) {
		this.sendChannel = sendChannel;
	}

	public String getSendSubChannel() {
		return sendSubChannel;
	}

	public void setSendSubChannel(String sendSubChannel) {
		this.sendSubChannel = sendSubChannel;
	}

	/**
	 * @return Returns the sendChannelSpecified.
	 */
	public boolean isSendChannelSpecified() {
		return sendChannelSpecified;
	}

	/**
	 * @param sendChannelSpecified
	 *            The sendChannelSpecified to set.
	 */
	public void setSendChannelSpecified(boolean sendChannelSpecified) {
		this.sendChannelSpecified = sendChannelSpecified;
	}

	/**
	 * @return Returns the resendFromSmsId.
	 */
	public long getResendFromSmsId() {
		return resendFromSmsId;
	}

	/**
	 * @param resendFromSmsId
	 *            The resendFromSmsId to set.
	 */
	public void setResendFromSmsId(long resendFromSmsId) {
		this.resendFromSmsId = resendFromSmsId;
	}

	/**
	 * @return Returns the templateArgs.
	 */
	public Map<String, String> getTemplateArgs() {
		return templateArgs;
	}

	/**
	 * @param templateArgs
	 *            The templateArgs to set.
	 */
	public void setTemplateArgs(Map<String, String> templateArgs) {
		this.templateArgs = templateArgs;
	}

	/**
	 * @param properties
	 *            The properties to set.
	 */
	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}

	/**
	 * @return Returns the properties.
	 */
	public Map<String, String> getProperties() {
		return properties;
	}
}
