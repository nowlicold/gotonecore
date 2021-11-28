/*
 * Bench Inc.
 * Copyright (c) 2004 All Rights Reserved.
 */
package com.yuan.gotonecore.repository.table;

import com.bench.common.annotation.DBTable;
import com.bench.common.annotation.DBColumn;

/**
 * A table description for database table <tt>GTC_MOBILE_CLIENT_SETTING</tt>.<br> 
 * 移动客户端设置
 * 
 *
 * This file is generated by <tt>bench-gen-dal</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>bench</tt> project.
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/biz/dal/src/conf/dalgen</tt>, and 
 * find the corresponding configuration file (<tt>tables/gtc_mobile_client_setting.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>bench-gen-dal</tt> 
 * to generate this file.
 *
 * @author nowli
 */
@DBTable(name="gtc_mobile_client_setting",comments="移动客户端设置")
public class MobileClientSettingTable {

	public static final String TABLE_NAME = "gtc_mobile_client_setting";
	//===========column onstants=====
	/**
	 * This constant corresponds to db column <tt>id</tt>.<br>
     */
	 @DBColumn(name="id",dataType="decimal(15,0)",dataDefault="",dataLength=15,dataPrecision=15,dataScale=0,nullable=false,comments="主键，PK")
	 public static final String COLUMN_ID = "id";
	/**
	 * This constant corresponds to db column <tt>user_id</tt>.<br>
     */
	 @DBColumn(name="user_id",dataType="varchar(32)",dataDefault="",dataLength=32,dataPrecision=0,dataScale=0,nullable=false,comments="会员Id")
	 public static final String COLUMN_USER_ID = "user_id";
	/**
	 * This constant corresponds to db column <tt>login_key</tt>.<br>
     */
	 @DBColumn(name="login_key",dataType="text",dataDefault="",dataLength=65535,dataPrecision=0,dataScale=0,nullable=false,comments="登录key")
	 public static final String COLUMN_LOGIN_KEY = "login_key";
	/**
	 * This constant corresponds to db column <tt>sign_key</tt>.<br>
     */
	 @DBColumn(name="sign_key",dataType="text",dataDefault="",dataLength=65535,dataPrecision=0,dataScale=0,nullable=true,comments="签名key")
	 public static final String COLUMN_SIGN_KEY = "sign_key";
	/**
	 * This constant corresponds to db column <tt>login_platform_type</tt>.<br>
     */
	 @DBColumn(name="login_platform_type",dataType="varchar(32)",dataDefault="",dataLength=32,dataPrecision=0,dataScale=0,nullable=false,comments="登录平台类型")
	 public static final String COLUMN_LOGIN_PLATFORM_TYPE = "login_platform_type";
	/**
	 * This constant corresponds to db column <tt>gmt_login</tt>.<br>
     */
	 @DBColumn(name="gmt_login",dataType="datetime",dataDefault="",dataLength=0,dataPrecision=0,dataScale=0,nullable=false,comments="登录时间")
	 public static final String COLUMN_GMT_LOGIN = "gmt_login";
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
	 * This constant corresponds to db column <tt>logined</tt>.<br>
     */
	 @DBColumn(name="logined",dataType="decimal(1,0)",dataDefault="",dataLength=1,dataPrecision=1,dataScale=0,nullable=false,comments="是否已登录")
	 public static final String COLUMN_LOGINED = "logined";
	/**
	 * This constant corresponds to db column <tt>gmt_logout</tt>.<br>
     */
	 @DBColumn(name="gmt_logout",dataType="datetime",dataDefault="",dataLength=0,dataPrecision=0,dataScale=0,nullable=true,comments="退出登录时间")
	 public static final String COLUMN_GMT_LOGOUT = "gmt_logout";
	/**
	 * This constant corresponds to db column <tt>notice_key</tt>.<br>
     */
	 @DBColumn(name="notice_key",dataType="text",dataDefault="",dataLength=65535,dataPrecision=0,dataScale=0,nullable=true,comments="通知Key")
	 public static final String COLUMN_NOTICE_KEY = "notice_key";
	/**
	 * This constant corresponds to db column <tt>notice_enabled</tt>.<br>
     */
	 @DBColumn(name="notice_enabled",dataType="decimal(1,0)",dataDefault="",dataLength=1,dataPrecision=1,dataScale=0,nullable=true,comments="是否通知")
	 public static final String COLUMN_NOTICE_ENABLED = "notice_enabled";
	/**
	 * This constant corresponds to db column <tt>gmt_notice_key_update</tt>.<br>
     */
	 @DBColumn(name="gmt_notice_key_update",dataType="datetime",dataDefault="",dataLength=0,dataPrecision=0,dataScale=0,nullable=true,comments="通知key更新时间")
	 public static final String COLUMN_GMT_NOTICE_KEY_UPDATE = "gmt_notice_key_update";
}
