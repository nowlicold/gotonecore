package com.yuan.gotonecore.api.mail;

import com.bench.common.model.JsonResult;
import com.yuan.gotonecore.api.request.MailSendRequest;
import com.yuan.gotonecore.api.result.GotoneCoreServiceResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @className SendMailServiceApi
 * @autor cold
 * @DATE 2021-11-26 22:30
 **/
@FeignClient(
        value = "sendMailServiceApi",
        url = "${rpc.gotonecore.url}",
        fallbackFactory = SendMailServiceApiFallback.class
)
public interface SendMailServiceApi {
    @PostMapping("/private/mail/sendMailServiceApi/doMailSend")
   JsonResult<GotoneCoreServiceResult> doMailSend(MailSendRequest request);
}
