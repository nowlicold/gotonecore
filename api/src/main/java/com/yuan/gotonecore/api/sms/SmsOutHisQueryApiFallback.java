package com.yuan.gotonecore.api.sms;

import java.util.List;

import com.yuan.gotonecore.api.sms.model.SmsOutHis;
import com.yuan.gotonecore.api.sms.request.SmsOutHisQueryRequest;
import com.yuan.gotonecore.api.sms.result.SmsOutHisQueryResult;
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
 * @version $Id: SmsAckCodeValidateApiFallback.java, v 0.1 2017年2月23日 下午3:14:05 cold Exp $
 */
@Component
@Slf4j
public class SmsOutHisQueryApiFallback implements FallbackFactory<SmsOutHisQueryApi> {

	/**
	 * 验证短信校验码
	 * 
	 * @param cause
	 * @return
	 */
	@Override
	public SmsOutHisQueryApi create(Throwable cause) {

		return new SmsOutHisQueryApi() {


			@Override
			public JsonResult<SmsOutHisQueryResult> search(SmsOutHisQueryRequest request) {
				log.error("rpcError,method:search,request:{}", request, cause);
				return JsonResult.rpcError("调用request接口异常");
			}

			@Override
			public JsonResult<SmsOutHis> queryById(long id) {
				log.error("rpcError,method:queryById,id:{}", id, cause);
				return JsonResult.rpcError("调用queryById接口异常");
			}

			@Override
			public JsonResult<List<SmsOutHis>> queryByUserId(String userId) {
				log.error("rpcError,method:queryByUserId,id:{}", userId, cause);
				return JsonResult.rpcError("调用queryByUserId接口异常");
			}

			@Override
			public JsonResult<List<SmsOutHis>> queryByIds(List<Long> ids) {
				log.error("rpcError,method:queryByIds,id:{}", ids, cause);
				return JsonResult.rpcError("调用queryByUserId接口异常");
			}
		};
	}

}
