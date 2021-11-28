package com.yuan.gotonecore.common.client;

import com.bench.common.enums.common.SignTypeEnum;
import com.bench.lang.base.object.ToStringObject;

import java.util.Date;

/**
 * 短信客户端
 * 
 * @author cold
 * 
 * @version $Id: SmsClient.java, v 0.1 2014-9-26 下午5:03:49 cold Exp $
 */
public class SmsClient extends ToStringObject {

	public static final String DATA_JOIN = "^";

	public static final String RECORD_JOIN = "&";
	/**
	 * 主键，PK
	 */
	private long id;

	/**
	 * 客户端号
	 */
	private String clientNo;

	/**
	 * 登录密码
	 */
	private String loginPassword;

	/**
	 * 创建时间
	 */
	private Date gmtCreate;

	/**
	 * 修改时间
	 */
	private Date gmtModified;

	/**
	 * 是否有效
	 */
	private boolean enabled;

	/**
	 * 签名key
	 */
	private String signKey;

	/**
	 * 签名类型
	 */
	private SignTypeEnum signType;

	/**
	 * 每次申请的短信数
	 */
	private int applyEachCount;

	/**
	 * 最大申请的打印池容量
	 */
	private long applyMaxPoolSize;

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
	 * @return Returns the clientNo.
	 */
	public String getClientNo() {
		return clientNo;
	}

	/**
	 * @param clientNo
	 *            The clientNo to set.
	 */
	public void setClientNo(String clientNo) {
		this.clientNo = clientNo;
	}

	/**
	 * @return Returns the loginPassword.
	 */
	public String getLoginPassword() {
		return loginPassword;
	}

	/**
	 * @param loginPassword
	 *            The loginPassword to set.
	 */
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	/**
	 * @return Returns the gmtCreate.
	 */
	public Date getGmtCreate() {
		return gmtCreate;
	}

	/**
	 * @param gmtCreate
	 *            The gmtCreate to set.
	 */
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	/**
	 * @return Returns the gmtModified.
	 */
	public Date getGmtModified() {
		return gmtModified;
	}

	/**
	 * @param gmtModified
	 *            The gmtModified to set.
	 */
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	/**
	 * @return Returns the enabled.
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @param enabled
	 *            The enabled to set.
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return Returns the signKey.
	 */
	public String getSignKey() {
		return signKey;
	}

	/**
	 * @param signKey
	 *            The signKey to set.
	 */
	public void setSignKey(String signKey) {
		this.signKey = signKey;
	}

	/**
	 * @return Returns the applyEachCount.
	 */
	public int getApplyEachCount() {
		return applyEachCount;
	}

	/**
	 * @param applyEachCount
	 *            The applyEachCount to set.
	 */
	public void setApplyEachCount(int applyEachCount) {
		this.applyEachCount = applyEachCount;
	}

	/**
	 * @return Returns the applyMaxPoolSize.
	 */
	public long getApplyMaxPoolSize() {
		return applyMaxPoolSize;
	}

	/**
	 * @param applyMaxPoolSize
	 *            The applyMaxPoolSize to set.
	 */
	public void setApplyMaxPoolSize(long applyMaxPoolSize) {
		this.applyMaxPoolSize = applyMaxPoolSize;
	}

	public SignTypeEnum getSignType() {
		return signType;
	}

	public void setSignType(SignTypeEnum signType) {
		this.signType = signType;
	}
}
