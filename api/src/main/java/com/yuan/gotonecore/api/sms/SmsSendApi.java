package com.yuan.gotonecore.api.sms;

import com.bench.common.model.JsonResult;
import com.yuan.gotonecore.api.sms.request.SmsBatchSendRequest;
import com.yuan.gotonecore.api.sms.request.SmsResendRequest;
import com.yuan.gotonecore.api.sms.request.SmsSendRequest;
import com.yuan.gotonecore.api.sms.result.SmsSendResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 短信发送
 * 
 * @author cold
 *
 * @version $Id: SmsSendFacade.java, v 0.1 2017年2月23日 下午2:39:45 cold Exp $
 */
@FeignClient(
		value = "smsSendApi",
		url = "${rpc.gotonecore.url}",
		fallbackFactory = SmsSendApiFallback.class
)
public interface SmsSendApi {

	/**
	 * 发送短信，注意，这个是提交到短信发送队列的，由调度进行发送，不是立即发送的
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping("/private/sms/smsSendApi/send")
	public JsonResult<SmsSendResult> send(SmsSendRequest request);

	/**
	 * 重新发送已有的短信
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping("/private/sms/smsSendApi/resend")
	public JsonResult<SmsSendResult> resend(SmsResendRequest request);

	/**
	 * 短信批量发送
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping("/private/sms/smsSendApi/batchSend")
	public JsonResult<SmsSendResult> batchSend(SmsBatchSendRequest request);

}
