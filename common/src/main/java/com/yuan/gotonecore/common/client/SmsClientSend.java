package com.yuan.gotonecore.common.client;

import com.bench.common.model.BaseModel;
import com.yuan.gotonecore.common.enums.SmsClientSendStatusEnum;

import java.util.Date;

/**
 * 客户端短信发送记录
 * 
 * @author cold
 * 
 * @version $Id: SmsClientSend.java, v 0.1 2014-9-26 下午2:41:11 cold Exp $
 */
public class SmsClientSend extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4999597517638062121L;

	// ========== properties ==========
	/**
	 * 主键，PK
	 */
	private long id;

	/**
	 * 短信ID
	 */
	private long smsId;

	/**
	 * 状态
	 */
	private SmsClientSendStatusEnum status;

	/**
	 * 创建时间
	 */
	private Date gmtCreate;

	/**
	 * 修改时间
	 */
	private Date gmtModified;

	/**
	 * 客户端申请时间
	 */
	private Date gmtClientApply;

	/**
	 * 客户端号
	 */
	private String clientNo;

	/**
	 * 客户端申请次数
	 */
	private long clientApplyCount;

	/**
	 * 客户端发送时间
	 */
	private Date gmtClientSendFinish;

	/**
	 * 下次发送时间
	 */
	private Date gmtClientResend;

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
	 * @return Returns the smsId.
	 */
	public long getSmsId() {
		return smsId;
	}

	/**
	 * @param smsId
	 *            The smsId to set.
	 */
	public void setSmsId(long smsId) {
		this.smsId = smsId;
	}

	/**
	 * @return Returns the status.
	 */
	public SmsClientSendStatusEnum getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            The status to set.
	 */
	public void setStatus(SmsClientSendStatusEnum status) {
		this.status = status;
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
	 * @return Returns the gmtClientApply.
	 */
	public Date getGmtClientApply() {
		return gmtClientApply;
	}

	/**
	 * @param gmtClientApply
	 *            The gmtClientApply to set.
	 */
	public void setGmtClientApply(Date gmtClientApply) {
		this.gmtClientApply = gmtClientApply;
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
	 * @return Returns the clientApplyCount.
	 */
	public long getClientApplyCount() {
		return clientApplyCount;
	}

	/**
	 * @param clientApplyCount
	 *            The clientApplyCount to set.
	 */
	public void setClientApplyCount(long clientApplyCount) {
		this.clientApplyCount = clientApplyCount;
	}

	/**
	 * @return Returns the gmtClientSendFinish.
	 */
	public Date getGmtClientSendFinish() {
		return gmtClientSendFinish;
	}

	/**
	 * @param gmtClientSendFinish
	 *            The gmtClientSendFinish to set.
	 */
	public void setGmtClientSendFinish(Date gmtClientSendFinish) {
		this.gmtClientSendFinish = gmtClientSendFinish;
	}

	/**
	 * @return Returns the gmtClientResend.
	 */
	public Date getGmtClientResend() {
		return gmtClientResend;
	}

	/**
	 * @param gmtClientResend
	 *            The gmtClientResend to set.
	 */
	public void setGmtClientResend(Date gmtClientResend) {
		this.gmtClientResend = gmtClientResend;
	}

}
