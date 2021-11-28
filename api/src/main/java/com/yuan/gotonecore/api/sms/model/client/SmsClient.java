package com.yuan.gotonecore.api.sms.model.client;

import com.bench.lang.base.object.ToStringObject;
import com.bench.common.enums.common.SignTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 短信客户端
 * 
 * @author cold
 * 
 * @version $Id: SmsClient.java, v 0.1 2014-9-26 下午5:03:49 cold Exp $
 */
@Data
public class SmsClient extends ToStringObject {

	public static final String DATA_JOIN = "^";

	public static final String RECORD_JOIN = "&";
	/**
	 * 主键，PK
	 */
	@ApiModelProperty(value = "主键，PK")
	private long id;

	/**
	 * 客户端号
	 */
	@ApiModelProperty(value = "客户端号")
	private String clientNo;

	/**
	 * 登录密码
	 */
	@ApiModelProperty(value = "登录密码")
	private String loginPassword;

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
	 * 是否有效
	 */
	@ApiModelProperty(value = "enabled")
	private boolean enabled;

	/**
	 * 签名key
	 */
	@ApiModelProperty(value = "signKey")
	private String signKey;

	/**
	 * 签名类型
	 */
	@ApiModelProperty(value = "signType")
	private SignTypeEnum signType;

	/**
	 * 每次申请的短信数
	 */
	@ApiModelProperty(value = "每次申请的短信数")
	private int applyEachCount;

	/**
	 * 最大申请的打印池容量
	 */
	@ApiModelProperty(value = "最大申请的打印池容量")
	private long applyMaxPoolSize;

}
