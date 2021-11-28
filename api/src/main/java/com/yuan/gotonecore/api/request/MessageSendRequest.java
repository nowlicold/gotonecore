package com.yuan.gotonecore.api.request;

import java.util.Map;

import com.bench.lang.base.object.ToStringBuilder;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 消息发送请求
 * 
 * @author cold
 * 
 * @version $Id: MessageSendRequest.java, v 0.1 2012-11-1 下午2:57:51 cold Exp
 *          $
 */
@Data
public class MessageSendRequest {

	/** 消息内容模板参数 */
	@ApiModelProperty(value = "消息内容模板参数")
	protected Map<String, String> templateArgs;

	/**
	 * 属性集合
	 */
	@ApiModelProperty(value = "属性集合")
	protected Map<String, String> properties;

	/**
	 * 用户ID
	 */
	@ApiModelProperty(value = "用户ID")
	private String userId;


	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
