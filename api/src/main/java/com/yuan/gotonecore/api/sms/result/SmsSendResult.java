package com.yuan.gotonecore.api.sms.result;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 短信发送结果
 * 
 * @author cold
 *
 * @version $Id: SmsSendResult.java, v 0.1 2017年2月24日 上午10:39:34 Administrator
 *          Exp $
 */
@Data
public class SmsSendResult extends SmsResult {


	/**
	 * 发送的短信字符串ID，如果暴露到前台，必须使用该id
	 */
	@ApiModelProperty("发送的短信字符串ID，如果暴露到前台，必须使用该id")
	private String smsId;

	/**
	 * 发送的短信数值id
	 */
	@ApiModelProperty("发送的短信数值id")
	private long id;

	/**
	 * 如果错误代码是SMS_SEND_DUPLICATE_IN_INTERVAL_SECONDS，则这里放置用户还需要等待多久（秒），<br>
	 * 如果是成功，这里放置下次发送的间隔时间
	 */
	@ApiModelProperty("如果错误代码是SMS_SEND_DUPLICATE_IN_INTERVAL_SECONDS，则这里放置用户还需要等待多久（秒），<br>\n" +
			"如果是成功，这里放置下次发送的间隔时间")
	private long waitNextPrepareSeconds;

}
