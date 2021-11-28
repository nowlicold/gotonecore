/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.api.request;

/**
 * 新增邮件服务器
 * 
 * @author cold
 * 
 * @version $Id: MailServerConfigAddRequest, v 0.1 2010-12-13 下午06:54:25 cold
 *          Exp $
 */
public class MailServerConfigAddRequest {
	


	/** 地址 */
	private String host;

	/** 端口 */
	private int port;

	/** connectTimeout */
	private long connectTimeout = 3000;

	/** timeout */
	private long timeout = 3000;

	/**
	 * 邮件域
	 */
	private String domainName;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public long getConnectTimeout() {
		return connectTimeout;
	}

	public void setConnectTimeout(long connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

	public long getTimeout() {
		return timeout;
	}

	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}

	/**
	 * @return Returns the domainName.
	 */
	public String getDomainName() {
		return domainName;
	}

	/**
	 * @param domainName
	 *            The domainName to set.
	 */
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

}
