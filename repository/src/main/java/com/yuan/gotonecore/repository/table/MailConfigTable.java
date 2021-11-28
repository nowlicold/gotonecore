/*
 * Bench Inc.
 * Copyright (c) 2004 All Rights Reserved.
 */
package com.yuan.gotonecore.repository.table;

import com.bench.common.annotation.DBTable;
import com.bench.common.annotation.DBColumn;

/**
 * A table description for database table <tt>GTC_MAIL_CONFIG</tt>.<br> 
 * 邮件配置
 * 
 *
 * This file is generated by <tt>bench-gen-dal</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>bench</tt> project.
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/biz/dal/src/conf/dalgen</tt>, and 
 * find the corresponding configuration file (<tt>tables/gtc_mail_config.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>bench-gen-dal</tt> 
 * to generate this file.
 *
 * @author nowli
 */
@DBTable(name="gtc_mail_config",comments="邮件配置")
public class MailConfigTable {

	public static final String TABLE_NAME = "gtc_mail_config";
	//===========column onstants=====
	/**
	 * This constant corresponds to db column <tt>charset</tt>.<br>
     */
	 @DBColumn(name="charset",dataType="varchar(8)",dataDefault="",dataLength=8,dataPrecision=0,dataScale=0,nullable=false,comments="编码")
	 public static final String COLUMN_CHARSET = "charset";
	/**
	 * This constant corresponds to db column <tt>subject</tt>.<br>
     */
	 @DBColumn(name="subject",dataType="text",dataDefault="",dataLength=65535,dataPrecision=0,dataScale=0,nullable=false,comments="主题")
	 public static final String COLUMN_SUBJECT = "subject";
	/**
	 * This constant corresponds to db column <tt>gmt_modified</tt>.<br>
     */
	 @DBColumn(name="gmt_modified",dataType="datetime",dataDefault="",dataLength=0,dataPrecision=0,dataScale=0,nullable=false,comments="")
	 public static final String COLUMN_GMT_MODIFIED = "gmt_modified";
	/**
	 * This constant corresponds to db column <tt>gmt_create</tt>.<br>
     */
	 @DBColumn(name="gmt_create",dataType="datetime",dataDefault="",dataLength=0,dataPrecision=0,dataScale=0,nullable=false,comments="")
	 public static final String COLUMN_GMT_CREATE = "gmt_create";
	/**
	 * This constant corresponds to db column <tt>from_name</tt>.<br>
     */
	 @DBColumn(name="from_name",dataType="text",dataDefault="",dataLength=65535,dataPrecision=0,dataScale=0,nullable=false,comments="发送人姓名")
	 public static final String COLUMN_FROM_NAME = "from_name";
	/**
	 * This constant corresponds to db column <tt>activity_id</tt>.<br>
     */
	 @DBColumn(name="activity_id",dataType="decimal(15,0)",dataDefault="",dataLength=15,dataPrecision=15,dataScale=0,nullable=true,comments="活动ID")
	 public static final String COLUMN_ACTIVITY_ID = "activity_id";
	/**
	 * This constant corresponds to db column <tt>config_name</tt>.<br>
     */
	 @DBColumn(name="config_name",dataType="varchar(64)",dataDefault="",dataLength=64,dataPrecision=0,dataScale=0,nullable=false,comments="模板ID")
	 public static final String COLUMN_CONFIG_NAME = "config_name";
	/**
	 * This constant corresponds to db column <tt>id</tt>.<br>
     */
	 @DBColumn(name="id",dataType="decimal(15,0)",dataDefault="",dataLength=15,dataPrecision=15,dataScale=0,nullable=false,comments="主键，PK")
	 public static final String COLUMN_ID = "id";
	/**
	 * This constant corresponds to db column <tt>enabled</tt>.<br>
     */
	 @DBColumn(name="enabled",dataType="char(1)",dataDefault="",dataLength=1,dataPrecision=0,dataScale=0,nullable=true,comments="是否有效")
	 public static final String COLUMN_ENABLED = "enabled";
	/**
	 * This constant corresponds to db column <tt>retry_interval_seconds</tt>.<br>
     */
	 @DBColumn(name="retry_interval_seconds",dataType="decimal(15,0)",dataDefault="",dataLength=15,dataPrecision=15,dataScale=0,nullable=true,comments="发送失败后，重试间隔秒数")
	 public static final String COLUMN_RETRY_INTERVAL_SECONDS = "retry_interval_seconds";
}