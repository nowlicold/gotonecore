package com.yuan.gotonecore.api.sms;

import com.yuan.gotonecore.api.sms.request.SmsConfigUpdateRequest;
import com.yuan.gotonecore.api.sms.request.SmsConfigUpdateSendChannelsRequest;
import com.yuan.gotonecore.api.sms.result.SmsConfigOperateResult;
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
public class SmsConfigManageApiFallback implements FallbackFactory<SmsConfigManageApi> {

	/**
	 * 验证短信校验码
	 * 
	 * @param cause
	 * @return
	 */
	@Override
	public SmsConfigManageApi create(Throwable cause) {

		return new SmsConfigManageApi() {

			@Override
			public JsonResult<SmsConfigOperateResult> updateSendChannelsByIds(SmsConfigUpdateSendChannelsRequest request) {
				log.error("rpcError,method:updateSendChannelsByIds,request:{}", request);
				return JsonResult.rpcError("调用updateSendChannelsByIds接口异常");
			}

			@Override
			public JsonResult<SmsConfigOperateResult> updateById(SmsConfigUpdateRequest request) {
				log.error("rpcError,method:updateById,request:{}", request);
				return JsonResult.rpcError("调用updateById接口异常");
			}
		};
	}

}
