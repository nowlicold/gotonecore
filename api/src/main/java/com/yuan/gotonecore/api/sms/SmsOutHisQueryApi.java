/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.api.sms;

import com.bench.common.model.JsonResult;
import com.yuan.gotonecore.api.sms.model.SmsOutHis;
import com.yuan.gotonecore.api.sms.request.SmsOutHisQueryRequest;
import com.yuan.gotonecore.api.sms.result.SmsOutHisQueryResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * 短信已发送历史查询facade
 * 
 * @author cold
 *
 * @version $Id: SmsOutHisQueryFacade.java, v 0.1 2017年2月28日 上午11:06:04
 *          Administrator Exp $
 */
@FeignClient(
		value = "smsOutHisQueryApi",
		url = "${rpc.gotonecore.url}",
		fallbackFactory = SmsOutHisQueryApiFallback.class
)
public interface SmsOutHisQueryApi {
	/**
	 * 根据条件查询短信息历史发送记录
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping("/private/sms/smsOutHisQueryApi/search")
	JsonResult<SmsOutHisQueryResult> search(SmsOutHisQueryRequest request);

	/**
	 * 根据ID查询短信历史数据
	 * 
	 * @param id
	 * @return
	 */
	@PostMapping("/private/sms/smsOutHisQueryApi/queryById")
	JsonResult<SmsOutHis> queryById(long id);

	/**
	 * 根据用户号查询，根据成功发送时间倒叙
	 * 
	 * @param userId
	 * @return
	 */
	@PostMapping("/private/sms/smsOutHisQueryApi/queryByUserId")
	JsonResult<List<SmsOutHis>> queryByUserId(String userId);

	/**
	 * 根据ID查询短信历史数据
	 * 
	 * @param ids
	 * @return
	 */
	@PostMapping("/private/sms/smsOutHisQueryApi/queryByIds")
	JsonResult<List<SmsOutHis>> queryByIds(List<Long> ids);
}
