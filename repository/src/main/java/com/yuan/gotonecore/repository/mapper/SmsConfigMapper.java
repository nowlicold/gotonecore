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
import com.yuan.gotonecore.repository.entity.SmsConfigDO;
import org.springframework.dao.DataAccessException;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Date;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
//do imports

/**
 * A dao interface provides methods to access database table <tt>gtc_sms_config</tt>.
 *
 * This file is generated by <tt>bench-gen-dal</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>bench</tt> project.
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/biz/dal/src/conf/dalgen</tt>, and 
 * find the corresponding configuration file (<tt>tables/gtc_sms_config.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>bench-gen-dal</tt> 
 * to generate this file.
 *
 * @author nowli
 */
public interface SmsConfigMapper  extends BaseMapper<SmsConfigDO>{
	/**
	 *  Update DB table <tt>gtc_sms_config</tt>.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>update gtc_sms_config set config_name=?, gmt_modified=now(), content=?, send_channels=?, interval_seconds=?, ACK_CODE_TIMEOUT_SECONDS=?, ACK_CODE_MAX_VALIDATE=?, send_start_time=?, send_end_time=?, max_try_count=?, retry_interval_seconds=? where (id = ?)</tt>
	 *
	 *	@param configName 
	 *	@param content 
	 *	@param sendChannels 
	 *	@param intervalSeconds 
	 *	@param ackCodeTimeoutSeconds 
	 *	@param ackCodeMaxValidate 
	 *	@param sendStartTime 
	 *	@param sendEndTime 
	 *	@param maxTryCount 
	 *	@param retryIntervalSeconds 
	 *	@param id 
	 *	@return int
	 *	@throws DataAccessException
	 */	 

		public int modify(@Param("configName")String configName , @Param("content")String content , @Param("sendChannels")String sendChannels , @Param("intervalSeconds")long intervalSeconds , @Param("ackCodeTimeoutSeconds")long ackCodeTimeoutSeconds , @Param("ackCodeMaxValidate")int ackCodeMaxValidate , @Param("sendStartTime")String sendStartTime , @Param("sendEndTime")String sendEndTime , @Param("maxTryCount")int maxTryCount , @Param("retryIntervalSeconds")long retryIntervalSeconds , @Param("id")long id) throws DataAccessException;

	/**
	 *  Query DB table <tt>gtc_sms_config</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, config_name, gmt_modified, gmt_create, content, send_channels, interval_seconds, ACK_CODE_TIMEOUT_SECONDS, ACK_CODE_MAX_VALIDATE, send_start_time, send_end_time, max_try_count, retry_interval_seconds, sms_out_need_unique_id from gtc_sms_config where (id = ?)</tt>
	 *
	 *	@param id 
	 *	@return SmsConfigDO
	 *	@throws DataAccessException
	 */	 

		public SmsConfigDO selectById(@Param("id")long id) throws DataAccessException;

	/**
	 *  Query DB table <tt>gtc_sms_config</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, config_name, gmt_modified, gmt_create, content, send_channels, interval_seconds, ACK_CODE_TIMEOUT_SECONDS, ACK_CODE_MAX_VALIDATE, send_start_time, send_end_time, max_try_count, retry_interval_seconds, sms_out_need_unique_id from gtc_sms_config where (config_name = ?)</tt>
	 *
	 *	@param configName 
	 *	@return SmsConfigDO
	 *	@throws DataAccessException
	 */	 

		public SmsConfigDO selectByConfigName(@Param("configName")String configName) throws DataAccessException;

	/**
	 *  Query DB table <tt>gtc_sms_config</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, config_name, gmt_modified, gmt_create, content, send_channels, interval_seconds, ACK_CODE_TIMEOUT_SECONDS, ACK_CODE_MAX_VALIDATE, send_start_time, send_end_time, max_try_count, retry_interval_seconds, sms_out_need_unique_id from gtc_sms_config where (1 = 0)</tt>
	 *
	 *	@param id 
	 *	@param content 
	 *	@param configName 
	 *	@param sendChannel 
	 *	@param gmtModifiedBegin 
	 *	@param gmtModifiedEnd 
	 *	@param page 
	 *	@return List<SmsConfigDO>
	 *	@throws DataAccessException
	 */	 

