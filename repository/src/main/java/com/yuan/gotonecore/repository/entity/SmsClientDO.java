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
 * A data object class directly models database table <tt>gtc_sms_client</tt>.<br>
 * 短信发送客户端
 * 
 *
 * This file is generated by <tt>bench-gen-dal</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>bench</tt> project.
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/biz/dal/src/conf/dalgen</tt>, and 
 * find the corresponding configuration file (<tt>tables/gtc_sms_client.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>bench-gen-dal</tt> 
 * to generate this file.
 *
 * @author nowli
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="SmsClientDO对象", description="短信发送客户端")
@TableName("gtc_sms_client")
public class SmsClientDO implements Serializable  {
    private static final long serialVersionUID = 741231858441822688L;

	public static final String TABLE_NAME = "GTC_SMS_CLIENT";
	//===========column onstants=====
	/**
	 * This constant corresponds to db column <tt>id</tt>.<br>
     */
	 public static final String COLUMN_ID = "id";
	/**
	 * This constant corresponds to db column <tt>client_no</tt>.<br>
     */
	 public static final String COLUMN_CLIENT_NO = "client_no";
	/**
	 * This constant corresponds to db column <tt>login_password</tt>.<br>
     */
	 public static final String COLUMN_LOGIN_PASSWORD = "login_password";
	/**
	 * This constant corresponds to db column <tt>gmt_create</tt>.<br>
     */
	 public static final String COLUMN_GMT_CREATE = "gmt_create";
	/**
	 * This constant corresponds to db column <tt>gmt_modified</tt>.<br>
     */
	 public static final String COLUMN_GMT_MODIFIED = "gmt_modified";
	/**
	 * This constant corresponds to db column <tt>enabled</tt>.<br>
     */
	 public static final String COLUMN_ENABLED = "enabled";
	/**
	 * This constant corresponds to db column <tt>sign_key</tt>.<br>
     */
	 public static final String COLUMN_SIGN_KEY = "sign_key";
	/**
	 * This constant corresponds to db column <tt>apply_each_count</tt>.<br>
     */
	 public static final String COLUMN_APPLY_EACH_COUNT = "apply_each_count";
	/**
	 * This constant corresponds to db column <tt>apply_max_pool_size</tt>.<br>
     */
	 public static final String COLUMN_APPLY_MAX_POOL_SIZE = "apply_max_pool_size";
	/**
	 * This constant corresponds to db column <tt>sign_type</tt>.<br>
     */
	 public static final String COLUMN_SIGN_TYPE = "sign_type";
	
	//========== properties ==========

	/**
	 * This property corresponds to db column <tt>id</tt>.<br>
     * 主键，PK
     */
	 @TableId(type = IdType.NONE)
	private long id;
	
	/**
	 * This property corresponds to db column <tt>client_no</tt>.<br>
     * 客户端号
     */
	private String clientNo;
	
	/**
	 * This property corresponds to db column <tt>login_password</tt>.<br>
     * 登录密码
     */
	private String loginPassword;
	
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
	 * This property corresponds to db column <tt>enabled</tt>.<br>
     * 是否有效
     */
	private boolean enabled;
	
	/**
	 * This property corresponds to db column <tt>sign_key</tt>.<br>
     * 签名key
     */
	private String signKey;
	
	/**
	 * This property corresponds to db column <tt>apply_each_count</tt>.<br>
     * 每次申请的短信数
     */
	private int applyEachCount;
	
	/**
	 * This property corresponds to db column <tt>apply_max_pool_size</tt>.<br>
     * 申请的池最大容量
     */
	private long applyMaxPoolSize;
	
	/**
	 * This property corresponds to db column <tt>sign_type</tt>.<br>
     * 签名类型
     */
	private String signType;
	

    //========== getters and setters ==========

}
