package com.yuan.gotonecore.api.sms.client;

import com.yuan.gotonecore.api.sms.model.client.SmsClient;
import org.springframework.stereotype.Component;

import com.bench.common.model.JsonResult;
import com.yuan.gotonecore.api.sms.client.request.SmsClienLoginRequest;
import com.yuan.gotonecore.api.sms.client.result.SmsClienLoginResult;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * @className SmsClientQueryApiFallback
 * @autor cold
 * @DATE 2021/5/9 15:21
 **/
@Component
@Slf4j
public class SmsClientQueryApiFallback implements FallbackFactory<SmsClientQueryApi> {
    @Override
    public SmsClientQueryApi create(Throwable cause) {

        return new SmsClientQueryApi() {

            @Override
            public JsonResult<SmsClient> getByClientNo(String clientNo) {
                log.error("rpcError,method:getByClientNo,clientNo:{}", clientNo);
                return JsonResult.rpcError("调用getByClientNo接口异常");            }
        };
    }
}
