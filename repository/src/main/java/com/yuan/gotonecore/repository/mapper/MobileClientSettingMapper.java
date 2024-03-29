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
import com.yuan.gotonecore.repository.entity.MobileClientSettingDO;
import org.springframework.dao.DataAccessException;
import java.util.Date;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
//do imports

/**
 * A dao interface provides methods to access database table <tt>gtc_mobile_client_setting</tt>.
 *
 * This file is generated by <tt>bench-gen-dal</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>bench</tt> project.
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/biz/dal/src/conf/dalgen</tt>, and 
 * find the corresponding configuration file (<tt>tables/gtc_mobile_client_setting.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>bench-gen-dal</tt> 
 * to generate this file.
 *
 * @author nowli
 */
public interface MobileClientSettingMapper  extends BaseMapper<MobileClientSettingDO>{
	/**
	 *  Query DB table <tt>gtc_mobile_client_setting</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, user_id, login_key, sign_key, login_platform_type, gmt_login, gmt_create, gmt_modified, logined, gmt_logout, notice_key, notice_enabled, gmt_notice_key_update from gtc_mobile_client_setting where (user_id = ?)</tt>
	 *
	 *	@param userId 
	 *	@return MobileClientSettingDO
	 *	@throws DataAccessException
	 */	 

		public MobileClientSettingDO selectByUserId(@Param("userId")String userId) throws DataAccessException;

	/**
	 *  Query DB table <tt>gtc_mobile_client_setting</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, user_id, login_key, sign_key, login_platform_type, gmt_login, gmt_create, gmt_modified, logined, gmt_logout, notice_key, notice_enabled, gmt_notice_key_update from gtc_mobile_client_setting where (notice_key = ?)</tt>
	 *
	 *	@param noticeKey 
	 *	@return List<MobileClientSettingDO>
	 *	@throws DataAccessException
	 */	 

		public List<MobileClientSettingDO> selectByNoticeKey(@Param("noticeKey")String noticeKey) throws DataAccessException;

	/**
	 *  Update DB table <tt>gtc_mobile_client_setting</tt>.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>update gtc_mobile_client_setting set login_key=?, sign_key=?, login_platform_type=?, gmt_login=?, gmt_modified=now(), logined=1, notice_key=?, notice_enabled=?, gmt_notice_key_update=? where (user_id = ?)</tt>
	 *
	 *	@param loginKey 
	 *	@param signKey 
	 *	@param loginPlatformType 
	 *	@param gmtLogin 
	 *	@param noticeKey 
	 *	@param noticeEnabled 
	 *	@param gmtNoticeKeyUpdate 
	 *	@param userId 
	 *	@return int
	 *	@throws DataAccessException
	 */	 

		public int updateLoginSuccess(@Param("loginKey")String loginKey , @Param("signKey")String signKey , @Param("loginPlatformType")String loginPlatformType , @Param("gmtLogin")Date gmtLogin , @Param("noticeKey")String noticeKey , @Param("noticeEnabled")boolean noticeEnabled , @Param("gmtNoticeKeyUpdate")Date gmtNoticeKeyUpdate , @Param("userId")String userId) throws DataAccessException;

	/**
	 *  Update DB table <tt>gtc_mobile_client_setting</tt>.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>update gtc_mobile_client_setting set gmt_modified=now(), logined=0, notice_enabled=?, gmt_logout=? where (user_id = ?)</tt>
	 *
	 *	@param noticeEnabled 
	 *	@param gmtLogout 
	 *	@param userId 
	 *	@return int
	 *	@throws DataAccessException
	 */	 

		public int updateLogoutSuccess(@Param("noticeEnabled")boolean noticeEnabled , @Param("gmtLogout")Date gmtLogout , @Param("userId")String userId) throws DataAccessException;

	/**
	 *  Update DB table <tt>gtc_mobile_client_setting</tt>.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>update gtc_mobile_client_setting set gmt_modified=now(), notice_key=?, notice_enabled=?, gmt_notice_key_update=? where (user_id = ?)</tt>
	 *
	 *	@param noticeKey 
	 *	@param noticeEnabled 
	 *	@param gmtNoticeKeyUpdate 
	 *	@param userId 
	 *	@return int
	 *	@throws DataAccessException
	 */	 

		public int updateNoticeKey(@Param("noticeKey")String noticeKey , @Param("noticeEnabled")boolean noticeEnabled , @Param("gmtNoticeKeyUpdate")Date gmtNoticeKeyUpdate , @Param("userId")String userId) throws DataAccessException;

	/**
	 *  Query DB table <tt>gtc_mobile_client_setting</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, user_id, login_key, sign_key, login_platform_type, gmt_login, gmt_create, gmt_modified, logined, gmt_logout, notice_key, notice_enabled, gmt_notice_key_update from gtc_mobile_client_setting where (1 = 0)</tt>
	 *
	 *	@param id 
	 *	@param userId 
	 *	@param loginKey 
	 *	@param signKey 
	 *	@param loginPlatformType 
	 *	@param gmtLoginStart 
	 *	@param gmtLoginEnd 
	 *	@param gmtLogoutStart 
	 *	@param gmtLogoutEnd 
	 *	@param gmtCreateStart 
	 *	@param gmtCreateEnd 
	 *	@param gmtModifiedStart 
	 *	@param gmtModifiedEnd 
	 *	@param noticeKey 
	 *	@param noticeEnabled 
	 *	@param logined 
	 *	@param page 
	 *	@return List<MobileClientSettingDO>
	 *	@throws DataAccessException
	 */	 

		public List<MobileClientSettingDO> search(@Param("id")long id , @Param("userId")String userId , @Param("loginKey")String loginKey , @Param("signKey")String signKey , @Param("loginPlatformType")String loginPlatformType , @Param("gmtLoginStart")Date gmtLoginStart , @Param("gmtLoginEnd")Date gmtLoginEnd , @Param("gmtLogoutStart")Date gmtLogoutStart , @Param("gmtLogoutEnd")Date gmtLogoutEnd , @Param("gmtCreateStart")Date gmtCreateStart , @Param("gmtCreateEnd")Date gmtCreateEnd , @Param("gmtModifiedStart")Date gmtModifiedStart , @Param("gmtModifiedEnd")Date gmtModifiedEnd , @Param("noticeKey")String noticeKey , @Param("noticeEnabled")Boolean noticeEnabled , @Param("logined")Boolean logined , @Param("page")Page<MobileClientSettingDO> page) throws DataAccessException;

	/**
	 *  Query DB table <tt>gtc_mobile_client_setting</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, user_id, login_key, sign_key, login_platform_type, gmt_login, gmt_create, gmt_modified, logined, gmt_logout, notice_key, notice_enabled, gmt_notice_key_update from gtc_mobile_client_setting where (id = ?)</tt>
	 *
	 *	@param id 
	 *	@return MobileClientSettingDO
	 *	@throws DataAccessException
	 */	 

		public MobileClientSettingDO selectById(@Param("id")long id) throws DataAccessException;

}