/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.api.sms.model;

import com.bench.lang.base.object.ToStringObject;
import com.yuan.gotonecore.api.model.enums.MessageStatusEnum;
import com.yuan.gotonecore.api.sms.model.enums.SmsChannelEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.Map;

/**
 * 
 * 
 * @author cold
 *
 * @version $Id: SmsOut.java, v 0.1 2017年2月22日 下午2:56:51 cold Exp $
 */
@Data
public class SmsOut extends ToStringObject {

	/**
	 * 主键
	 */
	@ApiModelProperty(value = "主键")
	private long id;

	/**
	 * 接受人手机号
	 */
	@ApiModelProperty(value = "接受人手机号")
	private String receiver;

	/**
	 * 用户ID
	 */
	@ApiModelProperty(value = "用户ID")
	private String userId;

	/**
	 * 内容
	 */
	@ApiModelProperty(value = "内容")
	private String content;

	/**
	 * 状态
	 */
	@ApiModelProperty(value = "状态")
	private MessageStatusEnum status;

	/**
	 * 下次重发时间
	 */
	@ApiModelProperty(value = "下次重发时间")
	private Date gmtResend;

	/**
	 * 发送次数
	 */
	@ApiModelProperty(value = "发送次数")
	private int sendTimes;

	/**
	 * 修改时间
	 */
	@ApiModelProperty(value = "修改时间")
	private Date gmtModified;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
	private Date gmtCreate;

	/**
	 * 短信模版配置ID
	 */
	@ApiModelProperty(value = "短信模版配置ID")
	private long smsConfigId;

	/**
	 * 消息属性
	 */
	@ApiModelProperty(value = "消息属性")
	private Map<String, String> properties;

	/**
	 * 消息模板参数
	 */
	@ApiModelProperty(value = "消息模板参数")
	private Map<String, String> templateArgs;

	/**
	 * 唯一业务号
	 */
	@ApiModelProperty(value = "唯一业务号")
	private String bizId;

	/**
	 * 效验码
	 */
	@ApiModelProperty(value = "效验码")
	private String ackCode;
	/**
	 * 发送结果
	 */
	@ApiModelProperty(value = "发送结果")
	private String sendResult;

	/**
	 * 发送通道
	 */
	@ApiModelProperty(value = "发送通道")
	private SmsChannelEnum sendChannel;

	/**
	 * 发送通道是否已指定，如果已指定，则不需要再次自动选择
	 */
	@ApiModelProperty(value = "发送通道是否已指定，如果已指定，则不需要再次自动选择")
	private boolean sendChannelSpecified;

	/**
	 * 如果是重发短信，这里记录重发哪条短信
	 */
	@ApiModelProperty(value = "如果是重发短信，这里记录重发哪条短信")
	private long resendFromSmsId;

}
