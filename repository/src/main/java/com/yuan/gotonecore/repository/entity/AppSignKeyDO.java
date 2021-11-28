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
 * A data object class directly models database table <tt>gtc_app_sign_key</tt>.<br>
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
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="AppSignKeyDO对象", description="GOTONECORE应用签名key")
@TableName("gtc_app_sign_key")
public class AppSignKeyDO implements Serializable  {
    private static final long serialVersionUID = 741231858441822688L;

	public static final String TABLE_NAME = "GTC_APP_SIGN_KEY";
	//===========column onstants=====
	/**
	 * This constant corresponds to db column <tt>id</tt>.<br>
     */
	 public static final String COLUMN_ID = "id";
	/**
	 * This constant corresponds to db column <tt>app_id</tt>.<br>
     */
	 public static final String COLUMN_APP_ID = "app_id";
	/**
	 * This constant corresponds to db column <tt>key_type</tt>.<br>
     */
	 public static final String COLUMN_KEY_TYPE = "key_type";
	/**
	 * This constant corresponds to db column <tt>key_value</tt>.<br>
     */
	 public static final String COLUMN_KEY_VALUE = "key_value";
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
	
	//========== properties ==========

	/**
	 * This property corresponds to db column <tt>id</tt>.<br>
     * 主键，PK
     */
	 @TableId(type = IdType.NONE)
	private long id;
	
	/**
	 * This property corresponds to db column <tt>app_id</tt>.<br>
     * 应用ID
     */
	private long appId;
	
	/**
	 * This property corresponds to db column <tt>key_type</tt>.<br>
     * 密钥类型
     */
	private String keyType;
	
	/**
	 * This property corresponds to db column <tt>key_value</tt>.<br>
     * 密钥值
     */
	private String keyValue;
	
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
	

    //========== getters and setters ==========

}