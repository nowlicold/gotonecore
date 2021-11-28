package com.yuan.gotonecore.service.sms.request;

import java.util.Date;

/**
 * 短信发送频率咨询请求
 *
 * @author cold
 * @version : SmsSendFrequencyCheckRequest, v 0.1 2019/5/16 0016 16:26 cold Exp $$
 */
public class SmsSendFrequencyCheckRequest  {

    /**
     * ip
     */
    private String ip;

    /**
     * 发送时间
     */
    private Date gmtSend;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getGmtSend() {
        return gmtSend;
    }

    public void setGmtSend(Date gmtSend) {
        this.gmtSend = gmtSend;
    }
}
