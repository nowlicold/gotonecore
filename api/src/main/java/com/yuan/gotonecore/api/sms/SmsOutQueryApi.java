/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.api.sms;

import com.bench.common.model.JsonResult;
import com.yuan.gotonecore.api.sms.model.SmsOut;
import com.yuan.gotonecore.api.sms.request.SmsOutQueryRequest;
import com.yuan.gotonecore.api.sms.result.SmsOutQueryResult;
import com.yuan.gotonecore.api.user.UserQueryApiFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 短信待发送查询facade
 * 
 * @author cold
 *
 * @version $Id: SmsOutQueryFacade.java, v 0.1 2017年2月27日 下午3:00:15
 *          Administrator Exp $
 */
@FeignClient(
		value = "smsOutQueryApi",
		url = "${rpc.gotonecore.url}",
		fallbackFactory =  SmsOutQueryApiFallback.class
)
public interface SmsOutQueryApi {

	/**
	 * 根据条件查询短消息发送数据
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping("/private/sms/smsOutQueryApi/search")
	JsonResult<SmsOutQueryResult> search(SmsOutQueryRequest request);

	/**
	 * 根据ID查询短信息
	 * 
	 * @param id
	 * @return
	 */
	@PostMapping("/private/sms/smsOutQueryApi/queryById")
	JsonResult<SmsOut> queryById(long id);
}
