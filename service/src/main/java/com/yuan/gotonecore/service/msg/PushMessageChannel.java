package com.yuan.gotonecore.service.msg;

import com.yuan.gotonecore.common.msg.MsgGotonecoreChannel;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @className PushMessageChannel
 * @autor cold
 * @DATE 2021-11-22 10:16
 **/
public interface PushMessageChannel {
    /**
     * 会议结束事件
     *
     * @return 会议结束事件
     */
    @Output(MsgGotonecoreChannel.MSG_GOTONECORE_MAIL_SEND_SUCCESS)
    MessageChannel sendMsgMailSendSuccess();
}
