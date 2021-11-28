/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.api.sms.client.request;

import com.bench.lang.base.object.ToStringObject;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 
 * @author cold
 * 
 * @version $Id: SmsClientSendResultUpdateRequest.java, v 0.1 2014-9-26
 *          下午2:54:39 cold Exp $
 */
@Data
public class SmsClientSendResultUpdateRequest extends ToStringObject {
	@ApiModelProperty(value = "客户端号")
	private String clientNo;
	@ApiModelProperty(value = "短信客户端发送结果条目")
	private List<SmsClientSendResultUpdateRequestEntry> updateRequestEntries;


}
