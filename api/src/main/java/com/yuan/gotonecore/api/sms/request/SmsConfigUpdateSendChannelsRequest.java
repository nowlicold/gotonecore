/**
 * 
 */
package com.yuan.gotonecore.api.sms.request;

import com.yuan.gotonecore.api.sms.model.enums.SmsChannelEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 短信配置修改发送通道请求
 * 
 * @author cold
 *
 * @version $Id: SmsConfigUpdateSendChannelsRequest.java, v 0.1 2016年8月24日
 *          下午4:47:07 Admin Exp $
 */
@Data
public class SmsConfigUpdateSendChannelsRequest {

	/**
	 * 发送通道
	 */
	@ApiModelProperty(value="发送通道")
	private SmsChannelEnum sendChannel;

	/**
	 * ids
	 */
	@ApiModelProperty(value="ids")
	private List<Long> ids;


}
