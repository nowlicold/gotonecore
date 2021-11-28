package com.yuan.gotonecore.common;


import com.bench.lang.base.object.ToStringBuilder;
import lombok.Data;

/**
 * 邮件任务实体
 * 
 * @author cold
 * 
 * @version $Id: MailTaskEntry.java, v 0.1 2011-1-31 下午12:23:49 cold Exp $
 */
@Data
public class MailTaskEntry {

	/**
	 * 邮件ID
	 */
	private Integer mailId;

	/**
	 * 活动ID
	 */
	private Integer activityId;

	/**
	 * 邮件配置ID
	 */
	private Integer mailConfigId;

	/**
	 * 接受人地址
	 */
	private String receiverAddr;

	public MailTaskEntry() {
		super();
	}

	public MailTaskEntry(Integer mailId, Integer activityId, Integer mailConfigId, String receiverAddr) {
		super();
		this.mailId = mailId;
		this.mailConfigId = mailConfigId;
		this.receiverAddr = receiverAddr;
	}



	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}



}
