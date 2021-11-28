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
import com.yuan.gotonecore.repository.entity.TextContentDO;
import org.springframework.dao.DataAccessException;
import java.util.Date;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
//do imports

/**
 * A dao interface provides methods to access database table <tt>gtc_text_content</tt>.
 *
 * This file is generated by <tt>bench-gen-dal</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>bench</tt> project.
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/biz/dal/src/conf/dalgen</tt>, and 
 * find the corresponding configuration file (<tt>tables/gtc_text_content.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>bench-gen-dal</tt> 
 * to generate this file.
 *
 * @author nowli
 */
public interface TextContentMapper  extends BaseMapper<TextContentDO>{
	/**
	 *  Query DB table <tt>gtc_text_content</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select owner_id, owner_type, content, gmt_create, gmt_modified, deleted from gtc_text_content where ((owner_id = ?) AND (owner_type = ?))</tt>
	 *
	 *	@param ownerId 
	 *	@param ownerType 
	 *	@return TextContentDO
	 *	@throws DataAccessException
	 */	 

		public TextContentDO getByOwnerIdAndOwnerType(@Param("ownerId")String ownerId , @Param("ownerType")String ownerType) throws DataAccessException;

	/**
	 *  Query DB table <tt>gtc_text_content</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select gmt_modified from gtc_text_content where ((owner_id = ?) AND (owner_type = ?))</tt>
	 *
	 *	@param ownerId 
	 *	@param ownerType 
	 *	@return Date
	 *	@throws DataAccessException
	 */	 

		public Date getGmtModifiedByOwnerIdAndOwnerType(@Param("ownerId")String ownerId , @Param("ownerType")String ownerType) throws DataAccessException;

	/**
	 *  Query DB table <tt>gtc_text_content</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select owner_id, owner_type, content, gmt_create, gmt_modified, deleted from gtc_text_content</tt>
	 *
	 *	@return List<TextContentDO>
	 *	@throws DataAccessException
	 */	 

		public List<TextContentDO> selectAll() throws DataAccessException;

	/**
	 *  Update DB table <tt>gtc_text_content</tt>.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>update gtc_text_content set content=?, gmt_modified=now() where ((owner_id = ?) AND (owner_type = ?))</tt>
	 *
	 *	@param content 
	 *	@param ownerId 
	 *	@param ownerType 
	 *	@return int
	 *	@throws DataAccessException
	 */	 

		public int updateContent(@Param("content")String content , @Param("ownerId")String ownerId , @Param("ownerType")String ownerType) throws DataAccessException;

	/**
	 *  Query DB table <tt>gtc_text_content</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select max(gmt_modified) from gtc_text_content</tt>
	 *
	 *	@return Date
	 *	@throws DataAccessException
	 */	 

		public Date selectMaxGmtModified() throws DataAccessException;

	/**
	 *  Query DB table <tt>gtc_text_content</tt> for records.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>select owner_id, owner_type, content, gmt_create, gmt_modified, deleted from gtc_text_content where (gmt_modified = ?)</tt>
	 *
	 *	@param gmtModified 
	 *	@return List<TextContentDO>
	 *	@throws DataAccessException
	 */	 

		public List<TextContentDO> selectGreaterThanModifiedDate(@Param("gmtModified")Date gmtModified) throws DataAccessException;

	/**
	 *  Update DB table <tt>gtc_text_content</tt>.
	 *
	 *  <p>
	 *   
	 *  The sql statement for this operation is <br>
	 *  <tt>update gtc_text_content set deleted='1' where ((owner_id = ?) AND (owner_type = ?))</tt>
	 *
	 *	@param ownerId 
	 *	@param ownerType 
	 *	@return int
	 *	@throws DataAccessException
	 */	 

		public int updateDeleted(@Param("ownerId")String ownerId , @Param("ownerType")String ownerType) throws DataAccessException;

}