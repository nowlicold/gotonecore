package com.yuan.gotonecore.api.sms.client;

import com.yuan.gotonecore.api.sms.client.request.SmsClientSendResultUpdateRequest;
import com.yuan.gotonecore.api.sms.client.result.SmsClientSendGiveupResult;
import com.yuan.gotonecore.api.sms.client.result.SmsClientSendResultUpdateResult;
import com.yuan.gotonecore.api.sms.client.result.SmsClientSendResumeResult;
import com.yuan.gotonecore.api.sms.model.client.SmsClientSend;
import org.springframework.stereotype.Component;

import com.bench.common.model.JsonResult;
import com.yuan.gotonecore.api.sms.model.client.SmsClient;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @className SmsClientSendManageApiFallback
 * @autor cold
 * @DATE 2021/5/9 15:21
 **/
@Component
@Slf4j
public class SmsClientSendManageApiFallback implements FallbackFactory<SmsClientSendManageApi> {
    @Override
    public SmsClientSendManageApi create(Throwable throwable) {

        return new SmsClientSendManageApi() {

            @Override
            public JsonResult<List<SmsClientSend>> applySend(String clientNo, long applyBatchId, int applyCount) {
                log.error("rpcError,method:applySend,param:{}", clientNo,applyBatchId,applyCount,throwable);
                return JsonResult.rpcError("调用applySend接口异常");
            }

            @Override
            public JsonResult<SmsClientSendGiveupResult> giveupSendApply(String clientNo, List<Long> smsClientSendIds) {
                log.error("rpcError,method:giveupSendApply,param:{}", clientNo,smsClientSendIds,throwable);
                return JsonResult.rpcError("调用giveupSendApply接口异常");
            }

            @Override
            public JsonResult<SmsClientSendResumeResult> resumeApplySend(String clientNo, long applyBatchId) {
                log.error("rpcError,method:resumeApplySend,param:{}", clientNo,applyBatchId,throwable);
                return JsonResult.rpcError("调用resumeApplySend接口异常");
            }

            @Override
            public JsonResult<SmsClientSendResultUpdateResult> updateSendResult(SmsClientSendResultUpdateRequest request) {
                log.error("rpcError,method:updateSendResult,param:{}", request,throwable);
                return JsonResult.rpcError("调用updateSendResult接口异常");            }
        };
    }
}
