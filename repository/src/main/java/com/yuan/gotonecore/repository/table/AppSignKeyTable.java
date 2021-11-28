/*
 * Bench Inc.
 * Copyright (c) 2004 All Rights Reserved.
 */
package com.yuan.gotonecore.repository.table;

import com.bench.common.annotation.DBTable;
import com.bench.common.annotation.DBColumn;

/**
 * A table description for database table <tt>GTC_APP_SIGN_KEY</tt>.<br> 
 * GOTONECORE应用签名key
 * 
 *
 * This file is generated by <tt>bench-gen-dal</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>bench</tt> project.
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/biz/dal/src/conf/dalgen</tt>, and 
 * find the corresponding configuration file (<tt>tables/gtc_app_sign_key.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>bench-gen-dal</tt> 
 * to generate this file.
 *
 * @author nowli
 */
@DBTable(name="gtc_app_sign_key",comments="GOTONECORE应用签名key")
public class AppSignKeyTable {

	public static final String TABLE_NAME = "gtc_app_sign_key";
	//===========column onstants=====
	/**
	 * This constant corresponds to db column <tt>id</tt>.<br>
     */
	 @DBColumn(name="id",dataType="decimal(15,0)",dataDefault="",dataLength=15,dataPrecision=15,dataScale=0,nullable=false,comments="主键，PK")
	 public static final String COLUMN_ID = "id";
	/**
	 * This constant corresponds to db column <tt>app_id</tt>.<br>
     */
	 @DBColumn(name="app_id",dataType="decimal(15,0)",dataDefault="",dataLength=15,dataPrecision=15,dataScale=0,nullable=false,comments="应用ID")
	 public static final String COLUMN_APP_ID = "app_id";
	/**
	 * This constant corresponds to db column <tt>key_type</tt>.<br>
     */
	 @DBColumn(name="key_type",dataType="varchar(32)",dataDefault="",dataLength=32,dataPrecision=0,dataScale=0,nullable=false,comments="密钥类型")
	 public static final String COLUMN_KEY_TYPE = "key_type";
	/**
	 * This constant corresponds to db column <tt>key_value</tt>.<br>
     */
	 @DBColumn(name="key_value",dataType="text",dataDefault="",dataLength=65535,dataPrecision=0,dataScale=0,nullable=false,comments="密钥值")
	 public static final String COLUMN_KEY_VALUE = "key_value";
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
	 * This constant corresponds to db column <tt>enabled</tt>.<br>
     */
	 @DBColumn(name="enabled",dataType="decimal(1,0)",dataDefault="",dataLength=1,dataPrecision=1,dataScale=0,nullable=false,comments="是否有效")
	 public static final String COLUMN_ENABLED = "enabled";
}
