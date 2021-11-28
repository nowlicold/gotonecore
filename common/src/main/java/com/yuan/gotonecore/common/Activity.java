package com.yuan.gotonecore.common;


import com.yuan.gotonecore.common.enums.ActivityStatusEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 活动
 * 
 * @author cold
 * 
 * @version $Id: Activity.java, v 0.1 2012-10-26 下午5:12:32 cold Exp $
 */
@Data
public class Activity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6762989847891108087L;

	/**
	 * 主键，Pk
	 */
	private Integer id;

	/**
	 * 活动名
	 */
	private String activityName;

	/**
	 * 活动代码
	 */
	private String activityCode;

	/**
	 * 创建时间
	 */
	private Date gmtCreate;

	/**
	 * 修改时间
	 */
	private Date gmtModified;

	/**
	 * 备注
	 */
	private String memo;

	/**
	 * 活动状态
	 */
	private ActivityStatusEnum activityStatus;



}
