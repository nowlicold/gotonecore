/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.api.sms.app.result;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * @author cold
 *
 * @version $Id: SmsValidateAckAppServiceResponse.java, v 0.1 2015年10月23日
 *          下午3:59:36 Administrator Exp $
 */
@Data
public class SmsValidateAckAppServiceResult extends AbstractAppServiceResult {

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


}
