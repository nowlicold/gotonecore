/*
 * Bench Inc.
 * Copyright (c) 2004 All Rights Reserved.
 */
package com.yuan.gotonecore.repository.table;

import com.bench.common.annotation.DBTable;
import com.bench.common.annotation.DBColumn;

/**
 * A table description for database table <tt>GTC_SMS_CHANNEL_CONFIG</tt>.<br> 
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
@DBTable(name="gtc_sms_channel_config",comments="短信通道配置")
public class SmsChannelConfigTable {

	public static final String TABLE_NAME = "gtc_sms_channel_config";
	//===========column onstants=====
	/**
	 * This constant corresponds to db column <tt>channel_name</tt>.<br>
     */
	 @DBColumn(name="channel_name",dataType="varchar(32)",dataDefault="",dataLength=32,dataPrecision=0,dataScale=0,nullable=false,comments="短信通道名")
	 public static final String COLUMN_CHANNEL_NAME = "channel_name";
	/**
	 * This constant corresponds to db column <tt>support_cell_prefix</tt>.<br>
     */
	 @DBColumn(name="support_cell_prefix",dataType="text",dataDefault="",dataLength=65535,dataPrecision=0,dataScale=0,nullable=false,comments="支持的手机号前缀")
	 public static final String COLUMN_SUPPORT_CELL_PREFIX = "support_cell_prefix";
	/**
	 * This constant corresponds to db column <tt>content_append_prefix</tt>.<br>
     */
	 @DBColumn(name="content_append_prefix",dataType="text",dataDefault="",dataLength=65535,dataPrecision=0,dataScale=0,nullable=true,comments="附加内容前缀")
	 public static final String COLUMN_CONTENT_APPEND_PREFIX = "content_append_prefix";
	/**
	 * This constant corresponds to db column <tt>content_append_suffix</tt>.<br>
     */
	 @DBColumn(name="content_append_suffix",dataType="text",dataDefault="",dataLength=65535,dataPrecision=0,dataScale=0,nullable=true,comments="附加内容后缀")
	 public static final String COLUMN_CONTENT_APPEND_SUFFIX = "content_append_suffix";
	/**
	 * This constant corresponds to db column <tt>gmt_create</tt>.<br>
     */
	 @DBColumn(name="gmt_create",dataType="datetime",dataDefault="",dataLength=0,dataPrecision=0,dataScale=0,nullable=false,comments="创建时间")
	 public static final String COLUMN_GMT_CREATE = "gmt_create";
	/**
	 * This constant corresponds to db column <tt>gmt_modified</tt>.<br>
     */
	 @DBColumn(name="gmt_modified",dataType="datetime",dataDefault="",dataLength=0,dataPrecision=0,dataScale=0,nullable=false,comments="修改时间")
	 public static final String COLUMN_GMT_MODIFIED = "gmt_modified";
	/**
	 * This constant corresponds to db column <tt>weight</tt>.<br>
     */
	 @DBColumn(name="weight",dataType="decimal(4,0)",dataDefault="",dataLength=4,dataPrecision=4,dataScale=0,nullable=false,comments="权重，值大的通道优先考虑")
	 public static final String COLUMN_WEIGHT = "weight";
	/**
	 * This constant corresponds to db column <tt>enabled</tt>.<br>
     */
	 @DBColumn(name="enabled",dataType="decimal(1,0)",dataDefault="",dataLength=1,dataPrecision=1,dataScale=0,nullable=false,comments="是否有效")
	 public static final String COLUMN_ENABLED = "enabled";
	/**
	 * This constant corresponds to db column <tt>run_mode</tt>.<br>
     */
	 @DBColumn(name="run_mode",dataType="varchar(32)",dataDefault="",dataLength=32,dataPrecision=0,dataScale=0,nullable=true,comments="运行模式")
	 public static final String COLUMN_RUN_MODE = "run_mode";
	/**
	 * This constant corresponds to db column <tt>properties</tt>.<br>
     */
	 @DBColumn(name="properties",dataType="text",dataDefault="",dataLength=65535,dataPrecision=0,dataScale=0,nullable=true,comments="属性集合")
	 public static final String COLUMN_PROPERTIES = "properties";
}