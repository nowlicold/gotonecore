package com.yuan.gotonecore.api.request;


import com.bench.common.model.PageRequest;

/**
 * 邮件用户配置查询请求
 * 
 * @author cold
 * 
 * @version $Id: MailUserConfigQueryRequest.java, v 0.1 2011-1-4 下午03:30:22
 *          cold Exp $
 */
public class MailUserConfigQueryRequest extends PageRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5498597166023623386L;

	/**
	 * 主键，PK
	 */
	private long id;

	/**
	 * 发送人地址
	 */
	private String fromAddr;

	/**
	 * 发送人姓名
	 */
	private String fromName;

	/**
	 * 邮件服务器ID
	 */
	private long mailServerId;

	/**
	 * 用户类型
	 */
	private String userType;

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
	 * @return Returns the fromAddr.
	 */
	public String getFromAddr() {
		return fromAddr;
	}

	/**
	 * @param fromAddr
	 *            The fromAddr to set.
	 */
	public void setFromAddr(String fromAddr) {
		this.fromAddr = fromAddr;
	}

	/**
	 * @return Returns the fromName.
	 */
	public String getFromName() {
		return fromName;
	}

	/**
	 * @param fromName
	 *            The fromName to set.
	 */
	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	/**
	 * @return Returns the mailServerId.
	 */
	public long getMailServerId() {
		return mailServerId;
	}

	/**
	 * @param mailServerId
	 *            The mailServerId to set.
	 */
	public void setMailServerId(long mailServerId) {
		this.mailServerId = mailServerId;
	}

	/**
	 * @return Returns the userType.
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * @param userType
	 *            The userType to set.
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

}
