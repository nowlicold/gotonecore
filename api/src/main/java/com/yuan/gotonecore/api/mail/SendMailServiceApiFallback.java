package com.yuan.gotonecore.api.mail;
import com.bench.common.model.JsonResult;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @className SendMailServiceApiFallback
 * @autor cold
 * @DATE 2021-11-26 22:30
 **/
@Component
@Slf4j
public class SendMailServiceApiFallback implements FallbackFactory<SendMailServiceApi> {
    @Override
    public SendMailServiceApi create(Throwable cause) {

        return request -> {
            log.error("rpcError,method:doMailSend,request:{}", request,cause);
            return JsonResult.rpcError("调用SendMailServiceApiFallback.doMailSend接口异常");
        };
    }
}
