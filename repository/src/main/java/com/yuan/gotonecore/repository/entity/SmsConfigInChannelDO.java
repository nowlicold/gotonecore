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
 * A data object class directly models database table <tt>gtc_sms_config_in_channel</tt>.<br>
 * 短信配置在通道方的配置
 * 
 *
 * This file is generated by <tt>bench-gen-dal</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>bench</tt> project.
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/biz/dal/src/conf/dalgen</tt>, and 
 * find the corresponding configuration file (<tt>tables/gtc_sms_config_in_channel.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>bench-gen-dal</tt> 
 * to generate this file.
 *
 * @author nowli
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="SmsConfigInChannelDO对象", description="短信配置在通道方的配置")
@TableName("gtc_sms_config_in_channel")
public class SmsConfigInChannelDO implements Serializable  {
    private static final long serialVersionUID = 741231858441822688L;

	public static final String TABLE_NAME = "GTC_SMS_CONFIG_IN_CHANNEL";
	//===========column onstants=====
	/**
	 * This constant corresponds to db column <tt>id</tt>.<br>
     */
	 public static final String COLUMN_ID = "id";
	/**
	 * This constant corresponds to db column <tt>sms_config_id</tt>.<br>
     */
	 public static final String COLUMN_SMS_CONFIG_ID = "sms_config_id";
	/**
	 * This constant corresponds to db column <tt>content</tt>.<br>
     */
	 public static final String COLUMN_CONTENT = "content";
	/**
	 * This constant corresponds to db column <tt>channel</tt>.<br>
     */
	 public static final String COLUMN_CHANNEL = "channel";
	/**
	 * This constant corresponds to db column <tt>gmt_create</tt>.<br>
     */
	 public static final String COLUMN_GMT_CREATE = "gmt_create";
	/**
	 * This constant corresponds to db column <tt>gmt_modified</tt>.<br>
     */
	 public static final String COLUMN_GMT_MODIFIED = "gmt_modified";
	/**
	 * This constant corresponds to db column <tt>enabled</tt>.<br>
     */
	 public static final String COLUMN_ENABLED = "enabled";
	/**
	 * This constant corresponds to db column <tt>properties</tt>.<br>
     */
	 public static final String COLUMN_PROPERTIES = "properties";
	
	//========== properties ==========

	/**
	 * This property corresponds to db column <tt>id</tt>.<br>
     * 主键，PK
     */
	 @TableId(type = IdType.NONE)
	private long id;
	
	/**
	 * This property corresponds to db column <tt>sms_config_id</tt>.<br>
     * 短信配置ID
     */
	private long smsConfigId;
	
	/**
	 * This property corresponds to db column <tt>content</tt>.<br>
     * 
     */
	private String content;
	
	/**
	 * This property corresponds to db column <tt>channel</tt>.<br>
     * 
     */
	private String channel;
	
	/**
	 * This property corresponds to db column <tt>gmt_create</tt>.<br>
     * 
     */
	private Date gmtCreate;
	
	/**
	 * This property corresponds to db column <tt>gmt_modified</tt>.<br>
     * 
     */
	private Date gmtModified;
	
	/**
	 * This property corresponds to db column <tt>enabled</tt>.<br>
     * 
     */
	private boolean enabled;
	
	/**
	 * This property corresponds to db column <tt>properties</tt>.<br>
     * 
     */
	private String properties;
	

    //========== getters and setters ==========

}
