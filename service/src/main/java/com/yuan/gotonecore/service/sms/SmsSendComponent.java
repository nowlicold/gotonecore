/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.service.sms;

import com.yuan.gotonecore.api.sms.request.SmsBatchSendRequest;
import com.yuan.gotonecore.api.sms.request.SmsResendRequest;
import com.yuan.gotonecore.api.sms.request.SmsSendRequest;
import com.yuan.gotonecore.api.sms.result.SmsResult;
import com.yuan.gotonecore.api.sms.result.SmsSendResult;

/**
 * 短信发送component
 * 
 * @author cold
 *
 * @version $Id: SmsSendComponent.java, v 0.1 2017年2月23日 下午1:57:07 cold Exp $
 */
public interface SmsSendComponent {

	/**
	 * 准备发送短信，注意，这个是提交到短信发送队列的，由调度进行发送，不是立即发送的
	 * 
	 * @param request
	 * @return
	 */
	public SmsSendResult send(SmsSendRequest request);

	/**
	 * 准备发送短信，注意，这个是提交到短信发送队列的，由调度进行发送，不是立即发送的
	 * 
	 * @param smsId
	 * @return
	 */
	public SmsResult send(long smsId);

	/**
	 * 重新发送已有的短信
	 * 
	 * @param request
	 * @return
	 */
	public SmsSendResult resend(SmsResendRequest request);

	/**
	 * 批量发送
	 * 
	 * @param request
	 * @return
	 */
	public SmsSendResult batchSend(SmsBatchSendRequest request);


	public void ThredTest();

}
