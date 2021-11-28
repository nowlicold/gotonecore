/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.common;
import com.bench.common.cache.local.IdGmtModifiedRefreshableCacheObject;
import com.bench.common.model.BaseModel;
import com.yuan.gotonecore.common.enums.SmsChannelEnum;

import java.util.Date;
import java.util.Map;

/**
 * 短信配置在通道上的配置
 * 
 * @author cold
 *
 * @version $Id: SmsConfigInChannel.java, v 0.1 2016年5月13日 下午4:18:15 cold Exp
 *          $
 */
public class SmsConfigInChannel extends BaseModel implements IdGmtModifiedRefreshableCacheObject<Long> {

	/**
	 * 可以直接放入消息模板的kv参数
	 */
	public static final String PARAM_VALUE_START_WITH = "param.value.";

	/**
	 * 映射SmsOutDO中参数的kv参数，key为通道短信中的参数名，值为smsOUt中的参数名，实际传入到通道短信中的值为smsout中的参数值
	 */
	public static final String PARAM_ARG_REPLACE_START_WITH = "param.arg.replace.";

	/**
	 * 映射SmsOutDO中参数的kv参数,如果为空，则使用该默认值
	 */
	public static final String PARAM_ARG_DEFAULT_VALUE_START_WITH = "param.arg.default.";

	/**
	 * 
	 */
	private static final long serialVersionUID = -1935463839176667851L;

	/**
	 * 主键，PK
	 */
	private long id;

	/**
	 * 短信配置ID
	 */
	private long smsConfigId;

	/**
	 * 如果不为空，表示通道需要对短信内容重新定义
	 */
	private String content;

	/**
	 * 发送通道
	 */
	private SmsChannelEnum channel;

	/**
	 * 创建时间
	 */
	private Date gmtCreate;

	/**
	 * 修改时间
	 */
	private Date gmtModified;

	/**
	 * 是否有效
	 */
	private boolean enabled;

	/**
	 * 属性集合
	 */
	private Map<String, String> properties;

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
	 * @return Returns the channel.
	 */
	public SmsChannelEnum getChannel() {
		return channel;
	}

	/**
	 * @param channel
	 *            The channel to set.
	 */
	public void setChannel(SmsChannelEnum channel) {
		this.channel = channel;
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
