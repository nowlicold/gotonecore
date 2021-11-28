package com.yuan.gotonecore.service.msg;
import com.yuan.gotonecore.common.msg.MsgGotonecoreChannel;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @className RecvMessageChannel
 * @autor cold
 * @DATE 2021/8/31 21:56
 **/
public interface RecvMessageChannel {
    /**
     * 订阅完成开奖
     *
     * @return 完成开奖通道
     */
    @Input(MsgGotonecoreChannel.MSG_GOTONECORE_MAIL_SEND_SUCCESS)
    SubscribableChannel recvMsgMeetEnd();
}
