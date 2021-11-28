package com.yuan.gotonecore.api.request;

import com.bench.common.model.PageRequest;
import com.yuan.gotonecore.common.enums.ActivityStatusEnum;

/**
 * 邮件用户配置查询请求
 * 
 * @author cold
 * 
 * @version $Id: MailUserConfigQueryRequest.java, v 0.1 2011-1-4 下午03:30:22
 *          cold Exp $
 */
public class ActivityQueryRequest extends PageRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7425037530529935765L;

	/**
	 * 主键，Pk
	 */
	private long id;

	/**
	 * 活动状态
	 */
	private ActivityStatusEnum status;
	/**
	 * 活动名
	 */
	private String activityName;

	/**
	 * 活动代码
	 */
	private String activityCode;

	/**
	 * 
	 */
	private String beginModifiedDate;

	/**
	 * 
	 */
	private String endModifiedDate;

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
	 * @return Returns the activityName.
	 */
	public String getActivityName() {
		return activityName;
	}

	/**
	 * @param activityName
	 *            The activityName to set.
	 */
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	/**
	 * @return Returns the beginModifiedDate.
	 */
	public String getBeginModifiedDate() {
		return beginModifiedDate;
	}

	/**
	 * @param beginModifiedDate
	 *            The beginModifiedDate to set.
	 */
	public void setBeginModifiedDate(String beginModifiedDate) {
		this.beginModifiedDate = beginModifiedDate;
	}

	/**
	 * @return Returns the endModifiedDate.
	 */
	public String getEndModifiedDate() {
		return endModifiedDate;
	}

	/**
	 * @param endModifiedDate
	 *            The endModifiedDate to set.
	 */
	public void setEndModifiedDate(String endModifiedDate) {
		this.endModifiedDate = endModifiedDate;
	}

	/**
	 * @return Returns the status.
	 */
	public ActivityStatusEnum getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            The status to set.
	 */
	public void setStatus(ActivityStatusEnum status) {
		this.status = status;
	}

	/**
	 * @return Returns the activityCode.
	 */
	public String getActivityCode() {
		return activityCode;
	}

	/**
	 * @param activityCode
	 *            The activityCode to set.
	 */
	public void setActivityCode(String activityCode) {
		this.activityCode = activityCode;
	}

}
