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
 * A data object class directly models database table <tt>gtc_black_list</tt>.<br>
 * 
 * 
 *
 * This file is generated by <tt>bench-gen-dal</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>bench</tt> project.
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/biz/dal/src/conf/dalgen</tt>, and 
 * find the corresponding configuration file (<tt>tables/gtc_black_list.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>bench-gen-dal</tt> 
 * to generate this file.
 *
 * @author nowli
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="BlackListDO对象", description="")
@TableName("gtc_black_list")
public class BlackListDO implements Serializable  {
    private static final long serialVersionUID = 741231858441822688L;

	public static final String TABLE_NAME = "GTC_BLACK_LIST";
	//===========column onstants=====
	/**
	 * This constant corresponds to db column <tt>id</tt>.<br>
     */
	 public static final String COLUMN_ID = "id";
	/**
	 * This constant corresponds to db column <tt>message_type</tt>.<br>
     */
	 public static final String COLUMN_MESSAGE_TYPE = "message_type";
	/**
	 * This constant corresponds to db column <tt>receiver</tt>.<br>
     */
	 public static final String COLUMN_RECEIVER = "receiver";
	/**
	 * This constant corresponds to db column <tt>business_type</tt>.<br>
     */
	 public static final String COLUMN_BUSINESS_TYPE = "business_type";
	/**
	 * This constant corresponds to db column <tt>remark</tt>.<br>
     */
	 public static final String COLUMN_REMARK = "remark";
	/**
	 * This constant corresponds to db column <tt>gmt_create</tt>.<br>
     */
	 public static final String COLUMN_GMT_CREATE = "gmt_create";
	/**
	 * This constant corresponds to db column <tt>gmt_modified</tt>.<br>
     */
	 public static final String COLUMN_GMT_MODIFIED = "gmt_modified";
	
	//========== properties ==========

	/**
	 * This property corresponds to db column <tt>id</tt>.<br>
     * 
     */
	 @TableId(type = IdType.NONE)
	private long id;
	
	/**
	 * This property corresponds to db column <tt>message_type</tt>.<br>
     * 
     */
	private String messageType;
	
	/**
	 * This property corresponds to db column <tt>receiver</tt>.<br>
     * 
     */
	private String receiver;
	
	/**
	 * This property corresponds to db column <tt>business_type</tt>.<br>
     * 
     */
	private String businessType;
	
	/**
	 * This property corresponds to db column <tt>remark</tt>.<br>
     * 
     */
	private String remark;
	
	/**
	 * This property corresponds to db column <tt>gmt_create</tt>.<br>
     * 
     */
	private Date gmtCreate;
	
	/**
	 * This property corresponds to db column <tt>gmt_modified</tt>.<br>
     * 
     */
	private Date gmtModified;
	

    //========== getters and setters ==========

}
