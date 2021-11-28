package com.yuan.gotonecore.api.sms.client.request;

import com.bench.lang.base.object.ToStringObject;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 短信发送客户端登陆请求
 * 
 * @author cold
 * 
 * @version $Id: SmsClienLoginRequest.java, v 0.1 2014-9-26 下午2:37:58 cold
 *          Exp $
 */
@Data
public class SmsClienLoginRequest extends ToStringObject {
	@ApiModelProperty(value = "客户端号")
	private String clientNo;
	@ApiModelProperty(value = "登录密码")
	private String loginPassword;


}
