/*
 * Bench Inc.
 * Copyright (c) 2004 All Rights Reserved.
 */
package com.yuan.gotonecore.common;
import com.bench.common.cache.local.GmtModifiedRefreshableCacheObject;
import com.bench.common.model.BaseModel;
import com.bench.lang.base.string.utils.StringUtils;
import com.yuan.gotonecore.common.enums.SmsChannelEnum;
import com.yuan.gotonecore.common.enums.SmsChannelRunModeEnum;

import java.util.Date;
import java.util.Map;

/**
 * 短信通道配置
 * 
 * @author fangbianmian
 *
 * @version $Id: SmsChannelConfig.java, v 0.1 2017年2月23日 下午3:58:16 Administrator
 *          Exp $
 */
public class SmsChannelConfig extends BaseModel implements GmtModifiedRefreshableCacheObject<SmsChannelEnum> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4377043340206522128L;

	// ========== properties ==========
	/**
	 * 短信通道码
	 */
	private SmsChannelEnum channel;

	/**
	 * 支持的手机号前缀
	 */
	private String[] supportCellPrefixs;
	/**
	 * 附加内容前缀
	 */
	private String contentAppendPrefix;

	/**
	 * 附加内容后缀
	 */
	private String contentAppendSuffix;

	/**
	 * 创建时间
	 */
	private Date gmtCreate;

	/**
	 * 修改时间
	 */
	private Date gmtModified;
	/**
	 * 权重，值大的通道优先考虑
	 */
	private int weight;
	/**
	 * 是否有效
	 */
	private boolean enabled;

	/**
	 * This property corresponds to db column <tt>RUN_MODE</tt>.<br>
	 * 运行模式
	 */
	private SmsChannelRunModeEnum runMode;

	/**
	 * 属性集合
	 */
	private Map<String, String> properties;

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * 是否支持该手机号前缀
	 * 
	 * @param cell
	 * @return
	 */
	public boolean supportPrefixCell(String cell) {
		for (String supportCellPrefix : this.supportCellPrefixs) {
			if (StringUtils.startsWith(cell, supportCellPrefix)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 是否支持所有手机号
	 * 
	 * @return
	 */
	public boolean supportAllCell() {
		for (String supportCellPrefix : this.supportCellPrefixs) {
			if (StringUtils.equals(supportCellPrefix, StringUtils.ASTERRISK_SIGN)) {
				return true;
			}
		}
		return false;
	}

	public String[] getSupportCellPrefixs() {
		return supportCellPrefixs;
	}

	public void setSupportCellPrefixs(String[] supportCellPrefixs) {
		this.supportCellPrefixs = supportCellPrefixs;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public SmsChannelEnum getChannel() {
		return channel;
	}

	public void setChannel(SmsChannelEnum channel) {
		this.channel = channel;
	}

	public String getContentAppendPrefix() {
		return contentAppendPrefix;
	}

	public void setContentAppendPrefix(String contentAppendPrefix) {
		this.contentAppendPrefix = contentAppendPrefix;
	}

	public String getContentAppendSuffix() {
		return contentAppendSuffix;
	}

	public void setContentAppendSuffix(String contentAppendSuffix) {
		this.contentAppendSuffix = contentAppendSuffix;
	}

	public SmsChannelRunModeEnum getRunMode() {
		return runMode;
	}

	public void setRunMode(SmsChannelRunModeEnum runMode) {
		this.runMode = runMode;
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

	public SmsChannelEnum returnCacheKey() {
		return this.channel;
	}

}
