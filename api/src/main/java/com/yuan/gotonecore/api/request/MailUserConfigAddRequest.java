package com.yuan.gotonecore.api.request;

/**
 * 邮件用户配置新增请求
 * 
 * @author cold
 * 
 * @version $Id: MailUserConfigAddRequest.java, v 0.1 2011-1-4 下午03:30:22
 *          cold Exp $
 */
public class MailUserConfigAddRequest {

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 发送人地址
	 */
	private String fromAddr;

	/**
	 * 发送人姓名
	 */
	private String fromName;

	/**
	 * 邮件ID
	 */
	private long mailServerId;

	/**
	 * 用户类型，区分用户，由用户自由设置
	 */
	private String userType;

	/**
	 * 操作人
	 */
	private String operator;

	/**
	 * @return Returns the password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            The password to set.
	 */
	public void setPassword(String password) {
		this.password = password;
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
	 * @return Returns the operator.
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * @param operator
	 *            The operator to set.
	 */
	public void setOperator(String operator) {
		this.operator = operator;
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
