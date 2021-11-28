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
import com.yuan.gotonecore.repository.entity.SmsConfigInChannelDO;
import org.springframework.dao.DataAccessException;
import java.util.Date;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
//do imports

/**
 * A dao interface provides methods to access database table <tt>gtc_sms_config_in_channel</tt>.
 *
 * This file is generated by <tt>bench-gen-dal</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>bench</tt> project.
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/biz/dal/src/conf/dalgen</tt>, and 
 * find the corresponding configuration file (<tt>tables/gtc_sms_config_in_channel.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>bench-gen-dal</tt> 
 * to generate this file.
 *
 * @author nowli
 */
public interface SmsConfigInChannelMapper  extends BaseMapper<SmsConfigInChannelDO>{
	/**
	 *  Query DB table <tt>gtc_sms_config_in_channel</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, sms_config_id, content, channel, gmt_create, gmt_modified, enabled, properties from gtc_sms_config_in_channel</tt>
	 *
	 *	@return List<SmsConfigInChannelDO>
	 *	@throws DataAccessException
	 */	 

		public List<SmsConfigInChannelDO> selectAll() throws DataAccessException;

	/**
	 *  Query DB table <tt>gtc_sms_config_in_channel</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, sms_config_id, content, channel, gmt_create, gmt_modified, enabled, properties from gtc_sms_config_in_channel where (1 = 0)</tt>
	 *
	 *	@param tmodified 
	 *	@return List<SmsConfigInChannelDO>
	 *	@throws DataAccessException
	 */	 

		public List<SmsConfigInChannelDO> selectByMaxGmtModified(@Param("tmodified")Date tmodified) throws DataAccessException;

}