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
 * A data object class directly models database table <tt>gtc_sms_client_send_history</tt>.<br>
 * 短信客户端发送历史
 * 
 *
 * This file is generated by <tt>bench-gen-dal</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>bench</tt> project.
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/biz/dal/src/conf/dalgen</tt>, and 
 * find the corresponding configuration file (<tt>tables/gtc_sms_client_send_history.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>bench-gen-dal</tt> 
 * to generate this file.
 *
 * @author nowli
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="SmsClientSendHistoryDO对象", description="短信客户端发送历史")
@TableName("gtc_sms_client_send_history")
public class SmsClientSendHistoryDO implements Serializable  {
    private static final long serialVersionUID = 741231858441822688L;

	public static final String TABLE_NAME = "GTC_SMS_CLIENT_SEND_HISTORY";
	//===========column onstants=====
	/**
	 * This constant corresponds to db column <tt>id</tt>.<br>
     */
	 public static final String COLUMN_ID = "id";
	/**
	 * This constant corresponds to db column <tt>sms_id</tt>.<br>
     */
	 public static final String COLUMN_SMS_ID = "sms_id";
	/**
	 * This constant corresponds to db column <tt>status</tt>.<br>
     */
	 public static final String COLUMN_STATUS = "status";
	/**
	 * This constant corresponds to db column <tt>gmt_create</tt>.<br>
     */
	 public static final String COLUMN_GMT_CREATE = "gmt_create";
	/**
	 * This constant corresponds to db column <tt>gmt_modified</tt>.<br>
     */
	 public static final String COLUMN_GMT_MODIFIED = "gmt_modified";
	/**
	 * This constant corresponds to db column <tt>gmt_client_apply</tt>.<br>
     */
	 public static final String COLUMN_GMT_CLIENT_APPLY = "gmt_client_apply";
	/**
	 * This constant corresponds to db column <tt>client_no</tt>.<br>
     */
	 public static final String COLUMN_CLIENT_NO = "client_no";
	/**
	 * This constant corresponds to db column <tt>gmt_his_create</tt>.<br>
     */
	 public static final String COLUMN_GMT_HIS_CREATE = "gmt_his_create";
	/**
	 * This constant corresponds to db column <tt>client_apply_count</tt>.<br>
     */
	 public static final String COLUMN_CLIENT_APPLY_COUNT = "client_apply_count";
	/**
	 * This constant corresponds to db column <tt>gmt_client_send_finish</tt>.<br>
     */
	 public static final String COLUMN_GMT_CLIENT_SEND_FINISH = "gmt_client_send_finish";
	/**
	 * This constant corresponds to db column <tt>gmt_client_resend</tt>.<br>
     */
	 public static final String COLUMN_GMT_CLIENT_RESEND = "gmt_client_resend";
	/**
	 * This constant corresponds to db column <tt>client_send_result</tt>.<br>
     */
	 public static final String COLUMN_CLIENT_SEND_RESULT = "client_send_result";
	
	//========== properties ==========

	/**
	 * This property corresponds to db column <tt>id</tt>.<br>
     * 主键，PK
     */
	 @TableId(type = IdType.NONE)
	private long id;
	
	/**
	 * This property corresponds to db column <tt>sms_id</tt>.<br>
     * 短信ID
     */
	private long smsId;
	
	/**
	 * This property corresponds to db column <tt>status</tt>.<br>
     * 状态
     */
	private String status;
	
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
	 * This property corresponds to db column <tt>gmt_client_apply</tt>.<br>
     * 客户端申请时间
     */
	private Date gmtClientApply;
	
	/**
	 * This property corresponds to db column <tt>client_no</tt>.<br>
     * 客户端号
     */
	private String clientNo;
	
	/**
	 * This property corresponds to db column <tt>gmt_his_create</tt>.<br>
     * 历史记录创建时间
     */
	private Date gmtHisCreate;
	
	/**
	 * This property corresponds to db column <tt>client_apply_count</tt>.<br>
     * 客户端申请次数
     */
	private long clientApplyCount;
	
	/**
	 * This property corresponds to db column <tt>gmt_client_send_finish</tt>.<br>
     * 客户端发送时间
     */
	private Date gmtClientSendFinish;
	
	/**
	 * This property corresponds to db column <tt>gmt_client_resend</tt>.<br>
     * 下次发送时间
     */
	private Date gmtClientResend;
	
	/**
	 * This property corresponds to db column <tt>client_send_result</tt>.<br>
     * 客户端发送结果
     */
	private String clientSendResult;
	

    //========== getters and setters ==========

}
