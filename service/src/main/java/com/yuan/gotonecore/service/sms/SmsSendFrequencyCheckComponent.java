package com.yuan.gotonecore.service.sms;


import com.yuan.gotonecore.service.sms.request.SmsSendFrequencyCheckRequest;
import com.yuan.gotonecore.service.sms.result.SmsSendFrequencyCheckResult;

/**
 * 短信发送频率咨询组件
 *
 * @author cold
 * @version : SmsSendFrequencyValidateComponent, v 0.1 2019/5/16 0016 16:21 cold Exp $$
 */
public interface SmsSendFrequencyCheckComponent {

    /**
     * 检查，目前只检查ip，如果配置没加，ip没传，则不判断，后面等所有依赖系统改完后改成必须传
     *
     * @param request
     * @return
     */
    public SmsSendFrequencyCheckResult check(SmsSendFrequencyCheckRequest request);
}
