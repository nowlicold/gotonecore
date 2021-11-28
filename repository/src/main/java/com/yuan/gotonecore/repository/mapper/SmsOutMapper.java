/*
 * Bench Inc.
 * Copyright (c) 2004 All Rights Reserved.
 */
package com.yuan.gotonecore.repository.mapper;



// auto generated imports
//dao imports
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import com.yuan.gotonecore.repository.entity.SmsOutDO;
import org.springframework.dao.DataAccessException;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Date;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
//do imports

/**
 * A dao interface provides methods to access database table <tt>gtc_sms_out</tt>.
 *
 * This file is generated by <tt>bench-gen-dal</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>bench</tt> project.
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/biz/dal/src/conf/dalgen</tt>, and 
 * find the corresponding configuration file (<tt>tables/gtc_sms_out.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>bench-gen-dal</tt> 
 * to generate this file.
 *
 * @author nowli
 */
public interface SmsOutMapper  extends BaseMapper<SmsOutDO>{
	/**
	 *  Update DB table <tt>gtc_sms_out</tt>.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>update gtc_sms_out set gmt_modified=now() where (1 = 0)</tt>
	 *
	 *	@param doList 
	 *	@return int
	 *	@throws DataAccessException
	 */	 

		public int insertBatch(@Param("doList")List<?> doList) throws DataAccessException;

	/**
	 *  Query DB table <tt>gtc_sms_out</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, receiver, user_id, content, status, gmt_resend, send_times, gmt_modified, gmt_create, sms_config_id, properties, biz_id, ack_code, send_result, send_channel, send_channel_specified, resend_from_id, sms_id, unique_id, template_args, app_code from gtc_sms_out where (id = ?)</tt>
	 *
	 *	@param id 
	 *	@return SmsOutDO
	 *	@throws DataAccessException
	 */	 

		public SmsOutDO selectById(@Param("id")long id) throws DataAccessException;

	/**
	 *  Query DB table <tt>gtc_sms_out</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, receiver, user_id, content, status, gmt_resend, send_times, gmt_modified, gmt_create, sms_config_id, properties, biz_id, ack_code, send_result, send_channel, send_channel_specified, resend_from_id, sms_id, unique_id, template_args, app_code from gtc_sms_out where (sms_id = ?)</tt>
	 *
	 *	@param smsId 
	 *	@return SmsOutDO
	 *	@throws DataAccessException
	 */	 

		public SmsOutDO selectBySmsId(@Param("smsId")String smsId) throws DataAccessException;

	/**
	 *  Query DB table <tt>gtc_sms_out</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select COUNT(*) from gtc_sms_out where (sms_id = ?)</tt>
	 *
	 *	@param smsId 
	 *	@return long
	 *	@throws DataAccessException
	 */	 

		public long selectCountBySmsId(@Param("smsId")String smsId) throws DataAccessException;

	/**
	 *  Query DB table <tt>gtc_sms_out</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, receiver, user_id, content, status, gmt_resend, send_times, gmt_modified, gmt_create, sms_config_id, properties, biz_id, ack_code, send_result, send_channel, send_channel_specified, resend_from_id, sms_id, unique_id, template_args, app_code from gtc_sms_out where (1 = 0)</tt>
	 *
	 *	@param ids 
	 *	@return List<SmsOutDO>
	 *	@throws DataAccessException
	 */	 

		public List<SmsOutDO> selectByIds(@Param("ids")List<?> ids) throws DataAccessException;

	/**
	 *  Query DB table <tt>gtc_sms_out</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, receiver, user_id, content, status, gmt_resend, send_times, gmt_modified, gmt_create, sms_config_id, properties, biz_id, ack_code, send_result, send_channel, send_channel_specified, resend_from_id, sms_id, unique_id, template_args, app_code from gtc_sms_out where (id = ?) for update</tt>
	 *
	 *	@param id 
	 *	@return SmsOutDO
	 *	@throws DataAccessException
	 */	 

		public SmsOutDO selectByIdForUpdate(@Param("id")long id) throws DataAccessException;

	/**
	 *  Query DB table <tt>gtc_sms_out</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select id from gtc_sms_out where (1 = 0)</tt>
	 *
	 *	@param recordCount 
	 *	@return List<Long>
	 *	@throws DataAccessException
	 */	 

		public List<Long> selectReadyToSendIds(@Param("recordCount")int recordCount) throws DataAccessException;

	/**
	 *  Query DB table <tt>gtc_sms_out</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, receiver, user_id, content, status, gmt_resend, send_times, gmt_modified, gmt_create, sms_config_id, properties, biz_id, ack_code, send_result, send_channel, send_channel_specified, resend_from_id, sms_id, unique_id, template_args, app_code from gtc_sms_out where (1 = 0)</tt>
	 *
	 *	@param receiver 
	 *	@param userId 
	 *	@param status 
	 *	@param page 
	 *	@return List<SmsOutDO>
	 *	@throws DataAccessException
	 */	 

		public List<SmsOutDO> search(@Param("receiver")String receiver , @Param("userId")String userId , @Param("status")String status , @Param("page")Page<SmsOutDO> page) throws DataAccessException;

	/**
	 *  Query DB table <tt>gtc_sms_out</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, receiver, user_id, content, status, gmt_resend, send_times, gmt_modified, gmt_create, sms_config_id, properties, biz_id, ack_code, send_result, send_channel, send_channel_specified, resend_from_id, sms_id, unique_id, template_args, app_code from gtc_sms_out where ((biz_id = ?) AND (sms_config_id = ?))</tt>
	 *
	 *	@param bizId 
	 *	@param smsConfigId 
	 *	@return SmsOutDO
	 *	@throws DataAccessException
	 */	 

		public SmsOutDO selectByBizIdSmsConfigIdWithIntervalSeconds(@Param("bizId")String bizId , @Param("smsConfigId")long smsConfigId) throws DataAccessException;

	/**
	 *  Update DB table <tt>gtc_sms_out</tt>.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>update gtc_sms_out set gmt_resend=?, gmt_modified=now(), status='R', send_result=?, send_channel=? where (id = ?)</tt>
	 *
	 *	@param gmtResend 
	 *	@param sendResult 
	 *	@param sendChannel 
	 *	@param id 
	 *	@return int
	 *	@throws DataAccessException
	 */	 

		public int updateSendFaild(@Param("gmtResend")Date gmtResend , @Param("sendResult")String sendResult , @Param("sendChannel")String sendChannel , @Param("id")long id) throws DataAccessException;

	/**
	 *  Update DB table <tt>gtc_sms_out</tt>.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>update gtc_sms_out set gmt_modified=now(), status='P', send_channel=? where (id = ?)</tt>
	 *
	 *	@param sendChannel 
	 *	@param id 
	 *	@return int
	 *	@throws DataAccessException
	 */	 

		public int updatePrepared(@Param("sendChannel")String sendChannel , @Param("id")long id) throws DataAccessException;

	/**
	 *  Update DB table <tt>gtc_sms_out</tt>.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>update gtc_sms_out set gmt_resend=now(), gmt_modified=now(), status='O', send_channel=? where (id = ?)</tt>
	 *
	 *	@param sendChannel 
	 *	@param id 
	 *	@return int
	 *	@throws DataAccessException
	 */	 

		public int updateSendOverTryCount(@Param("sendChannel")String sendChannel , @Param("id")long id) throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>gtc_sms_out</tt>.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from gtc_sms_out where (id = ?)</tt>
	 *
	 *	@param id 
	 *	@return int
	 *	@throws DataAccessException
	 */	 

		public int deleteById(@Param("id")long id) throws DataAccessException;

}