		public List<SmsConfigDO> search(@Param("id")long id , @Param("content")String content , @Param("configName")String configName , @Param("sendChannel")String sendChannel , @Param("gmtModifiedBegin")String gmtModifiedBegin , @Param("gmtModifiedEnd")String gmtModifiedEnd , @Param("page")Page<SmsConfigDO> page) throws DataAccessException;

	/**
	 *  Query DB table <tt>gtc_sms_config</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, config_name, gmt_modified, gmt_create, content, send_channels, interval_seconds, ACK_CODE_TIMEOUT_SECONDS, ACK_CODE_MAX_VALIDATE, send_start_time, send_end_time, max_try_count, retry_interval_seconds, sms_out_need_unique_id from gtc_sms_config</tt>
	 *
	 *	@return List<SmsConfigDO>
	 *	@throws DataAccessException
	 */	 

		public List<SmsConfigDO> selectAll() throws DataAccessException;

	/**
	 *  Query DB table <tt>gtc_sms_config</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select gmt_modified from gtc_sms_config</tt>
	 *
	 *	@return Date
	 *	@throws DataAccessException
	 */	 

		public Date selectMaxGmtModified() throws DataAccessException;

	/**
	 *  Query DB table <tt>gtc_sms_config</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, config_name, gmt_modified, gmt_create, content, send_channels, interval_seconds, ACK_CODE_TIMEOUT_SECONDS, ACK_CODE_MAX_VALIDATE, send_start_time, send_end_time, max_try_count, retry_interval_seconds, sms_out_need_unique_id from gtc_sms_config where (gmt_modified = ?)</tt>
	 *
	 *	@param gmtModified 
	 *	@return List<SmsConfigDO>
	 *	@throws DataAccessException
	 */	 

		public List<SmsConfigDO> selectGreaterThanModifiedDate(@Param("gmtModified")Date gmtModified) throws DataAccessException;

	/**
	 *  Update DB table <tt>gtc_sms_config</tt>.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>update gtc_sms_config set gmt_modified=now() where (1 = 0)</tt>
	 *
	 *	@param ids 
	 *	@param sendChannels 
	 *	@return int
	 *	@throws DataAccessException
	 */	 

		public int updateSendChannelsByIds(@Param("ids")List<?> ids , @Param("sendChannels")String sendChannels) throws DataAccessException;

	/**
	 *  Update DB table <tt>gtc_sms_config</tt>.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>update gtc_sms_config set content=?, send_channels=?, interval_seconds=?, ack_code_timeout_seconds=?, ack_code_max_validate=?, send_start_time=?, send_end_time=?, max_try_count=?, retry_interval_seconds=?, sms_out_need_unique_id=?, gmt_modified=now() where (id = ?)</tt>
	 *
	 *	@param content 
	 *	@param sendChannels 
	 *	@param intervalSeconds 
	 *	@param ackCodeTimeoutSeconds 
	 *	@param ackCodeMaxValidate 
	 *	@param sendStartTime 
	 *	@param sendEndTime 
	 *	@param maxTryCount 
	 *	@param retryIntervalSeconds 
	 *	@param smsOutNeedUniqueId 
	 *	@param id 
	 *	@return int
	 *	@throws DataAccessException
	 */	 

		public int updateById(@Param("content")String content , @Param("sendChannels")String sendChannels , @Param("intervalSeconds")long intervalSeconds , @Param("ackCodeTimeoutSeconds")long ackCodeTimeoutSeconds , @Param("ackCodeMaxValidate")int ackCodeMaxValidate , @Param("sendStartTime")String sendStartTime , @Param("sendEndTime")String sendEndTime , @Param("maxTryCount")int maxTryCount , @Param("retryIntervalSeconds")long retryIntervalSeconds , @Param("smsOutNeedUniqueId")boolean smsOutNeedUniqueId , @Param("id")long id) throws DataAccessException;

}