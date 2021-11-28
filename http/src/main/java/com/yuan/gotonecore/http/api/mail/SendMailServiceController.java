package com.yuan.gotonecore.http.api.mail;

import com.bench.common.model.JsonResult;
import com.yuan.gotonecore.api.mail.SendMailServiceApi;
import com.yuan.gotonecore.api.request.MailSendRequest;
import com.yuan.gotonecore.api.result.GotoneCoreServiceResult;
import com.yuan.gotonecore.service.mail.SendMailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @className SendMailServiceController
 * @autor cold
 * @DATE 2021-11-26 22:38
 **/
@RestController
@Api(value = "发送邮件服务api", tags = "发送邮件服务api")
@Slf4j
public class SendMailServiceController implements SendMailServiceApi {
    @Autowired
    private SendMailService sendMailService;
    @ApiOperation(value = "发送邮件服务")
    @Override
    public JsonResult<GotoneCoreServiceResult> doMailSend(@RequestBody @Valid MailSendRequest request) {
        GotoneCoreServiceResult result = sendMailService.doMailSend(request);
        return JsonResult.success(result);
    }
}
