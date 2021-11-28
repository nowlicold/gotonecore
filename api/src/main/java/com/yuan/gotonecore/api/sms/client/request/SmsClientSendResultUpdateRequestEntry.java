/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.api.sms.client.request;


import com.bench.lang.base.object.ToStringObject;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 短信客户端发送结果条目
 * 
 * @author cold
 * 
 * @version $Id: SmsClientSendResultUpdateRequestEntry.java, v 0.1 2014-9-26
 *          下午2:55:18 cold Exp $
 */
@Data
public class SmsClientSendResultUpdateRequestEntry extends ToStringObject {

	/**
	 * 短信客户端发送ID
	 */
	@ApiModelProperty(value = "短信客户端发送ID")
	private long smsClientSendId;

	/**
	 * 是否成功
	 */
	@ApiModelProperty(value = "是否成功")
	private boolean success;

	/**
	 * 错误信息
	 */
	@ApiModelProperty(value = "错误信息")
	private String errorMessage;
}
