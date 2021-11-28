package com.yuan.gotonecore.api.sms.client;

import com.bench.common.model.JsonResult;
import com.yuan.gotonecore.api.sms.client.request.SmsClientSendResultUpdateRequest;
import com.yuan.gotonecore.api.sms.client.result.SmsClientSendGiveupResult;
import com.yuan.gotonecore.api.sms.client.result.SmsClientSendResultUpdateResult;
import com.yuan.gotonecore.api.sms.client.result.SmsClientSendResumeResult;
import com.yuan.gotonecore.api.sms.model.client.SmsClientSend;

import java.util.List;


/**
 * 短信客户端发送管理
 * 
 * @author cold
 *
 * @version $Id: SmsClientSendManageApi.java, v 0.1 2017年2月22日 下午3:24:01
 *          cold Exp $
 */
public interface SmsClientSendManageApi {

	/**
	 * 客户端申请发送
	 * 
	 * @param clientNo
	 * @param applyBatchId
	 * @param applyCount
	 * @return
	 */
	public JsonResult<List<SmsClientSend>> applySend(String clientNo, long applyBatchId, int applyCount);

	/**
	 * 放弃短信发送
	 * 
	 * @param clientNo
	 * @param smsClientSendIds
	 * @return
	 */
	public JsonResult<SmsClientSendGiveupResult> giveupSendApply(String clientNo, List<Long> smsClientSendIds);

	/**
	 * 申请发送异常恢复
	 * 
	 * @param clientNo
	 * @param applyBatchId
	 * @return
	 */
	public JsonResult<SmsClientSendResumeResult> resumeApplySend(String clientNo, long applyBatchId);

	/**
	 * 客户端申请发送
	 * 
	 * @param reqwuest
	 * @return
	 */
	public JsonResult<SmsClientSendResultUpdateResult> updateSendResult(SmsClientSendResultUpdateRequest request);

}
