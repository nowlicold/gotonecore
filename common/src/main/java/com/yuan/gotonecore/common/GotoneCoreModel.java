/*
 * Bench.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.common;
import com.bench.lang.base.object.ToStringBuilder;
import com.yuan.gotonecore.common.enums.GotoneChannelEnum;
import com.yuan.gotonecore.common.enums.GtMessageTypeEnum;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * 抽象消息模型
 * 
 * @author min.weixm
 * 
 * @version $Id: GotoneModel.java, v 0.1 2009-9-16 下午02:35:58 min.weixm Exp $
 */
@Data
public abstract class GotoneCoreModel implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 2539549480123847986L;

	/** 重发消息标志 */
	private boolean isResend = false;

	/** 当前发送次数 */
	private int sendTimes;

	/** 消息创建时间 */
	private Date gmtCreate;

	/**
	 * 对应的活动
	 */
	private Activity activity;

	/**
	 * 通道
	 */
	private GotoneChannelEnum channel;

	/** 消息流水 */
	private Integer id;

	/** 属性 */
	private Map<String, String> properties;

	/** 消息类型 */
	protected GtMessageTypeEnum messageType;


}
