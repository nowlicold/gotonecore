package com.yuan.gotonecore.api.request;


import com.yuan.gotonecore.common.enums.MailUserConfigStatusEnum;

/**
 * 邮件用户配置新增请求
 * 
 * @author cold
 * 
 * @version $Id: MailUserConfigModifyRequest.java, v 0.1 2011-1-4 下午03:30:22
 *          cold Exp $
 */
public class MailUserConfigModifyRequest {

	/**
	 * 主键，Pk
	 */
	private long id;

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
	 * 服务端是否有效，
	 */
	private boolean serversideEnabled;

	/**
	 * 服务端无效原因
	 */
	private String serviceSideDisabledReason;

	/**
	 * 状态
	 */
	private MailUserConfigStatusEnum status;

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

	/**
	 * @return Returns the serversideEnabled.
	 */
	public boolean isServersideEnabled() {
		return serversideEnabled;
	}

	/**
	 * @param serversideEnabled The serversideEnabled to set.
	 */
	public void setServersideEnabled(boolean serversideEnabled) {
		this.serversideEnabled = serversideEnabled;
	}

	/**
	 * @return Returns the serviceSideDisabledReason.
	 */
	public String getServiceSideDisabledReason() {
		return serviceSideDisabledReason;
	}

	/**
	 * @param serviceSideDisabledReason The serviceSideDisabledReason to set.
	 */
	public void setServiceSideDisabledReason(String serviceSideDisabledReason) {
		this.serviceSideDisabledReason = serviceSideDisabledReason;
	}

	/**
	 * @return Returns the status.
	 */
	public MailUserConfigStatusEnum getStatus() {
		return status;
	}

	/**
	 * @param status The status to set.
	 */
	public void setStatus(MailUserConfigStatusEnum status) {
		this.status = status;
	}

}
