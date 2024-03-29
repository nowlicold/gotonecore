/*
 * Bench Inc.
 * Copyright (c) 2004 All Rights Reserved.
 */
package com.yuan.gotonecore.repository.table;

import com.bench.common.annotation.DBTable;
import com.bench.common.annotation.DBColumn;

/**
 * A table description for database table <tt>GTC_SMS_BLACK_LIST</tt>.<br> 
 * 
 * 
 *
 * This file is generated by <tt>bench-gen-dal</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>bench</tt> project.
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/biz/dal/src/conf/dalgen</tt>, and 
 * find the corresponding configuration file (<tt>tables/gtc_sms_black_list.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>bench-gen-dal</tt> 
 * to generate this file.
 *
 * @author nowli
 */
@DBTable(name="gtc_sms_black_list",comments="")
public class SmsBlackListTable {

	public static final String TABLE_NAME = "gtc_sms_black_list";
	//===========column onstants=====
	/**
	 * This constant corresponds to db column <tt>id</tt>.<br>
     */
	 @DBColumn(name="id",dataType="varchar(32)",dataDefault="",dataLength=32,dataPrecision=0,dataScale=0,nullable=false,comments="")
	 public static final String COLUMN_ID = "id";
	/**
	 * This constant corresponds to db column <tt>intercept_object_type</tt>.<br>
     */
	 @DBColumn(name="intercept_object_type",dataType="varchar(64)",dataDefault="",dataLength=64,dataPrecision=0,dataScale=0,nullable=false,comments="")
	 public static final String COLUMN_INTERCEPT_OBJECT_TYPE = "intercept_object_type";
	/**
	 * This constant corresponds to db column <tt>intercept_object_value</tt>.<br>
     */
	 @DBColumn(name="intercept_object_value",dataType="varchar(64)",dataDefault="",dataLength=64,dataPrecision=0,dataScale=0,nullable=false,comments="")
	 public static final String COLUMN_INTERCEPT_OBJECT_VALUE = "intercept_object_value";
	/**
	 * This constant corresponds to db column <tt>memo</tt>.<br>
     */
	 @DBColumn(name="memo",dataType="varchar(64)",dataDefault="",dataLength=64,dataPrecision=0,dataScale=0,nullable=true,comments="")
	 public static final String COLUMN_MEMO = "memo";
	/**
	 * This constant corresponds to db column <tt>gmt_remove</tt>.<br>
     */
	 @DBColumn(name="gmt_remove",dataType="datetime",dataDefault="",dataLength=0,dataPrecision=0,dataScale=0,nullable=false,comments="")
	 public static final String COLUMN_GMT_REMOVE = "gmt_remove";
	/**
	 * This constant corresponds to db column <tt>gmt_create</tt>.<br>
     */
	 @DBColumn(name="gmt_create",dataType="datetime",dataDefault="",dataLength=0,dataPrecision=0,dataScale=0,nullable=false,comments="")
	 public static final String COLUMN_GMT_CREATE = "gmt_create";
	/**
	 * This constant corresponds to db column <tt>gmt_modified</tt>.<br>
     */
	 @DBColumn(name="gmt_modified",dataType="datetime",dataDefault="",dataLength=0,dataPrecision=0,dataScale=0,nullable=false,comments="")
	 public static final String COLUMN_GMT_MODIFIED = "gmt_modified";
	/**
	 * This constant corresponds to db column <tt>enabled</tt>.<br>
     */
	 @DBColumn(name="enabled",dataType="decimal(1,0)",dataDefault="",dataLength=1,dataPrecision=1,dataScale=0,nullable=false,comments="")
	 public static final String COLUMN_ENABLED = "enabled";
}
