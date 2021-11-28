/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.api.sms.request;

import com.yuan.gotonecore.api.request.MessageSendRequest;
import com.yuan.gotonecore.api.sms.model.enums.SmsChannelEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;


/**
 * 短信批量发送Request
 * 
 * @author cold
 *
 * @version $Id: SmsBatchSendRequest.java, v 0.1 2017年1月11日 下午3:41:45
 *          Administrator Exp $
 */
@Data
public class SmsBatchSendRequest extends MessageSendRequest {

	/**
	 * 手机号码
	 */
	@ApiModelProperty(value = "手机号码")
	private List<String> cells;

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

	/**
	 * 是否立即发送
	 */
	@ApiModelProperty(value = "sendImmediately")
	private boolean sendImmediately = true;


}
