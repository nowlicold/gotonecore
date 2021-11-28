package com.yuan.gotonecore.api.sms.client.result;

import com.bench.common.model.BaseResult;
import com.yuan.gotonecore.api.sms.model.client.SmsClientSend;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;


/**
 * 客户端短信发送恢复结果
 * 
 * @author cold
 * 
 * @version $Id: SmsClientSendResumeResult.java, v 0.1 2014-9-26 下午3:35:03
 *          cold Exp $
 */
@Data
public class SmsClientSendResumeResult extends BaseResult {

	/**
	 * 客户端发送的短信列表
	 */
	@ApiModelProperty(value = "客户端发送的短信列表")
	private List<SmsClientSend> smsClientSendList;


}
