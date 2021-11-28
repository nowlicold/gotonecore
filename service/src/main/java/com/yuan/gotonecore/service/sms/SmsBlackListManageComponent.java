package com.yuan.gotonecore.service.sms;

import com.yuan.gotonecore.api.sms.request.SmsBlackListCreateRequest;
import com.yuan.gotonecore.api.sms.result.SmsBlackListOperateResult;

/**
 * 短信黑名单管理组件
 *
 * @author cold
 * @version : SmsBlackListManageComponent, v 0.1 2019/5/16 0016 16:00 cold Exp $$
 */
public interface SmsBlackListManageComponent {


    /**
     * 创建短信黑名单
     *
     * @param request
     * @return
     */
    public SmsBlackListOperateResult create(SmsBlackListCreateRequest request);

    /**
     * 移除黑名单
     *
     * @param id
     * @return
     */
    public SmsBlackListOperateResult remove(String id);
}
