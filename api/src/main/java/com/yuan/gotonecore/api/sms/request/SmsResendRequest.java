/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.api.sms.request;


import com.yuan.gotonecore.api.sms.model.enums.SmsChannelEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 短信重新发送请求
 * 
 * @author cold
 *
 * @version $Id: SmsResendRequest.java, v 0.1 2017年2月24日 上午10:40:39
 *          Administrator Exp $
 */
@Data
public class SmsResendRequest {

	/**
	 * 短信id
	 */
	@ApiModelProperty(value = "短信id")
	private long id;

	/**
	 * 短信配置名
	 */
	@ApiModelProperty(value = "短信配置名")
	private SmsChannelEnum channel;


}
