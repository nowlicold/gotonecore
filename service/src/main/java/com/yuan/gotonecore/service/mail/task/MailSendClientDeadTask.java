/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.service.mail.task;
import com.bench.xtask.BenchDistributeTask;
import com.bench.xtask.annotation.DistributeTask;
import com.yuan.gotonecore.repository.mapper.MailOutMapper;
import com.yuan.gotonecore.repository.mapper.MailSendClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * EDM邮件分发线程，将系统中未分配的EDM邮件分发给邮件发送端
 * 
 * @author cold
 * 
 * @version $Id: GotoneMailSendClientDeadTask, v 0.1 2011-1-27 下午03:30:17
 *          cold Exp $
 */
@DistributeTask(cronExpression = "0/30 * * * * ? *")
@Component
public class MailSendClientDeadTask implements BenchDistributeTask {

	@Autowired
	private MailSendClientMapper mailSendClientMapper;
	@Autowired
	private MailOutMapper mailOutMapper;
	@Autowired
	private TransactionTemplate transactionTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bench.platform.scheduler.task.Task#execute()
	 */
	public void execute() {
		// TODO Auto-generated method stub
		transactionTemplate.execute(new TransactionCallback<Integer>() {

			public Integer doInTransaction(TransactionStatus status) {
				// TODO Auto-generated method stub
				// 2分钟后超时
				mailSendClientMapper.updateToDeadByTimeout(60 * 2);
				// 更新当前current_amount数量
				mailSendClientMapper.updateCurrentAmountByMailTimeout();
				// 死亡客户端的邮件释放
				mailOutMapper.unassignMailBySendClientTimeout();
				return 1;
			}

		});

	}

	public boolean isMultiInstance() {
		// TODO Auto-generated method stub
		return false;
	}

}
