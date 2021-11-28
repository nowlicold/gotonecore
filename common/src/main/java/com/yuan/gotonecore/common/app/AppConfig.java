package com.yuan.gotonecore.common.app;

import com.bench.common.cache.local.IdGmtModifiedRefreshableCacheObject;
import com.bench.common.model.BaseModel;
import com.yuan.gotonecore.common.app.enums.AppConfigStatusEnum;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 应用配置
 * 
 * @author cold
 *
 * @version $Id: AppConfig.java, v 0.1 2015年9月16日 下午4:47:36 cold Exp $
 */
public class AppConfig extends BaseModel implements IdGmtModifiedRefreshableCacheObject<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7013156144927027424L;

	/**
	 * 主键，PK
	 */
	private long id;

	/**
	 * 应用代码
	 */
	private String appCode;

	/**
	 * 应用名称
	 */
	private String appName;

	/**
	 * 应用通知地址
	 */
	private String notifyUrl;

	/**
	 * 备注
	 */
	private String memo;

	/**
	 * 状态
	 */
	private AppConfigStatusEnum status;

	/**
	 * 属性集合
	 */
	private Map<String, String> properties = new HashMap<String, String>();

	/**
	 * 创建时间
	 */
	private Date gmtCreate;

	/**
	 * 修改时间
	 */
	private Date gmtModified;

	/**
	 * @return Returns the id.
	 */
	public Long getId() {
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
	 * @return Returns the appCode.
	 */
	public String getAppCode() {
		return appCode;
	}

	/**
	 * @param appCode
	 *            The appCode to set.
	 */
	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	/**
	 * @return Returns the appName.
	 */
	public String getAppName() {
		return appName;
	}

	/**
	 * @param appName
	 *            The appName to set.
	 */
	public void setAppName(String appName) {
		this.appName = appName;
	}

	/**
	 * @return Returns the notifyUrl.
	 */
	public String getNotifyUrl() {
		return notifyUrl;
	}

	/**
	 * @param notifyUrl
	 *            The notifyUrl to set.
	 */
	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	/**
	 * @return Returns the memo.
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * @param memo
	 *            The memo to set.
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}

	/**
	 * @return Returns the status.
	 */
	public AppConfigStatusEnum getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            The status to set.
	 */
	public void setStatus(AppConfigStatusEnum status) {
		this.status = status;
	}

	/**
	 * @return Returns the properties.
	 */
	public Map<String, String> getProperties() {
		return properties;
	}

	/**
	 * @param properties
	 *            The properties to set.
	 */
	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
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

}
