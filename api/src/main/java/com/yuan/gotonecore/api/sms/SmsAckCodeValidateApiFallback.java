package com.yuan.gotonecore.api.sms;

import com.bench.common.model.JsonResult;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import com.yuan.gotonecore.api.sms.request.SmsAckCodeValidateRequest;
import com.yuan.gotonecore.api.sms.result.SmsAckCodeValidateResult;
import org.springframework.stereotype.Component;

/**
 * 短信验证码校验
 * 
 * @author cold
 *
 * @version $Id: SmsAckCodeValidateApiFallback.java, v 0.1 2017年2月23日 下午3:14:05
 *          cold Exp $
 */
@Component
@Slf4j
public class SmsAckCodeValidateApiFallback implements FallbackFactory<SmsAckCodeValidateApi> {

	/**
	 * 验证短信校验码
	 * 
	 * @param cause
	 * @return
	 */
	@Override
	public SmsAckCodeValidateApi create(Throwable cause) {

		return new SmsAckCodeValidateApi() {

			@Override
			public JsonResult<SmsAckCodeValidateResult> validateAckCode(SmsAckCodeValidateRequest request) {
				log.error("rpcError,method:validateAckCode,request:{}", request,cause);
				return JsonResult.rpcError("调用SmsAckCodeValidateApiFallback.validateAckCode接口异常");
			}

		};
	}

}
