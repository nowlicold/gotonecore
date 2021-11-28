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
import com.yuan.gotonecore.repository.entity.ActivityDO;
import org.springframework.dao.DataAccessException;
import java.util.Date;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
//do imports

/**
 * A dao interface provides methods to access database table <tt>gtc_activity</tt>.
 *
 * This file is generated by <tt>bench-gen-dal</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>bench</tt> project.
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/biz/dal/src/conf/dalgen</tt>, and 
 * find the corresponding configuration file (<tt>tables/gtc_activity.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>bench-gen-dal</tt> 
 * to generate this file.
 *
 * @author nowli
 */
public interface ActivityMapper  extends BaseMapper<ActivityDO>{
	/**
	 *  Query DB table <tt>gtc_activity</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, activity_name, gmt_create, gmt_modified, memo, activity_status, activity_code from gtc_activity where (id = ?)</tt>
	 *
	 *	@param id 
	 *	@return ActivityDO
	 *	@throws DataAccessException
	 */	 

		public ActivityDO getById(@Param("id")Integer id) throws DataAccessException;

	/**
	 *  Query DB table <tt>gtc_activity</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, activity_name, gmt_create, gmt_modified, memo, activity_status, activity_code from gtc_activity</tt>
	 *
	 *	@return List<ActivityDO>
	 *	@throws DataAccessException
	 */	 

		public List<ActivityDO> selectAll() throws DataAccessException;

	/**
	 *  Query DB table <tt>gtc_activity</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, activity_name, gmt_create, gmt_modified, memo, activity_status, activity_code from gtc_activity where (activity_code = ?)</tt>
	 *
	 *	@param activityCode 
	 *	@return ActivityDO
	 *	@throws DataAccessException
	 */	 

		public ActivityDO getByActivityCode(@Param("activityCode")String activityCode) throws DataAccessException;

	/**
	 *  Update DB table <tt>gtc_activity</tt>.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>update gtc_activity set activity_name=?, memo=?, activity_status=?, gmt_modified=now(), activity_code=? where (id = ?)</tt>
	 *
	 *	@param activity 
	 *	@return int
	 *	@throws DataAccessException
	 */	 

		public int modify(@Param("activity")ActivityDO activity) throws DataAccessException;

	/**
	 *  Query DB table <tt>gtc_activity</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, activity_name, gmt_create, gmt_modified, memo, activity_status, activity_code from gtc_activity where (gmt_modified = ?)</tt>
	 *
	 *	@param gmtModified 
	 *	@return List<ActivityDO>
	 *	@throws DataAccessException
	 */	 

		public List<ActivityDO> selectGreaterThanModifiedDate(@Param("gmtModified")Date gmtModified) throws DataAccessException;

	/**
	 *  Query DB table <tt>gtc_activity</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select gmt_modified from gtc_activity</tt>
	 *
	 *	@return Date
	 *	@throws DataAccessException
	 */	 

		public Date selectMaxGmtModified() throws DataAccessException;

	/**
	 *  Query DB table <tt>gtc_activity</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, activity_name, gmt_create, gmt_modified, memo, activity_status, activity_code from gtc_activity where (1 = 0)</tt>
	 *
	 *	@param activityName 
	 *	@param activityCode 
	 *	@param activityStatus 
	 *	@param gmtModifiedBegin 
	 *	@param gmtModifiedEnd 
	 *	@param page 
	 *	@return List<ActivityDO>
	 *	@throws DataAccessException
	 */	 

		public List<ActivityDO> search(@Param("activityName")String activityName , @Param("activityCode")String activityCode , @Param("activityStatus")String activityStatus , @Param("gmtModifiedBegin")String gmtModifiedBegin , @Param("gmtModifiedEnd")String gmtModifiedEnd , @Param("page")Page<ActivityDO> page) throws DataAccessException;

}