package com.yuan.gotonecore.api.request;

import com.bench.common.model.PageRequest;
import com.yuan.gotonecore.common.enums.MailUserConfigStatusEnum;

public class MailUserConfigSearchRequest extends PageRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6241495395809671388L;

	/**
	 * 编号
	 */
	private long id;

	/**
	 * 发送人地址
	 */
	private String fromAddr;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 邮件服务ID
	 */
	private long mailServerId;

	/**
	 * 发送人姓名
	 */
	private String fromName;

	/**
	 * 修改时间
	 */
	private String beginModifiedDate;

	/**
	 * 最后修改时间
	 */
	private String endModifiedDate;

	/**
	 * 状态
	 */
	private MailUserConfigStatusEnum status;

	/**
	 * 服务端是否有效
	 */
	private Boolean serversideEnabled;

	/**
	 * 用户类型
	 */
	private String userType;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFromAddr() {
		return fromAddr;
	}

	public void setFromAddr(String fromAddr) {
		this.fromAddr = fromAddr;
	}

	public String getFromName() {
		return fromName;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBeginModifiedDate() {
		return beginModifiedDate;
	}

	public void setBeginModifiedDate(String beginModifiedDate) {
		this.beginModifiedDate = beginModifiedDate;
	}

	public String getEndModifiedDate() {
		return endModifiedDate;
	}

	public void setEndModifiedDate(String endModifiedDate) {
		this.endModifiedDate = endModifiedDate;
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
	 * @return Returns the status.
	 */
	public MailUserConfigStatusEnum getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            The status to set.
	 */
	public void setStatus(MailUserConfigStatusEnum status) {
		this.status = status;
	}

	/**
	 * @return Returns the serversideEnabled.
	 */
	public Boolean getServersideEnabled() {
		return serversideEnabled;
	}

	/**
	 * @param serversideEnabled
	 *            The serversideEnabled to set.
	 */
	public void setServersideEnabled(Boolean serversideEnabled) {
		this.serversideEnabled = serversideEnabled;
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
