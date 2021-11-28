package com.yuan.gotonecore.api.sms.client.result;

import com.bench.common.model.BaseResult;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 客户端短信发送放弃结果
 * 
 * @author cold
 * 
 * @version $Id: SmsClientSendResumeResult.java, v 0.1 2014-9-26 下午3:35:03
 *          cold Exp $
 */
@Data
public class SmsClientSendGiveupResult extends BaseResult {
	/**
	 * 成功放弃的客户端发送Id集合
	 */
	@ApiModelProperty(value = "成功放弃的客户端发送Id集合")
	private List<Long> giveupSmsClientSendIds;

	/**
	 * @return Returns the giveupSmsClientSendIds.
	 */
	@ApiModelProperty(value = "giveupSmsClientSendIds")
	public List<Long> getGiveupSmsClientSendIds() {
		return giveupSmsClientSendIds;
	}

}
