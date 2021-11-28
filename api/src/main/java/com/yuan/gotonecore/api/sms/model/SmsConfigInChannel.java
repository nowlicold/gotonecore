/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.api.sms.model;

import com.bench.common.cache.local.IdGmtModifiedRefreshableCacheObject;
import com.bench.common.model.BaseModel;
import com.yuan.gotonecore.api.sms.model.enums.SmsChannelEnum;
import lombok.Data;

import java.util.Date;
import java.util.Map;
/**
 * 短信配置在通道上的配置
 * 
 * @author cold
 *
 * @version $Id: SmsConfigInChannel.java, v 0.1 2016年5月13日 下午4:18:15 cold Exp
 *          $
 */
@Data
public class SmsConfigInChannel extends BaseModel implements IdGmtModifiedRefreshableCacheObject<Long> {

	/**
	 * 可以直接放入消息模板的kv参数
	 */
	public static final String PARAM_VALUE_START_WITH = "param.value.";

	/**
	 * 映射SmsOutDO中参数的kv参数，key为通道短信中的参数名，值为smsOUt中的参数名，实际传入到通道短信中的值为smsout中的参数值
	 */
	public static final String PARAM_ARG_REPLACE_START_WITH = "param.arg.replace.";

	/**
	 * 映射SmsOutDO中参数的kv参数,如果为空，则使用该默认值
	 */
	public static final String PARAM_ARG_DEFAULT_VALUE_START_WITH = "param.arg.default.";

	/**
	 * 
	 */
	private static final long serialVersionUID = -1935463839176667851L;

	/**
	 * 主键，PK
	 */
	private long id;

	/**
	 * 短信配置ID
	 */
	private long smsConfigId;

	/**
	 * 如果不为空，表示通道需要对短信内容重新定义
	 */
	private String content;

	/**
	 * 发送通道
	 */
	private SmsChannelEnum channel;

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
	 * 属性集合
	 */
	private Map<String, String> properties;
	@Override
	public Long getId(){
		return id;
	}


}
