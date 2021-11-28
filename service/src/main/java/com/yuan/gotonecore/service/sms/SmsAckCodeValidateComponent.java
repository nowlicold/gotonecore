package com.yuan.gotonecore.service.sms;

import com.yuan.gotonecore.api.sms.request.SmsAckCodeValidateRequest;
import com.yuan.gotonecore.api.sms.result.SmsAckCodeValidateResult;

/**
 * @className SmsAckCodeValidateComponent
 * @autor cold
 * @DATE 2021/6/19 23:59
 **/
public interface SmsAckCodeValidateComponent {

    public SmsAckCodeValidateResult validateAckCode(SmsAckCodeValidateRequest request);

}
