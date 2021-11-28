package com.yuan.gotonecore.api.sms;

import org.springframework.stereotype.Component;

import com.bench.common.model.JsonResult;
import com.yuan.gotonecore.api.sms.request.SmsAckCodeValidateRequest;
import com.yuan.gotonecore.api.sms.result.SmsAckCodeValidateResult;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

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
public class SmsApiFallback implements FallbackFactory<SmsApi> {

	/**
	 * 验证短信校验码
	 * 
	 * @param cause
	 * @return
	 */
	@Override
	public SmsApi create(Throwable cause) {

		return new SmsApi() {
			@Override
			public JsonResult<SmsAckCodeValidateResult> validateAckCode(SmsAckCodeValidateRequest request) {
				log.error("rpcError,method:validateAckCode,request:{}", request,cause);
				return JsonResult.rpcError("调用validateAckCode接口异常");				}
		};
	}

}
