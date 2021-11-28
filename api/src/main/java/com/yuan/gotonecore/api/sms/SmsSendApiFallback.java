package com.yuan.gotonecore.api.sms;

import com.yuan.gotonecore.api.sms.request.SmsBatchSendRequest;
import com.yuan.gotonecore.api.sms.request.SmsResendRequest;
import com.yuan.gotonecore.api.sms.request.SmsSendRequest;
import com.yuan.gotonecore.api.sms.result.SmsSendResult;
import org.springframework.stereotype.Component;

import com.bench.common.model.JsonResult;
import com.yuan.gotonecore.api.sms.model.SmsOut;
import com.yuan.gotonecore.api.sms.request.SmsOutQueryRequest;
import com.yuan.gotonecore.api.sms.result.SmsOutQueryResult;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * 短信验证码校验
 * 
 * @author cold
 *
 * @version $Id: SmsOutQueryApiFallback.java, v 0.1 2017年2月23日 下午3:14:05 cold Exp $
 */
@Component
@Slf4j
public class SmsSendApiFallback implements FallbackFactory<SmsSendApi> {

	/**
	 * 验证短信校验码
	 * 
	 * @param cause
	 * @return
	 */
	@Override
	public SmsSendApi create(Throwable cause) {

		return new SmsSendApi() {


			@Override
			public JsonResult<SmsSendResult> send(SmsSendRequest request) {
				log.error("rpcError,method:send,send:{}", request, cause);
				return JsonResult.rpcError("调用send接口异常");
			}

			@Override
			public JsonResult<SmsSendResult> resend(SmsResendRequest request) {
				log.error("rpcError,method:resend,resend:{}", request, cause);
				return JsonResult.rpcError("调用resend接口异常");
			}

			@Override
			public JsonResult<SmsSendResult> batchSend(SmsBatchSendRequest request) {
				log.error("rpcError,method:batchSend,batchSend:{}", request, cause);
				return JsonResult.rpcError("调用batchSend接口异常");
			}
		};
	}

}
