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
 * @version $Id: SmsSendSimpleAppServiceResponse.java, v 0.1 2015年10月23日
 *          下午3:59:36 Administrator Exp $
 */
@Data
public class SmsSendSimpleAppServiceResult extends AbstractAppServiceResult {

	/**
	 * 发送的短信字符串ID
	 */
	@ApiModelProperty(value = "发送的短信字符串ID")
	private String smsId;

}
