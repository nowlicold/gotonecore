package com.yuan.gotonecore.api.sms.client;

import com.bench.common.model.JsonResult;
import com.yuan.gotonecore.api.sms.model.client.SmsClient;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 
 * 
 * @author cold
 *
 * @version $Id: SmsClientQueryFacade.java, v 0.1 2017年2月22日 下午3:21:37 cold
 *          Exp $
 */
@FeignClient(
		value = "smsClientQueryApi",
		url = "${rpc.gotonecore.url}",
		fallbackFactory = SmsClientQueryApiFallback.class
)
public interface SmsClientQueryApi {

	/**
	 * 根据客户端号查询
	 * 
	 * @param clientNo
	 * @return
	 */
	public JsonResult<SmsClient> getByClientNo(String clientNo);
}
