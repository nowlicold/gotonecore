package com.yuan.gotonecore.api.result;

import com.bench.common.model.BaseResult;
import com.bench.lang.base.object.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 邮件服务器操作结果
 * 
 * @author cold
 * 
 * @version $Id: MailServerConfigOperateResult.java, v 0.1 2012-10-25 下午5:44:45
 *          cold Exp $
 */
public class MailServerConfigOperateResult extends BaseResult {

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
