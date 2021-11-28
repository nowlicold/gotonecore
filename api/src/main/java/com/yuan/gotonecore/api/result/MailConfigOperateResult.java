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
 * @version $Id: MailConfigOperateResult.java, v 0.1 2010-12-13 下午06:55:17
 *          cold Exp $
 */
public class MailConfigOperateResult extends BaseResult {
	private long mailId;

	/**
	 * @return Returns the mailId.
	 */
	public long getMailId() {
		return mailId;
	}

	/**
	 * @param mailId
	 *            The mailId to set.
	 */
	public void setMailId(long mailId) {
		this.mailId = mailId;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
