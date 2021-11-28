package com.yuan.gotonecore.api.request;


import com.bench.common.model.PageRequest;

/**
 * 邮件服务器查询请求
 * 
 * @author cold
 * 
 * @version $Id: MailServerConfigSearchRequest.java, v 0.1 2012-10-26 上午10:48:57
 *          cold Exp $
 */
public class MailServerConfigSearchRequest extends PageRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = -855862836351993279L;

	/** id */
	private long id;

	/** 地址 */
	private String host;

	/** 端口 */
	private int port;

	/** connectTimeout */
	private long connectTimeout;

	/** timeout */
	private long timeout;

	/**
	 * 修改时间
	 */
	private String beginModifiedDate;

	private String endModifiedDate;

	private String domainName;

	/**
	 * @return Returns the host.
	 */
	public String getHost() {
		return host;
	}

	/**
	 * @param host
	 *            The host to set.
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * @return Returns the port.
	 */
	public int getPort() {
		return port;
	}

	/**
	 * @param port
	 *            The port to set.
	 */
	public void setPort(int port) {
		this.port = port;
	}

	/**
	 * @return Returns the connectTimeout.
	 */
	public long getConnectTimeout() {
		return connectTimeout;
	}

	/**
	 * @param connectTimeout
	 *            The connectTimeout to set.
	 */
	public void setConnectTimeout(long connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

	/**
	 * @return Returns the timeout.
	 */
	public long getTimeout() {
		return timeout;
	}

	/**
	 * @param timeout
	 *            The timeout to set.
	 */
	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}

	/**
	 * @return Returns the beginModifiedDate.
	 */
	public String getBeginModifiedDate() {
		return beginModifiedDate;
	}

	/**
	 * @param beginModifiedDate
	 *            The beginModifiedDate to set.
	 */
	public void setBeginModifiedDate(String beginModifiedDate) {
		this.beginModifiedDate = beginModifiedDate;
	}

	/**
	 * @return Returns the endModifiedDate.
	 */
	public String getEndModifiedDate() {
		return endModifiedDate;
	}

	/**
	 * @param endModifiedDate
	 *            The endModifiedDate to set.
	 */
	public void setEndModifiedDate(String endModifiedDate) {
		this.endModifiedDate = endModifiedDate;
	}

	/**
	 * @return Returns the id.
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            The id to set.
	 */
	public void setId(long id) {
		this.id = id;
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
