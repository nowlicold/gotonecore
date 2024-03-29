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
import com.yuan.gotonecore.repository.entity.MailServerConfigDO;
import org.springframework.dao.DataAccessException;
import java.util.Date;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
//do imports

/**
 * A dao interface provides methods to access database table <tt>gtc_mail_server_config</tt>.
 *
 * This file is generated by <tt>bench-gen-dal</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>bench</tt> project.
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/biz/dal/src/conf/dalgen</tt>, and 
 * find the corresponding configuration file (<tt>tables/gtc_mail_server_config.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>bench-gen-dal</tt> 
 * to generate this file.
 *
 * @author nowli
 */
public interface MailServerConfigMapper  extends BaseMapper<MailServerConfigDO>{
	/**
	 *  Update DB table <tt>gtc_mail_server_config</tt>.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>update gtc_mail_server_config set host=?, port=?, timeout=?, connect_timeout=?, gmt_modified=now(), domain_name=? where (id = ?)</tt>
	 *
	 *	@param host 
	 *	@param port 
	 *	@param timeout 
	 *	@param connectTimeout 
	 *	@param domainName 
	 *	@param id 
	 *	@return int
	 *	@throws DataAccessException
	 */	 

		public int modify(@Param("host")String host , @Param("port")int port , @Param("timeout")long timeout , @Param("connectTimeout")long connectTimeout , @Param("domainName")String domainName , @Param("id")long id) throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>gtc_mail_server_config</tt>.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from gtc_mail_server_config where (id = ?)</tt>
	 *
	 *	@param id 
	 *	@return int
	 *	@throws DataAccessException
	 */	 

		public int delete(@Param("id")long id) throws DataAccessException;

	/**
	 *  Query DB table <tt>gtc_mail_server_config</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, host, port, timeout, connect_timeout, gmt_create, gmt_modified, domain_name from gtc_mail_server_config</tt>
	 *
	 *	@return List<MailServerConfigDO>
	 *	@throws DataAccessException
	 */	 

		public List<MailServerConfigDO> selectAll() throws DataAccessException;

	/**
	 *  Query DB table <tt>gtc_mail_server_config</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, host, port, timeout, connect_timeout, gmt_create, gmt_modified, domain_name from gtc_mail_server_config where (id = ?)</tt>
	 *
	 *	@param id 
	 *	@return MailServerConfigDO
	 *	@throws DataAccessException
	 */	 

		public MailServerConfigDO selectById(@Param("id")long id) throws DataAccessException;

	/**
	 *  Query DB table <tt>gtc_mail_server_config</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, host, port, timeout, connect_timeout, gmt_create, gmt_modified, domain_name from gtc_mail_server_config where ((host = ?) AND (port = ?))</tt>
	 *
	 *	@param host 
	 *	@param port 
	 *	@return MailServerConfigDO
	 *	@throws DataAccessException
	 */	 

		public MailServerConfigDO selectByHostPort(@Param("host")String host , @Param("port")int port) throws DataAccessException;

	/**
	 *  Query DB table <tt>gtc_mail_server_config</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select gmt_modified from gtc_mail_server_config</tt>
	 *
	 *	@return Date
	 *	@throws DataAccessException
	 */	 

		public Date selectMaxGmtModified() throws DataAccessException;

	/**
	 *  Query DB table <tt>gtc_mail_server_config</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, host, port, timeout, connect_timeout, gmt_create, gmt_modified, domain_name from gtc_mail_server_config</tt>
	 *
	 *	@param id 
	 *	@param host 
	 *	@param port 
	 *	@param connectTimeout 
	 *	@param timeout 
	 *	@param domainName 
	 *	@param beginModifiedDate 
	 *	@param endModifiedDate 
	 *	@param page 
	 *	@return List<MailServerConfigDO>
	 *	@throws DataAccessException
	 */	 

		public List<MailServerConfigDO> search(@Param("id")long id , @Param("host")String host , @Param("port")int port , @Param("connectTimeout")long connectTimeout , @Param("timeout")long timeout , @Param("domainName")String domainName , @Param("beginModifiedDate")String beginModifiedDate , @Param("endModifiedDate")String endModifiedDate , @Param("page")Page<MailServerConfigDO> page) throws DataAccessException;

}