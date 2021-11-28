package com.yuan.gotonecore.api.sms.model.client;

import com.bench.common.model.BaseModel;
import com.yuan.gotonecore.api.sms.model.enums.SmsClientSendStatusEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Value;

import java.util.Date;

/**
 * 客户端短信发送记录
 * 
 * @author cold
 * 
 * @version $Id: SmsClientSend.java, v 0.1 2014-9-26 下午2:41:11 cold Exp $
 */
@Data
public class SmsClientSend extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4999597517638062121L;

	// ========== properties ==========
	/**
	 * 主键，PK
	 */
	@ApiModelProperty(value = "主键，PK")
	private long id;

	/**
	 * 短信ID
	 */
	@ApiModelProperty(value = "短信ID")
	private long smsId;

	/**
	 * 状态
	 */
	@ApiModelProperty(value = "状态")
	private SmsClientSendStatusEnum status;

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
	 * 客户端申请时间
	 */
	@ApiModelProperty(value = "客户端申请时间")
	private Date gmtClientApply;

	/**
	 * 客户端号
	 */
	@ApiModelProperty(value = "客户端号")
	private String clientNo;

	/**
	 * 客户端申请次数
	 */
	@ApiModelProperty(value = "客户端申请次数")
	private long clientApplyCount;

	/**
	 * 客户端发送时间
	 */
	@ApiModelProperty(value = "客户端发送时间")
	private Date gmtClientSendFinish;

	/**
	 * 下次发送时间
	 */
	@ApiModelProperty(value = "下次发送时间")
	private Date gmtClientResend;

}
