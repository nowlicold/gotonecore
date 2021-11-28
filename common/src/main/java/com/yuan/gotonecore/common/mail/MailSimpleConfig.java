/*
 * Bench.com Inc.
 * Copyright (c) 2008-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.common.mail;

import com.bench.lang.base.object.ToStringBuilder;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;

/**
 * Mail配置类。
 * 
 * @author min.weixm
 * 
 * @version $Id: Mail.java, v 0.1 2009-9-12 下午02:35:58 min.weixm Exp $
 */
@Data
public class MailSimpleConfig implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6658060552615687975L;

	/**
	 * 邮件ID
	 */
	private Integer id;

	/**
	 * 邮件配置名
	 */
	private String configName;

	/**
	 * 活动ID
	 */
	private Integer activityId;

	/**
	 * 编码
	 */
	private String charset;

	/**
	 * 主题
	 */
	private String subject;

	/**
	 * 修改时间
	 */
	private Date gmtModified;

	/**
	 * 创建时间
	 */
	private Date gmtCreate;

	/**
	 * 发送人姓名
	 */
	private String fromName;

	/**
	 * 是否有效
	 */
	private boolean enabled;

	/**
	 * 发送失败后，重试间隔秒数
	 */
	private long retryIntervalSeconds;



	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}


}
