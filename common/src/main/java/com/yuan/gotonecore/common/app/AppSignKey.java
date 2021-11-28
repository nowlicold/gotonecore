package com.yuan.gotonecore.common.app;

import com.bench.common.cache.local.IdGmtModifiedRefreshableCacheObject;
import com.bench.common.enums.common.SignTypeEnum;
import com.bench.common.model.BaseModel;
import java.util.Date;

/**
 * 签名key
 * 
 * @author cold
 *
 * @version $Id: AppSignKey.java, v 0.1 2015年9月16日 下午4:56:14 cold Exp $
 */
public class AppSignKey extends BaseModel implements IdGmtModifiedRefreshableCacheObject<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2447451125586118289L;

	/**
	 * 主键，PK
	 */
	private long id;

	/**
	 * 应用ID
	 */
	private long appId;

	/**
	 * 密钥类型
	 */
	private SignTypeEnum keyType;

	/**
	 * 密钥值
	 */
	private String keyValue;

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
	 * @return Returns the appId.
	 */
	public long getAppId() {
		return appId;
	}

	/**
	 * @param appId
	 *            The appId to set.
	 */
	public void setAppId(long appId) {
		this.appId = appId;
	}

	public SignTypeEnum getKeyType() {
		return keyType;
	}

	public void setKeyType(SignTypeEnum keyType) {
		this.keyType = keyType;
	}

	/**
	 * @return Returns the keyValue.
	 */
	public String getKeyValue() {
		return keyValue;
	}

	/**
	 * @param keyValue
	 *            The keyValue to set.
	 */
	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
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

}
