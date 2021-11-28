package com.yuan.gotonecore.api.request;

import com.yuan.gotonecore.common.enums.GotoneChannelEnum;
import com.yuan.gotonecore.common.enums.MailBodyPatternTypeEnum;
import lombok.Data;

/**
 * 邮件发送请求
 * 
 * @author cold
 * 
 * @version $Id: MailSendRequest.java, v 0.1 2012-10-31 下午6:20:04 cold Exp $
 */
@Data
public class MailSendRequest extends MessageSendRequest {

	/**
	 * 邮件模板的配置名 ，activityCode和mailConfigName必须至少有一个值
	 */
	private String mailConfigName;

	/**
	 * 邮件模板所对应的活动名，activityCode和mailConfigName必须至少有一个值
	 */
	private String activityCode;

	/**
	 * 接收的邮件地址 必选
	 */
	private String receiver;

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
	 * 邮件通道
	 */
	protected GotoneChannelEnum channel = GotoneChannelEnum.DEFAULT;

	/**
	 * 邮件内容：带有邮件内容的邮件发送请求，走另一条邮件发送方式（不存mail_out，直接发送）
	 */
	private String mailContent;
	
	/**
	 * 邮件主题: 若自带邮件内容的发送请求中带来了邮件主题，则以此主题为准
	 */
	private String mailSubject;
	/**
	 * 邮件内容：生成类型
	 */
	private MailBodyPatternTypeEnum mailBodyPattern;

	
	public MailBodyPatternTypeEnum getMailBodyPattern() {
		return mailBodyPattern;
	}

}
