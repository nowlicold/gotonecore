/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.api.sms.app.request;

import com.yuan.gotonecore.api.sms.model.enums.AppServiceNameEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;


/**
 * 发送简单短信
 * 
 * @author cold
 *
 * @version $Id: SmsSendSimpleAppServiceRequest.java, v 0.1 2017年3月2日 下午3:55:21
 *          Administrator Exp $
 */
@Data
public class SmsSendSimpleAppServiceRequest extends AbstractAppServiceRequest {

	/**
	 * 手机号码
	 */
	@ApiModelProperty(value = "手机号码")
	private List<String> cells;

	/**
	 * 短信配置名
	 */
	@ApiModelProperty(value = "短信配置名")
	private String content;

	/**
	 * 会员ID
	 */
	@ApiModelProperty(value = "会员ID")
	private String userId;

	/**
	 * 唯一标志此次短信发送
	 */
	@ApiModelProperty(value = "唯一标志此次短信发送")
	private String id;

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
		return AppServiceNameEnum.SMS_SEND_SIMPLE;
	}

}
