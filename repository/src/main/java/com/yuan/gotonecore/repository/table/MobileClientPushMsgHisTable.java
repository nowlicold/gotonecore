/*
 * Bench Inc.
 * Copyright (c) 2004 All Rights Reserved.
 */
package com.yuan.gotonecore.repository.table;

import com.bench.common.annotation.DBTable;
import com.bench.common.annotation.DBColumn;

/**
 * A table description for database table <tt>GTC_MOBILE_CLIENT_PUSH_MSG_HIS</tt>.<br> 
 * 移动app推送的消息历史
 * 
 *
 * This file is generated by <tt>bench-gen-dal</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>bench</tt> project.
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/biz/dal/src/conf/dalgen</tt>, and 
 * find the corresponding configuration file (<tt>tables/gtc_mobile_client_push_msg_his.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>bench-gen-dal</tt> 
 * to generate this file.
 *
 * @author nowli
 */
@DBTable(name="gtc_mobile_client_push_msg_his",comments="移动app推送的消息历史")
public class MobileClientPushMsgHisTable {

	public static final String TABLE_NAME = "gtc_mobile_client_push_msg_his";
	//===========column onstants=====
	/**
	 * This constant corresponds to db column <tt>id</tt>.<br>
     */
	 @DBColumn(name="id",dataType="decimal(15,0)",dataDefault="",dataLength=15,dataPrecision=15,dataScale=0,nullable=false,comments="主键，PK")
	 public static final String COLUMN_ID = "id";
	/**
	 * This constant corresponds to db column <tt>user_id</tt>.<br>
     */
	 @DBColumn(name="user_id",dataType="varchar(32)",dataDefault="",dataLength=32,dataPrecision=0,dataScale=0,nullable=false,comments="会员ID")
	 public static final String COLUMN_USER_ID = "user_id";
	/**
	 * This constant corresponds to db column <tt>content</tt>.<br>
     */
	 @DBColumn(name="content",dataType="text",dataDefault="",dataLength=65535,dataPrecision=0,dataScale=0,nullable=true,comments="推送内容")
	 public static final String COLUMN_CONTENT = "content";
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
	 * This constant corresponds to db column <tt>gmt_next_push</tt>.<br>
     */
	 @DBColumn(name="gmt_next_push",dataType="datetime",dataDefault="",dataLength=0,dataPrecision=0,dataScale=0,nullable=false,comments="下次推送时间")
	 public static final String COLUMN_GMT_NEXT_PUSH = "gmt_next_push";
	/**
	 * This constant corresponds to db column <tt>try_count</tt>.<br>
     */
	 @DBColumn(name="try_count",dataType="decimal(15,0)",dataDefault="",dataLength=15,dataPrecision=15,dataScale=0,nullable=false,comments="尝试次数")
	 public static final String COLUMN_TRY_COUNT = "try_count";
	/**
	 * This constant corresponds to db column <tt>push_result</tt>.<br>
     */
	 @DBColumn(name="push_result",dataType="text",dataDefault="",dataLength=65535,dataPrecision=0,dataScale=0,nullable=true,comments="推送结果")
	 public static final String COLUMN_PUSH_RESULT = "push_result";
	/**
	 * This constant corresponds to db column <tt>status</tt>.<br>
     */
	 @DBColumn(name="status",dataType="varchar(32)",dataDefault="",dataLength=32,dataPrecision=0,dataScale=0,nullable=false,comments="状态")
	 public static final String COLUMN_STATUS = "status";
	/**
	 * This constant corresponds to db column <tt>source_message_id</tt>.<br>
     */
	 @DBColumn(name="source_message_id",dataType="varchar(32)",dataDefault="",dataLength=32,dataPrecision=0,dataScale=0,nullable=true,comments="源消息ID")
	 public static final String COLUMN_SOURCE_MESSAGE_ID = "source_message_id";
	/**
	 * This constant corresponds to db column <tt>source_app_name</tt>.<br>
     */
	 @DBColumn(name="source_app_name",dataType="varchar(64)",dataDefault="",dataLength=64,dataPrecision=0,dataScale=0,nullable=true,comments="源系统代码")
	 public static final String COLUMN_SOURCE_APP_NAME = "source_app_name";
	/**
	 * This constant corresponds to db column <tt>gmt_his_create</tt>.<br>
     */
	 @DBColumn(name="gmt_his_create",dataType="datetime",dataDefault="",dataLength=0,dataPrecision=0,dataScale=0,nullable=true,comments="历史创建时间")
	 public static final String COLUMN_GMT_HIS_CREATE = "gmt_his_create";
	/**
	 * This constant corresponds to db column <tt>properties</tt>.<br>
     */
	 @DBColumn(name="properties",dataType="text",dataDefault="",dataLength=65535,dataPrecision=0,dataScale=0,nullable=true,comments="消息类型")
	 public static final String COLUMN_PROPERTIES = "properties";
}
