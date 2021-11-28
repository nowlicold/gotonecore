/*
 * Bench.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.common;


import com.bench.lang.base.object.ToStringBuilder;
import com.yuan.gotonecore.common.enums.GtMessageTypeEnum;
import com.yuan.gotonecore.common.enums.MessageStatusEnum;
import com.yuan.gotonecore.common.mail.MailConfig;
import com.yuan.gotonecore.common.mail.MailServerConfig;
import com.yuan.gotonecore.common.mail.MailUserConfig;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * 邮件消息模型
 * 
 * @author min.weixm
 * 
 * @version $Id: MailModel.java, v 0.1 2009-9-16 下午02:35:58 min.weixm Exp $
 */
public class MailModel extends GotoneCoreModel implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 4067932797713336057L;

	/** 默认邮件格式 */
	public static final String DEFAULT_CAHRSET = "GBK";

	/** 邮件基本信息 */
	private MailConfig mailConfig;

	/**
	 * 邮件发送配置
	 */
	private MailUserConfig sendMailUserConfig;

	/** 发送服务器 */
	private MailServerConfig mailServerConfig;

	/** 邮件内容 */
	private String mailContent;

	/** 替代参数 */
	private Map<String, String> templateArgs;

	/**
	 * 收件人
	 */
	private String receiver;

	/**
	 * 用户ID
	 */
	private String userId;

	/**
	 * 状态
	 */
	private MessageStatusEnum status;

	/**
	 * 调度时间
	 */
	private Date gmtSchedule;

	/**
	 * 重发时间
	 */
	private Date gmtResend;

	/**
	 * 发送次数
	 */
	private int sendTimes;

	/**
	 * 最后修改时间
	 */
	private Date gmtModified;

	/**
	 * 创建时间
	 */
	private Date gmtCreate;

	/**
	 * 邮件模板配置Id
	 */
	private String mailConfigId;

	/**
	 * 抄送
	 */
	private String mailCc;

	/**
	 * 密送
	 */
	private String mailBcc;

	/**
	 * 回复
	 */
	private String mailReplayTo;

	/**
	 * 邮件主题
	 */
	private String mailSubject;

	/**
	 * 邮件发件人
	 */
	private String mailFrom;

	/**
	 * 发送客户端
	 */
	private String sendClientId;
	
	/**
	 * 邮件内容的生成模式
	 */
	private String mailBodyPattern;

	public MailModel() {
		super();
		this.messageType = GtMessageTypeEnum.MSG_EMAIL;
	}

	/**
	 * Getter method for property <tt>templateArgs</tt>.
	 * 
	 * @return property value of templateArgs
	 */
	public Map<String, String> getTemplateArgs() {
		return templateArgs;
	}

	/**
	 * Setter method for property <tt>templateArgs</tt>.
	 * 
	 * @param
	 */
	public void setTemplateArgs(Map<String, String> templateArgs) {
		this.templateArgs = templateArgs;
	}

	/**
	 * Getter method for property <tt>mailContent</tt>.
	 * 
	 * @return property value of mailContent
	 */
	public String getMailContent() {
		return mailContent;
	}

	/**
	 * Setter method for property <tt>mailContent</tt>.
	 * 
	 * @param
	 */
	public void setMailContent(String mailContent) {
		this.mailContent = mailContent;
	}

	/**
	 * @see Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public MessageStatusEnum getStatus() {
		return status;
	}

	public void setStatus(MessageStatusEnum status) {
		this.status = status;
	}

	public Date getGmtSchedule() {
		return gmtSchedule;
	}

	public void setGmtSchedule(Date gmtSchedule) {
		this.gmtSchedule = gmtSchedule;
	}

	public Date getGmtResend() {
		return gmtResend;
	}

	public void setGmtResend(Date gmtResend) {
		this.gmtResend = gmtResend;
	}

	public int getSendTimes() {
		return sendTimes;
	}

	public void setSendTimes(int sendTimes) {
		this.sendTimes = sendTimes;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public String getMailConfigId() {
		return mailConfigId;
	}

	public void setMailConfigId(String mailConfigId) {
		this.mailConfigId = mailConfigId;
	}

	public String getMailCc() {
		return mailCc;
	}

	public void setMailCc(String mailCc) {
		this.mailCc = mailCc;
	}

	public String getMailBcc() {
		return mailBcc;
	}

	public void setMailBcc(String mailBcc) {
		this.mailBcc = mailBcc;
	}

	public String getMailReplayTo() {
		return mailReplayTo;
	}

	public void setMailReplayTo(String mailReplayTo) {
		this.mailReplayTo = mailReplayTo;
	}

	public String getMailSubject() {
		return mailSubject;
	}

	public void setMailSubject(String mailSubject) {
		this.mailSubject = mailSubject;
	}

	public String getMailFrom() {
		return mailFrom;
	}

	public void setMailFrom(String mailFrom) {
		this.mailFrom = mailFrom;
	}

	public String getSendClientId() {
		return sendClientId;
	}

	public void setSendClientId(String sendClientId) {
		this.sendClientId = sendClientId;
	}

	/**
	 * @return Returns the mailServerConfig.
	 */
	public MailServerConfig getMailServerConfig() {
		return mailServerConfig;
	}

	/**
	 * @param mailServerConfig
	 *            The mailServerConfig to set.
	 */
	public void setMailServerConfig(MailServerConfig mailServerConfig) {
		this.mailServerConfig = mailServerConfig;
	}

	/**
	 * @return Returns the sendMailUserConfig.
	 */
	public MailUserConfig getSendMailUserConfig() {
		return sendMailUserConfig;
	}

	/**
	 * @param sendMailUserConfig
	 *            The sendMailUserConfig to set.
	 */
	public void setSendMailUserConfig(MailUserConfig sendMailUserConfig) {
		this.sendMailUserConfig = sendMailUserConfig;
	}

	/**
	 * @return Returns the mailConfig.
	 */
	public MailConfig getMailConfig() {
		return mailConfig;
	}

	/**
	 * @param mailConfig
	 *            The mailConfig to set.
	 */
	public void setMailConfig(MailConfig mailConfig) {
		this.mailConfig = mailConfig;
	}

	public String getMailBodyPattern() {
		return mailBodyPattern;
	}

	public void setMailBodyPattern(String mailBodyPattern) {
		this.mailBodyPattern = mailBodyPattern;
	}

}
