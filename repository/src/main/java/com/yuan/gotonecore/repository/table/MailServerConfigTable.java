/*
 * Bench Inc.
 * Copyright (c) 2004 All Rights Reserved.
 */
package com.yuan.gotonecore.repository.table;

import com.bench.common.annotation.DBTable;
import com.bench.common.annotation.DBColumn;

/**
 * A table description for database table <tt>GTC_MAIL_SERVER_CONFIG</tt>.<br> 
 * 邮件发送通道配置
 * 
 *
 * This file is generated by <tt>bench-gen-dal</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>bench</tt> project.
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/biz/dal/src/conf/dalgen</tt>, and 
 * find the corresponding configuration file (<tt>tables/gtc_mail_server_config.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>bench-gen-dal</tt> 
 * to generate this file.
 *
 * @author nowli
 */
@DBTable(name="gtc_mail_server_config",comments="邮件发送通道配置")
public class MailServerConfigTable {

	public static final String TABLE_NAME = "gtc_mail_server_config";
	//===========column onstants=====
	/**
	 * This constant corresponds to db column <tt>id</tt>.<br>
     */
	 @DBColumn(name="id",dataType="decimal(15,0)",dataDefault="",dataLength=15,dataPrecision=15,dataScale=0,nullable=false,comments="主键，PK")
	 public static final String COLUMN_ID = "id";
	/**
	 * This constant corresponds to db column <tt>host</tt>.<br>
     */
	 @DBColumn(name="host",dataType="varchar(64)",dataDefault="",dataLength=64,dataPrecision=0,dataScale=0,nullable=false,comments="主机")
	 public static final String COLUMN_HOST = "host";
	/**
	 * This constant corresponds to db column <tt>port</tt>.<br>
     */
	 @DBColumn(name="port",dataType="decimal(16,0)",dataDefault="",dataLength=16,dataPrecision=16,dataScale=0,nullable=false,comments="端口")
	 public static final String COLUMN_PORT = "port";
	/**
	 * This constant corresponds to db column <tt>timeout</tt>.<br>
     */
	 @DBColumn(name="timeout",dataType="decimal(10,0)",dataDefault="",dataLength=10,dataPrecision=10,dataScale=0,nullable=false,comments="超时")
	 public static final String COLUMN_TIMEOUT = "timeout";
	/**
	 * This constant corresponds to db column <tt>connect_timeout</tt>.<br>
     */
	 @DBColumn(name="connect_timeout",dataType="decimal(10,0)",dataDefault="",dataLength=10,dataPrecision=10,dataScale=0,nullable=false,comments="连接超时")
	 public static final String COLUMN_CONNECT_TIMEOUT = "connect_timeout";
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
	 * This constant corresponds to db column <tt>domain_name</tt>.<br>
     */
	 @DBColumn(name="domain_name",dataType="varchar(64)",dataDefault="",dataLength=64,dataPrecision=0,dataScale=0,nullable=true,comments="邮件域")
	 public static final String COLUMN_DOMAIN_NAME = "domain_name";
}
