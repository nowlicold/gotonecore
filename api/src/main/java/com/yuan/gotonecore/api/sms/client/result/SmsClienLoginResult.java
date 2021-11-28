package com.yuan.gotonecore.api.sms.client.result;


import com.bench.common.model.BaseResult;
import com.yuan.gotonecore.api.sms.model.client.SmsClient;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 短信发送客户端登陆结果
 * 
 * @author cold
 * 
 * @version $Id: SmsClienLoginResult.java, v 0.1 2014-9-26 下午2:37:58 cold Exp
 *          $
 */
@Data
public class SmsClienLoginResult extends BaseResult {
	@ApiModelProperty(value = "成功放弃的客户端发送Id集合")
	private SmsClient smsClient;


}
