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
import com.yuan.gotonecore.repository.entity.SmsClientSendHistoryDO;
import org.springframework.dao.DataAccessException;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
//do imports
import java.util.Date;

/**
 * A dao interface provides methods to access database table <tt>gtc_sms_client_send_history</tt>.
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
public interface SmsClientSendHistoryMapper  extends BaseMapper<SmsClientSendHistoryDO>{
	/**
	 *  Query DB table <tt>gtc_sms_client_send_history</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, sms_id, status, gmt_create, gmt_modified, gmt_client_apply, client_no, gmt_his_create, client_apply_count, gmt_client_send_finish, gmt_client_resend, client_send_result from gtc_sms_client_send_history where (id = ?)</tt>
	 *
	 *	@param id 
	 *	@return SmsClientSendHistoryDO
	 *	@throws DataAccessException
	 */	 

		public SmsClientSendHistoryDO selectById(@Param("id")long id) throws DataAccessException;

	/**
	 *  Query DB table <tt>gtc_sms_client_send_history</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, sms_id, status, gmt_create, gmt_modified, gmt_client_apply, client_no, gmt_his_create, client_apply_count, gmt_client_send_finish, gmt_client_resend, client_send_result from gtc_sms_client_send_history where (1 = 0)</tt>
	 *
	 *	@param id 
	 *	@param smsId 
	 *	@param status 
	 *	@param clientNo 
	 *	@param page 
	 *	@return List<SmsClientSendHistoryDO>
	 *	@throws DataAccessException
	 */	 

		public List<SmsClientSendHistoryDO> search(@Param("id")long id , @Param("smsId")long smsId , @Param("status")String status , @Param("clientNo")String clientNo , @Param("page")Page<SmsClientSendHistoryDO> page) throws DataAccessException;

}