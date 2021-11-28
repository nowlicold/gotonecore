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
import com.yuan.gotonecore.repository.entity.SmsBlackListDO;
import org.springframework.dao.DataAccessException;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
//do imports
import java.util.Date;

/**
 * A dao interface provides methods to access database table <tt>gtc_sms_black_list</tt>.
 *
 * This file is generated by <tt>bench-gen-dal</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>bench</tt> project.
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/biz/dal/src/conf/dalgen</tt>, and 
 * find the corresponding configuration file (<tt>tables/gtc_sms_black_list.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>bench-gen-dal</tt> 
 * to generate this file.
 *
 * @author nowli
 */
public interface SmsBlackListMapper  extends BaseMapper<SmsBlackListDO>{
	/**
	 *  Query DB table <tt>gtc_sms_black_list</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, intercept_object_type, intercept_object_value, memo, gmt_remove, gmt_create, gmt_modified, enabled from gtc_sms_black_list where ((intercept_object_type = ?) AND (intercept_object_value = ?) AND (enabled = 1))</tt>
	 *
	 *	@param interceptObjectType 
	 *	@param interceptObjectValue 
	 *	@return List<SmsBlackListDO>
	 *	@throws DataAccessException
	 */	 

		public List<SmsBlackListDO> selectEnabledByInterceptTypeAndValue(@Param("interceptObjectType")String interceptObjectType , @Param("interceptObjectValue")String interceptObjectValue) throws DataAccessException;

	/**
	 *  Update DB table <tt>gtc_sms_black_list</tt>.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>update gtc_sms_black_list set gmt_modified=systimestamp, enabled=0 where (id = ?)</tt>
	 *
	 *	@param id 
	 *	@return int
	 *	@throws DataAccessException
	 */	 

		public int updateDisableById(@Param("id")String id) throws DataAccessException;

	/**
	 *  Query DB table <tt>gtc_sms_black_list</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, intercept_object_type, intercept_object_value, memo, gmt_remove, gmt_create, gmt_modified, enabled from gtc_sms_black_list where (enabled = 1) order by gmt_remove ASC</tt>
	 *
	 *	@param recordLimitAmount 获取的记录数
	 *	@return List<SmsBlackListDO>
	 *	@throws DataAccessException
	 */	 

		public List<SmsBlackListDO> selectReadyToRemove(@Param("recordLimitAmount")int recordLimitAmount) throws DataAccessException;

	/**
	 *  Query DB table <tt>gtc_sms_black_list</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, intercept_object_type, intercept_object_value, memo, gmt_remove, gmt_create, gmt_modified, enabled from gtc_sms_black_list where ((enabled = 1) AND (id = ?))</tt>
	 *
	 *	@param id 
	 *	@return SmsBlackListDO
	 *	@throws DataAccessException
	 */	 

		public SmsBlackListDO selectEnabledById(@Param("id")String id) throws DataAccessException;

	/**
	 *  Query DB table <tt>gtc_sms_black_list</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, intercept_object_type, intercept_object_value, memo, gmt_remove, gmt_create, gmt_modified, enabled from gtc_sms_black_list where (id = ?) for update</tt>
	 *
	 *	@param id 
	 *	@return SmsBlackListDO
	 *	@throws DataAccessException
	 */	 

		public SmsBlackListDO selectByIdForUpdate(@Param("id")String id) throws DataAccessException;

}