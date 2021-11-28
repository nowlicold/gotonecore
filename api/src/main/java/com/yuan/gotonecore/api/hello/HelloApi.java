package com.yuan.gotonecore.api.hello;

import javax.validation.Valid;

import com.yuan.gotonecore.api.hello.request.SayHelloRequest;
import com.bench.common.model.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author by cold
 * @date 2020/12/15
 */
@FeignClient(name = "helloApi", url = "${rpc.gotonecore.url}", fallbackFactory = HelloApiFallback.class)
public interface HelloApi {

    /**
     * 打个招呼
     *
     * @param request 打招呼请求
     * @return 回应
     */
    JsonResult<String> sayHello(@Valid @RequestBody SayHelloRequest request);
}
