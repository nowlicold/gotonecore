/*
 * Bench.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.common.result;


import com.bench.lang.base.object.ToStringBuilder;
import com.yuan.gotonecore.common.enums.ErrorCodeEnum;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 沟通服务返回结果
 * 
 * @author min.weixm
 * 
 * @version $Id: GtMailServiceResult.java, v 0.1 2009-9-08 下午02:35:58 min.weixm
 *          Exp $
 */
public class GotoneServiceResult implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 5842009683194364901L;

	/** 返回结果 */
	private ErrorCodeEnum error;

	/**
	 * 错误详细信息
	 */
	private String detailError;

	/** 成功状态 */
	private boolean success;

	/**
	 * 发送后的信息Id
	 */
	private long id;

	/**
	 * Getter method for property <tt>isSuccess</tt>.
	 * 
	 * @return property value of isSuccess
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * Setter method for property <tt>isSuccess</tt>.
	 * 
	 * @param
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * Getter method for property <tt>returnCode</tt>.
	 * 
	 * @return property value of returnCode
	 */
	public ErrorCodeEnum getError() {
		return error;
	}

	/**
	 * Setter method for property <tt>returnCode</tt>.
	 * 
	 * @param
	 */
	public void setError(ErrorCodeEnum error) {
		this.error = error;
	}

	/**
	 * @see Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return Returns the detailError.
	 */
	public String getDetailError() {
		return detailError;
	}

	/**
	 * @param detailError
	 *            The detailError to set.
	 */
	public void setDetailError(String detailError) {
		this.detailError = detailError;
	}

}
