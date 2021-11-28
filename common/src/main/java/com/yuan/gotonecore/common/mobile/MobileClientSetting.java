/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.common.mobile;

import com.bench.common.model.BaseModel;
import com.bench.lang.base.enums.MobileSystemEnum;

import java.util.Date;

/**
 * 
 * @author cold
 *
 * @version $Id: MobileClientSetting.java, v 0.1 2016年1月25日 上午10:30:08 cold
 *          Exp $
 */
public class MobileClientSetting extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3436323498367244876L;

	/**
	 * 主键id
	 */
	private long id;
	/**
	 * 会员Id
	 */
	private String userId;

	/**
	 * 登录key
	 */
	private String loginKey;

	/**
	 * 签名key
	 */
	private String signKey;

	/**
	 * 登录平台类型
	 */
	private MobileSystemEnum loginPlatformType;

	/**
	 * 登录时间
	 */
	private Date gmtLogin;

	/**
	 * 创建时间
	 */
	private Date gmtCreate;

	/**
	 * 修改时间
	 */
	private Date gmtModified;

	/**
	 * 是否已登录
	 */
	private boolean logined;

	/**
	 * 退出登录时间
	 */
	private Date gmtLogout;

	/**
	 * 通知Key
	 */
	private String noticeKey;

	/**
	 * 是否通知
	 */
	private boolean noticeEnabled;

	/**
	 * 通知key更新时间
	 */
	private Date gmtNoticeKeyUpdate;

	/**
	 * @return Returns the userId.
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            The userId to set.
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return Returns the loginKey.
	 */
	public String getLoginKey() {
		return loginKey;
	}

	/**
	 * @param loginKey
	 *            The loginKey to set.
	 */
	public void setLoginKey(String loginKey) {
		this.loginKey = loginKey;
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
	 * @return Returns the loginPlatformType.
	 */
	public MobileSystemEnum getLoginPlatformType() {
		return loginPlatformType;
	}

	/**
	 * @param loginPlatformType
	 *            The loginPlatformType to set.
	 */
	public void setLoginPlatformType(MobileSystemEnum loginPlatformType) {
		this.loginPlatformType = loginPlatformType;
	}

	/**
	 * @return Returns the gmtLogin.
	 */
	public Date getGmtLogin() {
		return gmtLogin;
	}

	/**
	 * @param gmtLogin
	 *            The gmtLogin to set.
	 */
	public void setGmtLogin(Date gmtLogin) {
		this.gmtLogin = gmtLogin;
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
	 * @return Returns the logined.
	 */
	public boolean isLogined() {
		return logined;
	}

	/**
	 * @param logined
	 *            The logined to set.
	 */
	public void setLogined(boolean logined) {
		this.logined = logined;
	}

	/**
	 * @return Returns the gmtLogout.
	 */
	public Date getGmtLogout() {
		return gmtLogout;
	}

	/**
	 * @param gmtLogout
	 *            The gmtLogout to set.
	 */
	public void setGmtLogout(Date gmtLogout) {
		this.gmtLogout = gmtLogout;
	}

	/**
	 * @return Returns the noticeKey.
	 */
	public String getNoticeKey() {
		return noticeKey;
	}

	/**
	 * @param noticeKey
	 *            The noticeKey to set.
	 */
	public void setNoticeKey(String noticeKey) {
		this.noticeKey = noticeKey;
	}

	/**
	 * @return Returns the noticeEnabled.
	 */
	public boolean isNoticeEnabled() {
		return noticeEnabled;
	}

	/**
	 * @param noticeEnabled
	 *            The noticeEnabled to set.
	 */
	public void setNoticeEnabled(boolean noticeEnabled) {
		this.noticeEnabled = noticeEnabled;
	}

	/**
	 * @return Returns the gmtNoticeKeyUpdate.
	 */
	public Date getGmtNoticeKeyUpdate() {
		return gmtNoticeKeyUpdate;
	}

	/**
	 * @param gmtNoticeKeyUpdate
	 *            The gmtNoticeKeyUpdate to set.
	 */
	public void setGmtNoticeKeyUpdate(Date gmtNoticeKeyUpdate) {
		this.gmtNoticeKeyUpdate = gmtNoticeKeyUpdate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
