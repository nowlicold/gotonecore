/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.api.request;

/**
 * 
 * @author cold
 * 
 * @version $Id: MailSendClientRegisterRequest.java, v 0.1 2011-1-25 下午10:01:16
 *          cold Exp $
 */
public class MailSendClientRegisterRequest {

	/**
	 * 注册key
	 */
	private String registerKey;

	/**
	 * 客户端ID
	 */
	private String clientId;

	/**
	 * 客户端IP
	 */
	private String clientIp;

	/**
	 * 客户端主机名
	 */
	private String clientHost;

	public String getRegisterKey() {
		return registerKey;
	}

	public void setRegisterKey(String registerKey) {
		this.registerKey = registerKey;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	public String getClientHost() {
		return clientHost;
	}

	public void setClientHost(String clientHost) {
		this.clientHost = clientHost;
	}

}
