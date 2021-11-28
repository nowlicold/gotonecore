/**
 * 
 */
package com.yuan.gotonecore.api.sms;

import com.bench.common.model.JsonResult;
import com.yuan.gotonecore.api.sms.request.SmsConfigUpdateRequest;
import com.yuan.gotonecore.api.sms.request.SmsConfigUpdateSendChannelsRequest;
import com.yuan.gotonecore.api.sms.result.SmsConfigOperateResult;
import com.yuan.gotonecore.api.user.UserQueryApiFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 消息配置管理组件
 * 
 * @author cold
 *
 * @version $Id: SmsConfigManageFacade.java, v 0.1 2016年8月24日 下午5:01:06 Admin
 *          Exp $
 */
@FeignClient(
		value = "smsConfigManageApi",
		url = "${rpc.gotonecore.url}",
		fallbackFactory = SmsConfigManageApiFallback.class
)
public interface SmsConfigManageApi {

	/**
	 * 根据ids修改发送通道
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping("/private/sms/smsConfigManageApi/updateSendChannelsByIds")
	public JsonResult<SmsConfigOperateResult> updateSendChannelsByIds(SmsConfigUpdateSendChannelsRequest request);

	/**
	 * 根据id修改短信配置
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping("/private/sms/smsConfigManageApi/updateById")
	public JsonResult<SmsConfigOperateResult> updateById(SmsConfigUpdateRequest request);

}
