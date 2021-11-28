package com.yuan.gotonecore.api.sms.model;

import com.bench.common.cache.local.IdGmtModifiedRefreshableCacheObject;
import com.bench.common.model.BaseModel;
import com.yuan.gotonecore.api.sms.model.enums.SmsChannelEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 短信配置
 * 
 * @author cold
 *
 * @version $Id: SmsConfig.java, v 0.1 2017年2月22日 下午2:56:36 cold Exp $
 */

@Data
public class SmsConfig extends BaseModel implements IdGmtModifiedRefreshableCacheObject<Long>  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8654352474472915370L;

	/**
	 * 短信ID
	 */
	@ApiModelProperty(value = "短信ID")
	private long id;

	/**
	 * 配置ID
	 */
	@ApiModelProperty(value = "配置ID")
	private String configName;

	/**
	 * 短信内容
	 */
	@ApiModelProperty(value = "短信内容")
	private String content;

	/**
	 * 发送通道
	 */
	@ApiModelProperty(value = "发送通道")
	private SmsChannelEnum[] sendChannels;

	/**
	 * 间隔时间
	 */
	@ApiModelProperty(value = "intervalSeconds")
	private long intervalSeconds;

	/**
	 * 验证码超时时间
	 */
	@ApiModelProperty(value = "验证码超时时间")
	private long ackCodeTimeoutSeconds;

	/**
	 * 验证码最大验证次数
	 */
	@ApiModelProperty(value = "验证码最大验证次数")
	private int ackCodeMaxValidate;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
	private Date gmtCreate;

	/**
	 * 修改时间
	 */
	@ApiModelProperty(value = "修改时间")
	private Date gmtModified;

	/**
	 * 开始发送时间
	 */
	@ApiModelProperty(value = "开始发送时间")
	private String sendStartTime;

	/**
	 * 停止发送时间
	 */
	@ApiModelProperty(value = "停止发送时间")
	private String sendEndTime;

	/**
	 * 最大尝试次数
	 */
	@ApiModelProperty(value = "最大尝试次数")
	private int maxTryCount;

	/**
	 * 发送失败后，重试间隔秒数
	 */
	@ApiModelProperty(value = "发送失败后，重试间隔秒数")
	private long retryIntervalSeconds;

	/**
	 * 短信发送是否需要唯一id
	 */
	@ApiModelProperty(value = "短信发送是否需要唯一id")
	private boolean smsOutNeedUniqueId;

	public Long getId() {
		return this.id;
	}


}
