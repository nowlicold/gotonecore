/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.api.sms.result;



import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 短信验证码验证结果
 * 
 * @author cold
 *
 * @version $Id: SmsAckCodeValidateResult.java, v 0.1 2017年2月24日 上午10:54:55
 *          Administrator Exp $
 */
@Data
public class SmsAckCodeValidateResult extends SmsResult {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4990251320609821761L;

	/**
	 * 最大允许验证次数
	 */
	@ApiModelProperty(value = "最大允许验证次数")
	private int maxAllowedValidateCount;

	/**
	 * 当前已验证次数
	 */
	@ApiModelProperty(value = "当前已验证次数")
	private int currentValidateCount;

	/**
	 * 下次能重新获取的时间间隔
	 */
	@ApiModelProperty(value = "下次能重新获取的时间间隔")
	private long waitNextPrepareSeconds;


}
