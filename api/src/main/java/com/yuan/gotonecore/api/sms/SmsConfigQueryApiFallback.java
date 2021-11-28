package com.yuan.gotonecore.api.sms;

import com.yuan.gotonecore.api.sms.model.SmsConfig;
import com.yuan.gotonecore.api.sms.request.SmsConfigQueryRequest;
import com.yuan.gotonecore.api.sms.result.SmsConfigPageQueryResult;
import org.springframework.stereotype.Component;

import com.bench.common.model.JsonResult;
import com.yuan.gotonecore.api.sms.request.SmsConfigUpdateRequest;
import com.yuan.gotonecore.api.sms.request.SmsConfigUpdateSendChannelsRequest;
import com.yuan.gotonecore.api.sms.result.SmsConfigOperateResult;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 短信验证码校验
 * 
 * @author cold
 *
 * @version $Id: SmsAckCodeValidateApiFallback.java, v 0.1 2017年2月23日 下午3:14:05 cold Exp $
 */
@Component
@Slf4j
public class SmsConfigQueryApiFallback implements FallbackFactory<SmsConfigQueryApi> {

	/**
	 * 验证短信校验码
	 * 
	 * @param cause
	 * @return
	 */
	@Override
	public SmsConfigQueryApi create(Throwable cause) {

		return new SmsConfigQueryApi() {

			@Override
			public JsonResult<SmsConfigPageQueryResult> search(SmsConfigQueryRequest searchRequest) {
				log.error("rpcError,method:search,request:{}", searchRequest, cause);
				return JsonResult.rpcError("调用search接口异常");
			}

			@Override
			public JsonResult<SmsConfig> getById(long id) {
				log.error("rpcError,method:search,getById:{}", id, cause);
				return JsonResult.rpcError("调用search接口异常");
			}

			@Override
			public JsonResult<Long> getIntervalSeconds(String smsConfigName) {
				log.error("rpcError,method:search,getIntervalSeconds:{}", smsConfigName, cause);
				return JsonResult.rpcError("调用getIntervalSeconds接口异常");
			}

			@Override
			public JsonResult<SmsConfig> getByConfigName(String configName) {
				log.error("rpcError,method:search,getByConfigName:{}", configName, cause);
				return JsonResult.rpcError("调用getByConfigName接口异常");
			}

			@Override
			public JsonResult<SmsConfig> getCachedByConfigName(String configName) {
				log.error("rpcError,method:search,getCachedByConfigName:{}", configName, cause);
				return JsonResult.rpcError("调用getCachedByConfigName接口异常");			}

			@Override
			public JsonResult<SmsConfig> getCachedById(long id) {
				log.error("rpcError,method:search,getCachedById:{}", id, cause);
				return JsonResult.rpcError("调用getCachedById接口异常");						}

			@Override
			public JsonResult<List<SmsConfig>> getCachedByIds(List<Long> ids) {
				log.error("rpcError,method:search,getCachedByIds:{}", ids, cause);
				return JsonResult.rpcError("调用getCachedByIds接口异常");
			}
		};
	}

}
