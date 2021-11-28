/*
 * Bench Inc.
 * Copyright (c) 2004 All Rights Reserved.
 */
package com.yuan.gotonecore.repository.mapper;



// auto generated imports
//dao imports
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import com.yuan.gotonecore.repository.entity.MailUserConfigDO;
import org.springframework.dao.DataAccessException;
import java.util.Date;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
//do imports

/**
 * A dao interface provides methods to access database table <tt>gtc_mail_user_config</tt>.
 *
 * This file is generated by <tt>bench-gen-dal</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>bench</tt> project.
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/biz/dal/src/conf/dalgen</tt>, and 
 * find the corresponding configuration file (<tt>tables/gtc_mail_user_config.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>bench-gen-dal</tt> 
 * to generate this file.
 *
 * @author nowli
 */
public interface MailUserConfigMapper  extends BaseMapper<MailUserConfigDO>{
	/**
	 *  Update DB table <tt>gtc_mail_user_config</tt>.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>update gtc_mail_user_config set password=?, from_addr=?, mail_server_id=?, from_name=?, user_type=?, status=?, serverside_enabled=?, serverside_disabled_reason=?, gmt_modified=now() where (id = ?)</tt>
	 *
	 *	@param password 
	 *	@param fromAddr 
	 *	@param mailServerId 
	 *	@param fromName 
	 *	@param userType 
	 *	@param status 
	 *	@param serversideEnabled 
	 *	@param serversideDisabledReason 
	 *	@param id 
	 *	@return int
	 *	@throws DataAccessException
	 */	 

		public int modify(@Param("password")String password , @Param("fromAddr")String fromAddr , @Param("mailServerId")long mailServerId , @Param("fromName")String fromName , @Param("userType")String userType , @Param("status")String status , @Param("serversideEnabled")boolean serversideEnabled , @Param("serversideDisabledReason")String serversideDisabledReason , @Param("id")long id) throws DataAccessException;

	/**
	 *  Update DB table <tt>gtc_mail_user_config</tt>.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>update gtc_mail_user_config set status=?, gmt_modified=now() where (id = ?)</tt>
	 *
	 *	@param status 
	 *	@param id 
	 *	@return int
	 *	@throws DataAccessException
	 */	 

		public int modifyStatus(@Param("status")String status , @Param("id")long id) throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>gtc_mail_user_config</tt>.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from gtc_mail_user_config where (id = ?)</tt>
	 *
	 *	@param id 
	 *	@return int
	 *	@throws DataAccessException
	 */	 

		public int delete(@Param("id")long id) throws DataAccessException;

	/**
	 *  Query DB table <tt>gtc_mail_user_config</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select COUNT(*) from gtc_mail_user_config where ((mail_server_id = ?) AND (from_addr = ?) AND (status = 'ENABLED'))</tt>
	 *
	 *	@param mailServerId 
	 *	@param fromAddr 
	 *	@return long
	 *	@throws DataAccessException
	 */	 

		public long selectCountByFromAddAndMailServerId(@Param("mailServerId")long mailServerId , @Param("fromAddr")String fromAddr) throws DataAccessException;

	/**
	 *  Query DB table <tt>gtc_mail_user_config</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, password, from_addr, mail_server_id, from_name, user_type, status, serverside_enabled, serverside_disabled_reason, gmt_modified, from_userword, gmt_create from gtc_mail_user_config</tt>
	 *
	 *	@return List<MailUserConfigDO>
	 *	@throws DataAccessException
	 */	 

		public List<MailUserConfigDO> selectAll() throws DataAccessException;

	/**
	 *  Query DB table <tt>gtc_mail_user_config</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, password, from_addr, mail_server_id, from_name, user_type, status, serverside_enabled, serverside_disabled_reason, gmt_modified, from_userword, gmt_create from gtc_mail_user_config where (id = ?)</tt>
	 *
	 *	@param id 
	 *	@return MailUserConfigDO
	 *	@throws DataAccessException
	 */	 

		public MailUserConfigDO selectById(@Param("id")long id) throws DataAccessException;

	/**
	 *  Query DB table <tt>gtc_mail_user_config</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select max(GMT_MODIFIED) from gtc_mail_user_config</tt>
	 *
	 *	@return Date
	 *	@throws DataAccessException
	 */	 

		public Date selectMaxGmtModified() throws DataAccessException;

	/**
	 *  Query DB table <tt>gtc_mail_user_config</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select COUNT(*) from gtc_mail_user_config</tt>
	 *
	 *	@return long
	 *	@throws DataAccessException
	 */	 

		public long selectCount() throws DataAccessException;

	/**
	 *  Query DB table <tt>gtc_mail_user_config</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, password, from_addr, mail_server_id, from_name, user_type, status, serverside_enabled, serverside_disabled_reason, gmt_modified, gmt_create from gtc_mail_user_config</tt>
	 *
	 *	@param id 
	 *	@param fromAddr 
	 *	@param password 
	 *	@param mailServerId 
	 *	@param fromName 
	 *	@param status 
	 *	@param userType 
	 *	@param serversideEnabled 
	 *	@param beginModifiedDate 
	 *	@param endModifiedDate 
	 *	@param page 
	 *	@return List<MailUserConfigDO>
	 *	@throws DataAccessException
	 */	 

		public List<MailUserConfigDO> search(@Param("id")long id , @Param("fromAddr")String fromAddr , @Param("password")String password , @Param("mailServerId")long mailServerId , @Param("fromName")String fromName , @Param("status")String status , @Param("userType")String userType , @Param("serversideEnabled")Boolean serversideEnabled , @Param("beginModifiedDate")String beginModifiedDate , @Param("endModifiedDate")String endModifiedDate , @Param("page")Page<MailUserConfigDO> page) throws DataAccessException;

	/**
	 *  Query DB table <tt>gtc_mail_user_config</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, password, from_addr, mail_server_id, from_name, user_type, status, serverside_enabled, serverside_disabled_reason, gmt_modified, gmt_create from gtc_mail_user_config where (1 = 0)</tt>
	 *
	 *	@param activityId 
	 *	@param serverDomainName 
	 *	@return MailUserConfigDO
	 *	@throws DataAccessException
	 */	 

		public MailUserConfigDO selectRandomByActivityIdAndDomainName(@Param("activityId")long activityId , @Param("serverDomainName")String serverDomainName) throws DataAccessException;

	/**
	 *  Query DB table <tt>gtc_mail_user_config</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, password, from_addr, mail_server_id, from_name, user_type, status, serverside_enabled, serverside_disabled_reason, gmt_modified, gmt_create, from_userword from gtc_mail_user_config where (1 = 0)</tt>
	 *
	 *	@param activityId 
	 *	@return MailUserConfigDO
	 *	@throws DataAccessException
	 */	 

		public MailUserConfigDO selectRandomByActivityId(@Param("activityId")long activityId) throws DataAccessException;

}