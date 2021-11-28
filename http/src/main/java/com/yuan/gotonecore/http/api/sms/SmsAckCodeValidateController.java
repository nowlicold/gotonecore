package com.yuan.gotonecore.http.api.sms;

import com.yuan.gotonecore.api.sms.SmsAckCodeValidateApi;
import com.yuan.gotonecore.api.sms.request.SmsAckCodeValidateRequest;
import com.yuan.gotonecore.api.sms.result.SmsAckCodeValidateResult;
import com.yuan.gotonecore.service.sms.SmsAckCodeValidateComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bench.common.model.JsonResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * @className UserCreateController
 * @autor cold
 * @DATE 2021/5/24 10:51
 **/
@RestController
@Api(value = "验证码验证", tags = "验证码验证")
@Slf4j
public class SmsAckCodeValidateController implements SmsAckCodeValidateApi {
    @Autowired
    private SmsAckCodeValidateComponent smsAckCodeValidateComponent;

    @ApiOperation(value = "验证码验证")
    @Override
    public JsonResult<SmsAckCodeValidateResult> validateAckCode(SmsAckCodeValidateRequest request) {
        return JsonResult.success(smsAckCodeValidateComponent.validateAckCode(request));
    }
}
