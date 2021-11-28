/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.api.result;

import com.bench.common.model.BaseResult;
import com.bench.lang.base.object.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 
 * @author cold
 * 
 * @version $Id: MailUserConfigOperateResult.java, v 0.1 2012-10-25 下午6:23:08
 *          cold Exp $
 */
public class MailUserConfigOperateResult extends BaseResult {

	private long id;

	/**
	 * @return Returns the id.
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            The id to set.
	 */
	public void setId(long id) {
		this.id = id;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
