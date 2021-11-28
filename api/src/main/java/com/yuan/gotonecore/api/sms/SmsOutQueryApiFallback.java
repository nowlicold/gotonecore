package com.yuan.gotonecore.api.sms;

import java.util.List;

import com.yuan.gotonecore.api.sms.model.SmsOut;
import com.yuan.gotonecore.api.sms.request.SmsOutQueryRequest;
import com.yuan.gotonecore.api.sms.result.SmsOutQueryResult;
import org.springframework.stereotype.Component;

import com.bench.common.model.JsonResult;
import com.yuan.gotonecore.api.sms.model.SmsConfig;
import com.yuan.gotonecore.api.sms.request.SmsConfigQueryRequest;
import com.yuan.gotonecore.api.sms.result.SmsConfigPageQueryResult;

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
public class SmsOutQueryApiFallback implements FallbackFactory<SmsOutQueryApi> {

	/**
	 * 验证短信校验码
	 * 
	 * @param cause
	 * @return
	 */
	@Override
	public SmsOutQueryApi create(Throwable cause) {

		return new SmsOutQueryApi() {


			@Override
			public JsonResult<SmsOutQueryResult> search(SmsOutQueryRequest request) {
				log.error("rpcError,method:search,search:{}", request, cause);
				return JsonResult.rpcError("调用search接口异常");
			}

			@Override
			public JsonResult<SmsOut> queryById(long id) {
				log.error("rpcError,method:search,queryById:{}", id, cause);
				return JsonResult.rpcError("调用queryById接口异常");			}
		};
	}

}
