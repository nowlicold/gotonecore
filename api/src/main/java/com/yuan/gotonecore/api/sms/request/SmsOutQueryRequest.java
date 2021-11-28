/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.api.sms.request;
import com.bench.common.model.PageRequest;
import com.yuan.gotonecore.api.model.enums.MessageStatusEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * @author Debug
 * 
 * @version $Id: SmsOutQueryRequest.java, v 0.1 2011-9-29 下午12:23:35 Debug Exp $
 */
@Data
public class SmsOutQueryRequest extends PageRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6062171663907865681L;

	/**
	 * 接收人手机号
	 */
	@ApiModelProperty(value = "接收人手机号")
	private String receiver;

	/**
	 * 用户ID
	 */
	@ApiModelProperty(value = "用户ID")
	private String userId;

	/**
	 * 发送状态
	 */
	@ApiModelProperty(value = "发送状态")
	private MessageStatusEnum status;


}
