package com.yuan.gotonecore.api.sms;

import java.util.List;

import com.bench.common.model.JsonResult;
import com.yuan.gotonecore.api.sms.model.SmsConfig;
import com.yuan.gotonecore.api.sms.request.SmsConfigQueryRequest;
import com.yuan.gotonecore.api.sms.result.SmsConfigPageQueryResult;
import com.yuan.gotonecore.api.user.UserQueryApiFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 查询短信配置
 * 
 * @author cold
 *
 * @version $Id: SmsConfigQueryFacade.java, v 0.1 2015年6月15日 下午4:26:13 cold
 *          Exp $
 */
@FeignClient(
		value = "smsConfigQueryApi",
		url = "${rpc.gotonecore.url}",
		fallbackFactory = SmsConfigQueryApiFallback.class
)
public interface SmsConfigQueryApi {
	/**
	 * 查询短信配置
	 * 
	 * @param searchRequest
	 * @return
	 */
	@PostMapping("/private/sms/smsConfigQueryApi/search")
	public JsonResult<SmsConfigPageQueryResult> search(SmsConfigQueryRequest searchRequest);

	/**
	 * 根据id获取短信配置
	 * 
	 * @param id
	 * @return
	 */
	@PostMapping("/private/sms/smsConfigQueryApi/getById")
	public JsonResult<SmsConfig> getById(long id);

	/**
	 * 根据短信配置名获取间隔发送时间，如果无法找到，则返回-1
	 * 
	 * @param smsConfigName
	 * @return
	 */
	@PostMapping("/private/sms/smsConfigQueryApi/getIntervalSeconds")
	public JsonResult<Long> getIntervalSeconds(String smsConfigName);

	/**
	 * 根据短信配置ID获取短信配置
	 * 
	 * @param configName
	 * @return
	 */
	@PostMapping("/private/sms/smsConfigQueryApi/getByConfigName")
	public JsonResult<SmsConfig> getByConfigName(String configName);

	/**
	 * 根据配置id，获取缓存的短信配置
	 * 
	 * @param configName
	 * @return
	 */
	@PostMapping("/private/sms/smsConfigQueryApi/getCachedByConfigName")
	public JsonResult<SmsConfig> getCachedByConfigName(String configName);

	/**
	 * 根据id，获取缓存的短信配置
	 * 
	 * @param id
	 * @return
	 */
	@PostMapping("/private/sms/smsConfigQueryApi/getCachedById")
	public JsonResult<SmsConfig> getCachedById(long id);

	/**
	 * 根据id，获取缓存的短信配置
	 * 
	 * @param ids
	 * @return
	 */
	@PostMapping("/private/sms/smsConfigQueryApi/getCachedByIds")
	public JsonResult<List<SmsConfig>> getCachedByIds(List<Long> ids);
}
