/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.api.sms.app.request;

import com.yuan.gotonecore.api.sms.model.enums.AppServiceNameEnum;
import com.yuan.gotonecore.api.sms.model.enums.SmsChannelEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Map;

/**
 * 发送短信
 * 
 * @author cold
 *
 * @version $Id: SmsSendAppServiceRequest.java, v 0.1 2017年3月2日 下午3:55:10
 *          Administrator Exp $
 */
@Data
public class SmsSendAppServiceRequest extends AbstractAppServiceRequest {

	/**
	 * 手机号码
	 */
	@ApiModelProperty(value = "手机号码")
	private String cell;

	/**
	 * 短信配置名
	 */
	@ApiModelProperty(value = "短信配置名")
	private String smsConfigName;

	/**
	 * 业务ID，唯一标志此次短信发送
	 */
	@ApiModelProperty(value = "业务ID，唯一标志此次短信发送")
	private String bizId;

	/**
	 * 校验码，如果是验证类短信，会提供该验证码,如果为空，则由gotone自动生成
	 */
	@ApiModelProperty(value = "校验码，如果是验证类短信，会提供该验证码,如果为空，则由gotone自动生成")
	private String ackCode;

	/**
	 * 发送通道,如果通道不为空,表示通道已经指定了
	 */
	@ApiModelProperty(value = "发送通道,如果通道不为空,表示通道已经指定了")
	private SmsChannelEnum sendChannel;

	/** 消息内容模板参数 */
	@ApiModelProperty(value = "消息内容模板参数")
	protected Map<String, String> templateArgs;

	/**
	 * 属性集合
	 */
	@ApiModelProperty(value = "属性集合")
	protected Map<String, String> properties;

	/**
	 * 用户ID
	 */
	@ApiModelProperty(value = "用户ID")
	private String userId;

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
		return AppServiceNameEnum.SMS_SEND;
	}

}
