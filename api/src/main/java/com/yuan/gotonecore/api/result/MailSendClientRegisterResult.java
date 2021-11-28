/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.api.result;


import com.yuan.gotonecore.common.enums.ErrorCodeEnum;

/**
 * 发送客户端注册结果
 * 
 * @author cold
 * 
 * @version $Id: MailSendClientRegisterResponse.java, v 0.1 2011-1-25 下午10:02:08
 *          cold Exp $
 */
public class MailSendClientRegisterResult {

	/**
	 * 客户端Id
	 */
	private String clientId;

	/**
	 * 是否成功
	 */
	private boolean success;

	/**
	 * 错误代码
	 */
	private ErrorCodeEnum errorCode;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public ErrorCodeEnum getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ErrorCodeEnum errorCode) {
		this.errorCode = errorCode;
	}

}
