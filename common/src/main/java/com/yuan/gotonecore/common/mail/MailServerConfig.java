/*
 * Bench.com Inc.
 * Copyright (c) 2008-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.common.mail;

import com.bench.lang.base.object.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;

/**
 * MailServer类
 * 
 * @author cold
 * 
 * @version $Id: MailServer.java, v 0.1 2012-10-15 下午9:33:35 cold Exp $
 */
public class MailServerConfig implements Serializable, Cloneable {

	/** serialVersionUID */
	private static final long serialVersionUID = 7503561547167319240L;

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

	private Date gmtCreate;

	private Date gmtModified;

	private String domainName;

	/**
	 * Getter method for property <tt>host</tt>.
	 * 
	 * @return property value of host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * Setter method for property <tt>host</tt>.
	 * 
	 * @param
	 *
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * Getter method for property <tt>port</tt>.
	 * 
	 * @return property value of port
	 */
	public int getPort() {
		return port;
	}

	/**
	 * Setter method for property <tt>port</tt>.
	 * 
	 * @param
	 *
	 */
	public void setPort(int port) {
		this.port = port;
	}

	/**
	 * Getter method for property <tt>connectTimeout</tt>.
	 * 
	 * @return property value of connectTimeout
	 */
	public long getConnectTimeout() {
		return connectTimeout;
	}

	/**
	 * Setter method for property <tt>connectTimeout</tt>.
	 * 
	 * @param
	 *
	 */
	public void setConnectTimeout(long connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

	/**
	 * Getter method for property <tt>timeout</tt>.
	 * 
	 * @return property value of timeout
	 */
	public long getTimeout() {
		return timeout;
	}

	/**
	 * Setter method for property <tt>timeout</tt>.
	 * 
	 * @param
	 *
	 */
	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}

	/**
	 * @see Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#clone()
	 */
	public Object clone() throws CloneNotSupportedException {
		Object result = super.clone();
		return result;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
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
