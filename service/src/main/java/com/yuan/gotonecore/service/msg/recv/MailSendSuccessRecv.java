/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.service.msg.recv;
import com.alibaba.fastjson.JSON;
import com.bench.lang.base.string.utils.StringUtils;
import com.yuan.gotonecore.common.enums.GotoneChannelEnum;
import com.yuan.gotonecore.common.msg.MsgGotonecoreChannel;
import com.yuan.gotonecore.common.msg.MsgMailSendSuccessPayload;
import com.yuan.gotonecore.repository.mapper.MailOutHistoryMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * 
 * @author cold
 * 
 * @version $Id: GotoneMailSendSuccessListener.java, v 0.1 2011-1-17 下午05:17:29
 *          cold Exp $
 */
@Component
@Slf4j
public class MailSendSuccessRecv {
	@Autowired
	private MailOutHistoryMapper mailOutHistoryMapper;

	@StreamListener(MsgGotonecoreChannel.MSG_GOTONECORE_MAIL_SEND_SUCCESS)
	public void recvMailSendSuccess(Message<String> message){
		MsgMailSendSuccessPayload msgMailSendSuccessPayload = JSON
				.parseObject(message.getPayload(), MsgMailSendSuccessPayload.class);
		if (StringUtils.equals(mailOutHistoryMapper.selectChannelById(msgMailSendSuccessPayload.getMailOutId()), GotoneChannelEnum.EDM.name())) {
		}
	}
}
