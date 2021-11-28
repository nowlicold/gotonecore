/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.api.sms.model.enums;


import com.bench.common.enums.EnumBase;

/**
 * 短信发送通道枚举
 *
 * @author cold
 * @version $Id: SmsChannleEnum, v 0.1 2011-9-28 下午05:56:15 cold Exp $
 */
public enum SmsChannelEnum implements EnumBase {

    NOOP("无操作"),

    OFFICE2("第二办公室"),

    ZJ165("浙江联通"),

    CHANG_TIAN_YOU("畅天游"),

    CHANNEL_GOTONE_APP("通道gotone app"),

    CLIENT("客户端"),

    TAOBAO("淘宝阿里百川"),

    AGAN("AGAN"),

    AGAN2("AGAN第2通道"),

    ALIDAYU("阿里大于"),

    ALIDAYU2("阿里大于第2通道"),

    BENCH_SMS_CLIENT("bench短信客户端"),

    TENCENT_CLOUD_NORMAL_TEXT("腾讯云普通文本短信"),

    TENCENT_CLOUD_MARKET_TEXT("腾讯云营销文本短信"),

    TENCENT_CLOUD_ACK_CODE_VOICE("腾讯云验证码类语音"),

    XIANGXUN("享讯"),

    SHIYUAN("示远发送通道"),

    TENCENT_CLOUD_NOTICE_VOICE("腾讯云通知类语音");

    private String message;

    private SmsChannelEnum(String message) {
        this.message = message;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.bench.common.enums.EnumBase#message()
     */
    public String message() {
        // TODO Auto-generated method stub
        return message;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.bench.common.enums.EnumBase#value()
     */
    public Number value() {
        // TODO Auto-generated method stub
        return null;
    }

}
