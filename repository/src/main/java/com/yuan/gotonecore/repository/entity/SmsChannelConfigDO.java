/*
 * Bench Inc.
 * Copyright (c) 2004 All Rights Reserved.
 */
package com.yuan.gotonecore.repository.entity;

// auto generated imports
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * A data object class directly models database table <tt>gtc_sms_channel_config</tt>.<br>
 * 短信通道配置
 * 
 *
 * This file is generated by <tt>bench-gen-dal</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>bench</tt> project.
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/biz/dal/src/conf/dalgen</tt>, and 
 * find the corresponding configuration file (<tt>tables/gtc_sms_channel_config.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>bench-gen-dal</tt> 
 * to generate this file.
 *
 * @author nowli
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="SmsChannelConfigDO对象", description="短信通道配置")
@TableName("gtc_sms_channel_config")
public class SmsChannelConfigDO implements Serializable  {
    private static final long serialVersionUID = 741231858441822688L;

	public static final String TABLE_NAME = "GTC_SMS_CHANNEL_CONFIG";
	//===========column onstants=====
	/**
	 * This constant corresponds to db column <tt>channel_name</tt>.<br>
     */
	 public static final String COLUMN_CHANNEL_NAME = "channel_name";
	/**
	 * This constant corresponds to db column <tt>support_cell_prefix</tt>.<br>
     */
	 public static final String COLUMN_SUPPORT_CELL_PREFIX = "support_cell_prefix";
	/**
	 * This constant corresponds to db column <tt>content_append_prefix</tt>.<br>
     */
	 public static final String COLUMN_CONTENT_APPEND_PREFIX = "content_append_prefix";
	/**
	 * This constant corresponds to db column <tt>content_append_suffix</tt>.<br>
     */
	 public static final String COLUMN_CONTENT_APPEND_SUFFIX = "content_append_suffix";
	/**
	 * This constant corresponds to db column <tt>gmt_create</tt>.<br>
     */
	 public static final String COLUMN_GMT_CREATE = "gmt_create";
	/**
	 * This constant corresponds to db column <tt>gmt_modified</tt>.<br>
     */
	 public static final String COLUMN_GMT_MODIFIED = "gmt_modified";
	/**
	 * This constant corresponds to db column <tt>weight</tt>.<br>
     */
	 public static final String COLUMN_WEIGHT = "weight";
	/**
	 * This constant corresponds to db column <tt>enabled</tt>.<br>
     */
	 public static final String COLUMN_ENABLED = "enabled";
	/**
	 * This constant corresponds to db column <tt>run_mode</tt>.<br>
     */
	 public static final String COLUMN_RUN_MODE = "run_mode";
	/**
	 * This constant corresponds to db column <tt>properties</tt>.<br>
     */
	 public static final String COLUMN_PROPERTIES = "properties";
	
	//========== properties ==========

	/**
	 * This property corresponds to db column <tt>channel_name</tt>.<br>
     * 短信通道名
     */
	 @TableId(type = IdType.NONE)
	private String channelName;
	
	/**
	 * This property corresponds to db column <tt>support_cell_prefix</tt>.<br>
     * 支持的手机号前缀
     */
	private String supportCellPrefix;
	
	/**
	 * This property corresponds to db column <tt>content_append_prefix</tt>.<br>
     * 附加内容前缀
     */
	private String contentAppendPrefix;
	
	/**
	 * This property corresponds to db column <tt>content_append_suffix</tt>.<br>
     * 附加内容后缀
     */
	private String contentAppendSuffix;
	
	/**
	 * This property corresponds to db column <tt>gmt_create</tt>.<br>
     * 创建时间
     */
	private Date gmtCreate;
	
	/**
	 * This property corresponds to db column <tt>gmt_modified</tt>.<br>
     * 修改时间
     */
	private Date gmtModified;
	
	/**
	 * This property corresponds to db column <tt>weight</tt>.<br>
     * 权重，值大的通道优先考虑
     */
	private int weight;
	
	/**
	 * This property corresponds to db column <tt>enabled</tt>.<br>
     * 是否有效
     */
	private boolean enabled;
	
	/**
	 * This property corresponds to db column <tt>run_mode</tt>.<br>
     * 运行模式
     */
	private String runMode;
	
	/**
	 * This property corresponds to db column <tt>properties</tt>.<br>
     * 属性集合
     */
	private String properties;
	

    //========== getters and setters ==========

}