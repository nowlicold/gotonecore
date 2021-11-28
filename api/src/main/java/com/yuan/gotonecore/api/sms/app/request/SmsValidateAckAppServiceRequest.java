/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.api.sms.app.request;

import com.yuan.gotonecore.api.sms.model.enums.AppServiceNameEnum;
import io.swagger.annotations.ApiModelProperty;

/**
 * 验证短信校验码请求
 * 
 * @author cold
 *
 * @version $Id: SmsValidateAckAppServiceRequest.java, v 0.1 2017年3月2日 下午3:55:32
 *          Administrator Exp $
 */
public class SmsValidateAckAppServiceRequest extends AbstractAppServiceRequest {

	/**
	 * 短信ID
	 */
	@ApiModelProperty(value = "短信ID")
	private String smsId;

	/**
	 * 业务ID
	 */
	@ApiModelProperty(value = "业务ID")
	private String bizId;

	/**
	 * 会员id
	 */
	@ApiModelProperty(value = "会员id")
	private String userId;

	/**
	 * 手机号码
	 */
	@ApiModelProperty(value = "手机号码")
	private String cell;

	/**
	 * 校验码
	 */
	@ApiModelProperty(value = "校验码")
	private String ackCode;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bench.app.gotone.core.service.app.request.AbstractAppServiceRequest
	 * #getServiceName()
	 */
	@Override
	public AppServiceNameEnum getServiceName() {
		// TODO Auto-generated method stub
		return AppServiceNameEnum.SMS_VALIDATE_ACK;
	}



}
