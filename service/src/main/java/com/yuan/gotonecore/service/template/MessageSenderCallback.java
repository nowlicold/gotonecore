/**
 * Bench.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.service.template;

import com.yuan.gotonecore.api.result.GotoneCoreServiceResult;
import com.yuan.gotonecore.common.GotoneCoreModel;
import com.yuan.gotonecore.common.exceptions.GotoneCoreException;

/**
 * 沟通消息发送处理回调接口
 * 
 * @author zouyuxia
 *
 * @version $Id: MessageSenderCallback.java, v 0.1 2017年2月27日 上午11:13:47 zouyuxia Exp $
 */
public interface MessageSenderCallback {

	/**
	 * 锁定模型
	 * 
	 * @param id
	 * @return
	 */
	public GotoneCoreModel lockModel(long id) throws GotoneCoreException;

	/**
	 * 消息发送操作
	 * 
	 * @param gotoneModel
	 * @return
	 */
	public GotoneCoreServiceResult sendMessage(GotoneCoreModel gotoneModel) throws GotoneCoreException;

	/**
	 * 消息发送成功后处理
	 * 
	 * @param sendResult
	 * @param gotoneModel
	 */
	public void dealAfterSendSuccess(GotoneCoreServiceResult sendResult, GotoneCoreModel gotoneModel);

	/**
	 * 消息发送失败后处理
	 * 
	 * @param sendResult
	 * @param gotoneModel

	 */
	public void dealAfterSendFailed(GotoneCoreServiceResult sendResult, GotoneCoreModel gotoneModel);

}
