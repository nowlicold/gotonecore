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
 * A data object class directly models database table <tt>gtc_mobile_client_push_msg_his</tt>.<br>
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
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="MobileClientPushMsgHisDO对象", description="移动app推送的消息历史")
@TableName("gtc_mobile_client_push_msg_his")
public class MobileClientPushMsgHisDO implements Serializable  {
    private static final long serialVersionUID = 741231858441822688L;

	public static final String TABLE_NAME = "GTC_MOBILE_CLIENT_PUSH_MSG_HIS";
	//===========column onstants=====
	/**
	 * This constant corresponds to db column <tt>id</tt>.<br>
     */
	 public static final String COLUMN_ID = "id";
	/**
	 * This constant corresponds to db column <tt>user_id</tt>.<br>
     */
	 public static final String COLUMN_USER_ID = "user_id";
	/**
	 * This constant corresponds to db column <tt>content</tt>.<br>
     */
	 public static final String COLUMN_CONTENT = "content";
	/**
	 * This constant corresponds to db column <tt>gmt_create</tt>.<br>
     */
	 public static final String COLUMN_GMT_CREATE = "gmt_create";
	/**
	 * This constant corresponds to db column <tt>gmt_modified</tt>.<br>
     */
	 public static final String COLUMN_GMT_MODIFIED = "gmt_modified";
	/**
	 * This constant corresponds to db column <tt>gmt_next_push</tt>.<br>
     */
	 public static final String COLUMN_GMT_NEXT_PUSH = "gmt_next_push";
	/**
	 * This constant corresponds to db column <tt>try_count</tt>.<br>
     */
	 public static final String COLUMN_TRY_COUNT = "try_count";
	/**
	 * This constant corresponds to db column <tt>push_result</tt>.<br>
     */
	 public static final String COLUMN_PUSH_RESULT = "push_result";
	/**
	 * This constant corresponds to db column <tt>status</tt>.<br>
     */
	 public static final String COLUMN_STATUS = "status";
	/**
	 * This constant corresponds to db column <tt>source_message_id</tt>.<br>
     */
	 public static final String COLUMN_SOURCE_MESSAGE_ID = "source_message_id";
	/**
	 * This constant corresponds to db column <tt>source_app_name</tt>.<br>
     */
	 public static final String COLUMN_SOURCE_APP_NAME = "source_app_name";
	/**
	 * This constant corresponds to db column <tt>gmt_his_create</tt>.<br>
     */
	 public static final String COLUMN_GMT_HIS_CREATE = "gmt_his_create";
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
	 * This property corresponds to db column <tt>user_id</tt>.<br>
     * 会员ID
     */
	private String userId;
	
	/**
	 * This property corresponds to db column <tt>content</tt>.<br>
     * 推送内容
     */
	private String content;
	
	/**
	 * This property corresponds to db column <tt>gmt_create</tt>.<br>
     * 创建时间
     */
	private Date gmtCreate;
	
	/**
	 * This property corresponds to db column <tt>gmt_modified</tt>.<br>
     * 修改时间
     */
	private Date gmtModified;
	
	/**
	 * This property corresponds to db column <tt>gmt_next_push</tt>.<br>
     * 下次推送时间
     */
	private Date gmtNextPush;
	
	/**
	 * This property corresponds to db column <tt>try_count</tt>.<br>
     * 尝试次数
     */
	private long tryCount;
	
	/**
	 * This property corresponds to db column <tt>push_result</tt>.<br>
     * 推送结果
     */
	private String pushResult;
	
	/**
	 * This property corresponds to db column <tt>status</tt>.<br>
     * 状态
     */
	private String status;
	
	/**
	 * This property corresponds to db column <tt>source_message_id</tt>.<br>
     * 源消息ID
     */
	private String sourceMessageId;
	
	/**
	 * This property corresponds to db column <tt>source_app_name</tt>.<br>
     * 源系统代码
     */
	private String sourceAppName;
	
	/**
	 * This property corresponds to db column <tt>gmt_his_create</tt>.<br>
     * 历史创建时间
     */
	private Date gmtHisCreate;
	
	/**
	 * This property corresponds to db column <tt>properties</tt>.<br>
     * 消息类型
     */
	private String properties;
	

    //========== getters and setters ==========

}
