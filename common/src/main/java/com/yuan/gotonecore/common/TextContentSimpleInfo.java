package com.yuan.gotonecore.common;

import com.yuan.gotonecore.common.enums.TextContentOwnerTypeEnum;

import java.util.Date;

/**
 * 文本简单内容，不包括Content
 * 
 * @author cold
 * 
 * @version $Id: TextContent.java, v 0.1 2011-1-23 下午04:48:22 cold Exp $
 */
public class TextContentSimpleInfo {

	/**
	 * 所有者ID
	 */
	private String ownerId;

	/**
	 * 所有者类型
	 */
	private TextContentOwnerTypeEnum ownerType;

	/**
	 * 修改时间
	 */
	private Date gmtModified;

	/**
	 * 创建时间
	 */
	private Date gmtCreate;

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public TextContentOwnerTypeEnum getOwnerType() {
		return ownerType;
	}

	public void setOwnerType(TextContentOwnerTypeEnum ownerType) {
		this.ownerType = ownerType;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

}
