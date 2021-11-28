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
 * @version $Id: SmsSendAppServiceResponse.java, v 0.1 2015年10月23日 下午3:59:36
 *          Administrator Exp $
 */
@Data
public class SmsSendAppServiceResult extends AbstractAppServiceResult {

	@ApiModelProperty(value = "发送的短信字符串ID，如果暴露到前台，必须使用该id")
	private String smsId;

	/**
	 * 如果错误代码是SMS_SEND_DUPLICATE_IN_INTERVAL_SECONDS，则这里放置用户还需要等待多久（秒），<br>
	 * 如果是成功，这里放置下次发送的间隔时间
	 */
	@ApiModelProperty(value = "如果错误代码是SMS_SEND_DUPLICATE_IN_INTERVAL_SECONDS，则这里放置用户还需要等待多久（秒），<br>\n" +
			"如果是成功，这里放置下次发送的间隔时间")
	private long waitNextPrepareSeconds;

	/**
	 * @return Returns the smsId.
	 */

}
