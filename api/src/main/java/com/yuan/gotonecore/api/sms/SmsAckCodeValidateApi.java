package com.yuan.gotonecore.api.sms;

import com.bench.common.model.JsonResult;
import com.yuan.gotonecore.api.sms.request.SmsAckCodeValidateRequest;
import com.yuan.gotonecore.api.sms.result.SmsAckCodeValidateResult;
import com.yuan.gotonecore.api.user.UserQueryApiFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 短信验证码校验
 * 
 * @author cold
 *
 * @version $Id: SmsAckCodeValidateApi.java, v 0.1 2017年2月23日 下午3:14:05
 *          cold Exp $
 */
@FeignClient(
		value = "smsAckCodeValidateApi",
		url = "${rpc.gotonecore.url}",
		fallbackFactory = SmsAckCodeValidateApiFallback.class
)
public interface SmsAckCodeValidateApi {

	/**
	 * 验证短信校验码
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping("/private/sms/smsAckCodeValidateApi/validateAckCode")
	public JsonResult<SmsAckCodeValidateResult> validateAckCode(SmsAckCodeValidateRequest request);

}
