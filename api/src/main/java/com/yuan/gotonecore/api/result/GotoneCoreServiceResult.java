/*
 * Bench.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.api.result;

import com.bench.common.model.BaseResult;

import java.io.Serializable;

/**
 * 沟通服务返回结果
 * 
 * @author min.weixm
 * 
 * @version $Id: GtMailServiceResult.java, v 0.1 2009-9-08 下午02:35:58 min.weixm
 *          Exp $
 */
public class GotoneCoreServiceResult extends BaseResult implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 5842009683194364901L;

	/**
	 * 发送后的信息Id
	 */
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
