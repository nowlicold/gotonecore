package com.yuan.gotonecore.api.sms.request;
import com.bench.common.model.PageRequest;
import com.yuan.gotonecore.api.sms.model.enums.SmsChannelEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 短信配置查询请求
 * 
 * @author cold
 * 
 * @version $Id: SmsConfigQueryRequest.java, v 0.1 2012-10-26 下午7:56:21 cold
 *          Exp $
 */
@Data
public class SmsConfigQueryRequest extends PageRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1027822251386160121L;

	/**
	 * 短信ID
	 */
	@ApiModelProperty(value = "短信ID")
	private long id;

	/**
	 * 配置ID
	 */
	@ApiModelProperty(value = "配置ID")
	private String configId;

	/**
	 * 短信内容
	 */
	@ApiModelProperty(value = "短信内容")
	private String content;

	/**
	 * 发送通道
	 */
	@ApiModelProperty(value = "发送通道")
	private SmsChannelEnum sendChannel;

	/**
	 * 修改时间
	 */
	@ApiModelProperty(value = "修改时间")
	private String beginModifiedDate;

	/**
	 * 最后修改时间
	 */
	@ApiModelProperty(value = "最后修改时间")
	private String endModifiedDate;


}
