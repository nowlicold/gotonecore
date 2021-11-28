package com.yuan.gotonecore.api.hello;

import javax.validation.Valid;

import com.yuan.gotonecore.api.hello.request.SayHelloRequest;
import com.bench.common.model.JsonResult;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author by cold
 * @date 2020/12/15
 */
@Slf4j
@Component
public class HelloApiFallback implements FallbackFactory<HelloApi> {
    @Override
    public HelloApi create(Throwable throwable) {
        return new HelloApi() {
            @Override
            public JsonResult<String> sayHello(@Valid SayHelloRequest request) {
                log.error("rpcError,method:sayHello,request:{}", request, throwable);
                return JsonResult.rpcError("调用打招呼接口异常");
            }
        };
    }
}
