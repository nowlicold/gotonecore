package com.yuan.gotonecore.api.sms.client;


import com.bench.common.model.JsonResult;
import com.yuan.gotonecore.api.sms.client.request.SmsClienLoginRequest;
import com.yuan.gotonecore.api.sms.client.result.SmsClienLoginResult;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 
 * 
 * @author cold
 *
 * @version $Id: SmsClientManageApi.java, v 0.1 2017年2月22日 下午3:14:54 cold
 *          Exp $
 */
@FeignClient(
		value = "smsClientManageApi",
		url = "${rpc.gotonecore.url}",
		fallbackFactory = SmsClientManageApiFallback.class
)
public interface SmsClientManageApi {

	/**
	 * 短信客户端登陆
	 * 
	 * @param request
	 * @return
	 */
	public JsonResult<SmsClienLoginResult> login(SmsClienLoginRequest request);
}
