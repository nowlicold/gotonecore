/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.service.mail.task;

import com.bench.lang.base.json.jackson.JacksonUtils;
import com.bench.lang.base.string.utils.StringUtils;
import com.bench.xtask.BenchDistributeTask;
import com.bench.xtask.annotation.DistributeTask;
import com.yuan.gotonecore.api.result.GotoneCoreServiceResult;
import com.yuan.gotonecore.common.enums.GotoneChannelEnum;
import com.yuan.gotonecore.common.enums.MailBodyPatternTypeEnum;
import com.yuan.gotonecore.repository.entity.MailOutDO;
import com.yuan.gotonecore.repository.mapper.MailOutMapper;
import com.yuan.gotonecore.service.mail.MailOperationComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 
 * @author cold
 * 
 * @version $Id: SendMailTask.java, v 0.1 2014-5-15 下午3:11:31 cold Exp $
 */
@DistributeTask(cronExpression = "0/5 * * * * ? *")
@Component
@Slf4j
public class SendMailTask implements BenchDistributeTask {

	@Autowired
	private MailOutMapper mailOutMapper;

	@Autowired
	private MailOperationComponent mailOperationComponent;

	@Override
	public void execute() {
		List<Integer> selectReadyToSendIds = mailOutMapper.selectReadyToSendIds(GotoneChannelEnum.DEFAULT.name(), 100);
		for (Integer id : selectReadyToSendIds) {
			MailOutDO mailOutDO = mailOutMapper.findMailMsgById(id);
			if (StringUtils.equals(mailOutDO.getMailBodyPattern(), MailBodyPatternTypeEnum.BY_CONTENT.name())) {
				mailOperationComponent.executeSendNow(id);
			} else {
				GotoneCoreServiceResult result = mailOperationComponent.executeSend(id);
				log.error("邮件发送日志打印result={}", JacksonUtils.toJson(result));
			}
		}
	}

}
