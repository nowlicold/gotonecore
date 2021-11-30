/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.api.sms;

import com.bench.common.model.JsonResult;
import com.yuan.gotonecore.api.sms.request.SmsAckCodeValidateRequest;
import com.yuan.gotonecore.api.sms.result.SmsAckCodeValidateResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * SMS消息发送门面
 * 
 * @author cold
 *
 * @version $Id: SmsFacade.java, v 0.1 2017年2月27日 下午3:01:12 Administrator Exp $
 */
@FeignClient(
		value = "smsApi",
		url = "${rpc.gotonecore.url}",
		fallbackFactory = SmsApiFallback.class
)
public interface SmsApi {

	/**
	 * 验证短信校验码
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping("/private/sms/smsAckCodeValidateApi/validateAckCode")
	public JsonResult<SmsAckCodeValidateResult> validateAckCode(SmsAckCodeValidateRequest request);
}
