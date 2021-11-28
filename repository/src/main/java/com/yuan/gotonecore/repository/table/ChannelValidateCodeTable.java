/*
 * Bench Inc.
 * Copyright (c) 2004 All Rights Reserved.
 */
package com.yuan.gotonecore.repository.table;

import com.bench.common.annotation.DBTable;
import com.bench.common.annotation.DBColumn;

/**
 * A table description for database table <tt>GTC_CHANNEL_VALIDATE_CODE</tt>.<br> 
 * 
 * 
 *
 * This file is generated by <tt>bench-gen-dal</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>bench</tt> project.
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/biz/dal/src/conf/dalgen</tt>, and 
 * find the corresponding configuration file (<tt>tables/gtc_channel_validate_code.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>bench-gen-dal</tt> 
 * to generate this file.
 *
 * @author nowli
 */
@DBTable(name="gtc_channel_validate_code",comments="")
public class ChannelValidateCodeTable {

	public static final String TABLE_NAME = "gtc_channel_validate_code";
	//===========column onstants=====
	/**
	 * This constant corresponds to db column <tt>id</tt>.<br>
     */
	 @DBColumn(name="id",dataType="decimal(15,0)",dataDefault="",dataLength=15,dataPrecision=15,dataScale=0,nullable=false,comments="")
	 public static final String COLUMN_ID = "id";
	/**
	 * This constant corresponds to db column <tt>channel</tt>.<br>
     */
	 @DBColumn(name="channel",dataType="varchar(32)",dataDefault="",dataLength=32,dataPrecision=0,dataScale=0,nullable=false,comments="")
	 public static final String COLUMN_CHANNEL = "channel";
	/**
	 * This constant corresponds to db column <tt>channel_user_id</tt>.<br>
     */
	 @DBColumn(name="channel_user_id",dataType="varchar(64)",dataDefault="",dataLength=64,dataPrecision=0,dataScale=0,nullable=true,comments="")
	 public static final String COLUMN_CHANNEL_USER_ID = "channel_user_id";
	/**
	 * This constant corresponds to db column <tt>channel_user_name</tt>.<br>
     */
	 @DBColumn(name="channel_user_name",dataType="varchar(128)",dataDefault="",dataLength=128,dataPrecision=0,dataScale=0,nullable=true,comments="")
	 public static final String COLUMN_CHANNEL_USER_NAME = "channel_user_name";
	/**
	 * This constant corresponds to db column <tt>validate_code</tt>.<br>
     */
	 @DBColumn(name="validate_code",dataType="varchar(32)",dataDefault="",dataLength=32,dataPrecision=0,dataScale=0,nullable=false,comments="")
	 public static final String COLUMN_VALIDATE_CODE = "validate_code";
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
	 * This constant corresponds to db column <tt>validate_count</tt>.<br>
     */
	 @DBColumn(name="validate_count",dataType="decimal(8,0)",dataDefault="",dataLength=8,dataPrecision=8,dataScale=0,nullable=false,comments="")
	 public static final String COLUMN_VALIDATE_COUNT = "validate_count";
	/**
	 * This constant corresponds to db column <tt>gmt_current_validate</tt>.<br>
     */
	 @DBColumn(name="gmt_current_validate",dataType="datetime",dataDefault="",dataLength=0,dataPrecision=0,dataScale=0,nullable=true,comments="")
	 public static final String COLUMN_GMT_CURRENT_VALIDATE = "gmt_current_validate";
	/**
	 * This constant corresponds to db column <tt>gmt_last_validate</tt>.<br>
     */
	 @DBColumn(name="gmt_last_validate",dataType="datetime",dataDefault="",dataLength=0,dataPrecision=0,dataScale=0,nullable=true,comments="")
	 public static final String COLUMN_GMT_LAST_VALIDATE = "gmt_last_validate";
	/**
	 * This constant corresponds to db column <tt>success_validated</tt>.<br>
     */
	 @DBColumn(name="success_validated",dataType="decimal(1,0)",dataDefault="",dataLength=1,dataPrecision=1,dataScale=0,nullable=true,comments="")
	 public static final String COLUMN_SUCCESS_VALIDATED = "success_validated";
	/**
	 * This constant corresponds to db column <tt>gmt_validate_create</tt>.<br>
     */
	 @DBColumn(name="gmt_validate_create",dataType="datetime",dataDefault="",dataLength=0,dataPrecision=0,dataScale=0,nullable=true,comments="")
	 public static final String COLUMN_GMT_VALIDATE_CREATE = "gmt_validate_create";
	/**
	 * This constant corresponds to db column <tt>gmt_validate_success</tt>.<br>
     */
	 @DBColumn(name="gmt_validate_success",dataType="datetime",dataDefault="",dataLength=0,dataPrecision=0,dataScale=0,nullable=true,comments="")
	 public static final String COLUMN_GMT_VALIDATE_SUCCESS = "gmt_validate_success";
}