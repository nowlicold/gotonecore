/**
 * 
 */
package com.yuan.gotonecore.common.mobile;

import com.bench.common.model.BaseModel;
import com.yuan.gotonecore.common.enums.MobileClientPushMsgStatusEnum;

import java.util.Date;
import java.util.Map;

/**
 * 移动端推送消息历史
 * @author chengzi
 *
 * @version $Id: MobileClientPushMsgHis.java, v 0.1 2016年3月3日 下午5:49:05 Admin Exp $
 */
public class MobileClientPushMsgHis extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1931282799512805243L;
	
	/**
	 * 主键，PK
	 */
	private long id;

	/**
	 * 会员ID
	 */
	private String userId;

	/**
	 * 推送内容
	 */
	private String content;

	/**
	 * 创建时间
	 */
	private Date gmtCreate;

	/**
	 * 修改时间
	 */
	private Date gmtModified;

	/**
	 * 下次推送时间
	 */
	private Date gmtNextPush;

	/**
	 * 尝试次数
	 */
	private long tryCount;

	/**
	 * 推送结果
	 */
	private String pushResult;

	/**
	 * 状态
	 */
	private MobileClientPushMsgStatusEnum status;

	/**
	 * 源消息ID
	 */
	private String sourceMessageId;

	/**
	 * 源系统代码
	 */
	private String sourceAppName;

	/**
	 * 消息类型
	 */
	private Map<String, String> properties;
	
	/**
	 * 历史创建时间
	 */
	private Date gmtHisCreate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public Date getGmtNextPush() {
		return gmtNextPush;
	}

	public void setGmtNextPush(Date gmtNextPush) {
		this.gmtNextPush = gmtNextPush;
	}

	public long getTryCount() {
		return tryCount;
	}

	public void setTryCount(long tryCount) {
		this.tryCount = tryCount;
	}

	public String getPushResult() {
		return pushResult;
	}

	public void setPushResult(String pushResult) {
		this.pushResult = pushResult;
	}

	public MobileClientPushMsgStatusEnum getStatus() {
		return status;
	}

	public void setStatus(MobileClientPushMsgStatusEnum status) {
		this.status = status;
	}

	public String getSourceMessageId() {
		return sourceMessageId;
	}

	public void setSourceMessageId(String sourceMessageId) {
		this.sourceMessageId = sourceMessageId;
	}

	public String getSourceAppName() {
		return sourceAppName;
	}

	public void setSourceAppName(String sourceAppName) {
		this.sourceAppName = sourceAppName;
	}

	public Map<String, String> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}

	public Date getGmtHisCreate() {
		return gmtHisCreate;
	}

	public void setGmtHisCreate(Date gmtHisCreate) {
		this.gmtHisCreate = gmtHisCreate;
	}
	
	

}
