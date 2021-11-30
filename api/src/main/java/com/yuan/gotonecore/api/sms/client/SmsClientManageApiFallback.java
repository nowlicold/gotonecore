package com.yuan.gotonecore.api.sms.client;

import com.yuan.gotonecore.api.sms.client.request.SmsClienLoginRequest;
import com.yuan.gotonecore.api.sms.client.result.SmsClienLoginResult;
import org.springframework.stereotype.Component;

import com.bench.common.model.JsonResult;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * @className SmsClientManageApiFallback
 * @autor cold
 * @DATE 2021/5/9 15:21
 **/
@Component
@Slf4j
public class SmsClientManageApiFallback implements FallbackFactory<SmsClientManageApi> {
    @Override
    public SmsClientManageApi create(Throwable cause) {

        return new SmsClientManageApi() {
            @Override
            public JsonResult<SmsClienLoginResult> login(SmsClienLoginRequest request) {
                log.error("rpcError,method:login,request:{}", request);
                return JsonResult.rpcError("调用login接口异常");
            }
        };
    }
}
