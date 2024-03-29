/*
 * Bench Inc.
 * Copyright (c) 2004 All Rights Reserved.
 */
package com.yuan.gotonecore.repository.table;

import com.bench.common.annotation.DBTable;
import com.bench.common.annotation.DBColumn;

/**
 * A table description for database table <tt>GTC_ACTIVITY</tt>.<br> 
 * 沟通活动
 * 
 *
 * This file is generated by <tt>bench-gen-dal</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>bench</tt> project.
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/biz/dal/src/conf/dalgen</tt>, and 
 * find the corresponding configuration file (<tt>tables/gtc_activity.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>bench-gen-dal</tt> 
 * to generate this file.
 *
 * @author nowli
 */
@DBTable(name="gtc_activity",comments="沟通活动")
public class ActivityTable {

	public static final String TABLE_NAME = "gtc_activity";
	//===========column onstants=====
	/**
	 * This constant corresponds to db column <tt>id</tt>.<br>
     */
	 @DBColumn(name="id",dataType="decimal(15,0)",dataDefault="",dataLength=15,dataPrecision=15,dataScale=0,nullable=false,comments="主键")
	 public static final String COLUMN_ID = "id";
	/**
	 * This constant corresponds to db column <tt>activity_name</tt>.<br>
     */
	 @DBColumn(name="activity_name",dataType="varchar(128)",dataDefault="",dataLength=128,dataPrecision=0,dataScale=0,nullable=false,comments="活动名称")
	 public static final String COLUMN_ACTIVITY_NAME = "activity_name";
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
	 * This constant corresponds to db column <tt>memo</tt>.<br>
     */
	 @DBColumn(name="memo",dataType="text",dataDefault="",dataLength=65535,dataPrecision=0,dataScale=0,nullable=false,comments="备注")
	 public static final String COLUMN_MEMO = "memo";
	/**
	 * This constant corresponds to db column <tt>activity_status</tt>.<br>
     */
	 @DBColumn(name="activity_status",dataType="varchar(32)",dataDefault="",dataLength=32,dataPrecision=0,dataScale=0,nullable=false,comments="活动状态")
	 public static final String COLUMN_ACTIVITY_STATUS = "activity_status";
	/**
	 * This constant corresponds to db column <tt>activity_code</tt>.<br>
     */
	 @DBColumn(name="activity_code",dataType="varchar(128)",dataDefault="",dataLength=128,dataPrecision=0,dataScale=0,nullable=false,comments="活动码")
	 public static final String COLUMN_ACTIVITY_CODE = "activity_code";
}
