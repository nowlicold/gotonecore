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
import com.yuan.gotonecore.repository.entity.MailConfigBodyDO;
import org.springframework.dao.DataAccessException;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
//do imports
import java.util.Date;

/**
 * A dao interface provides methods to access database table <tt>gtc_mail_config_body</tt>.
 *
 * This file is generated by <tt>bench-gen-dal</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>bench</tt> project.
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/biz/dal/src/conf/dalgen</tt>, and 
 * find the corresponding configuration file (<tt>tables/gtc_mail_config_body.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>bench-gen-dal</tt> 
 * to generate this file.
 *
 * @author nowli
 */
public interface MailConfigBodyMapper  extends BaseMapper<MailConfigBodyDO>{
	/**
	 *  Query DB table <tt>gtc_mail_config_body</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, mail_content, gmt_modified, gmt_create from gtc_mail_config_body where (id = ?)</tt>
	 *
	 *	@param id 
	 *	@return MailConfigBodyDO
	 *	@throws DataAccessException
	 */	 

		public MailConfigBodyDO selectById(@Param("id")long id) throws DataAccessException;

	/**
	 *  Update DB table <tt>gtc_mail_config_body</tt>.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>update gtc_mail_config_body set mail_content=?, gmt_modified=now() where (id = ?)</tt>
	 *
	 *	@param mailContent 
	 *	@param id 
	 *	@return int
	 *	@throws DataAccessException
	 */	 

		public int modify(@Param("mailContent")String mailContent , @Param("id")long id) throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>gtc_mail_config_body</tt>.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from gtc_mail_config_body where (id = ?)</tt>
	 *
	 *	@param id 
	 *	@return int
	 *	@throws DataAccessException
	 */	 

		public int delete(@Param("id")long id) throws DataAccessException;

}