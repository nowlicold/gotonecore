/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.api.sms.request;


import com.bench.lang.base.string.build.ToStringBuilder;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 短信验证码验证请求
 * 
 * @author cold
 *
 * @version $Id: SmsAckCodeValidateRequest.java, v 0.1 2017年2月24日 上午10:54:08
 *          Administrator Exp $
 */
@Data
public class SmsAckCodeValidateRequest {

	/**
	 * 短信ID
	 */
	@ApiModelProperty(value="短信ID")
	private String smsId;

	/**
	 * 业务ID
	 */
	@ApiModelProperty(value="业务ID")
	private String bizId;

	/**
	 * 会员id
	 */
	@ApiModelProperty(value="会员id")
	private String userId;

	/**
	 * 手机号码
	 */
	@ApiModelProperty(value="手机号码")
	private String cell;

	/**
	 * 校验码
	 */
	@ApiModelProperty(value="ackCode")
	private String ackCode;


	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
