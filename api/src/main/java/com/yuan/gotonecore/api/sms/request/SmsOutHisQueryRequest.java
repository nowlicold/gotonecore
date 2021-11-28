package com.yuan.gotonecore.api.sms.request;

import com.bench.common.model.PageRequest;
import com.yuan.gotonecore.api.model.enums.MessageStatusEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 查询短信息历史发送数据请求
 * 
 * @author Debug
 * 
 * @version $Id: GtSmsOutHisQueryRequest.java, v 0.1 2011-9-29 下午12:52:55 Debug
 *          Exp $
 */
@Data
public class SmsOutHisQueryRequest extends PageRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3483434224310995052L;

	/**
	 * 接收人手机号
	 */
	@ApiModelProperty(value = "接收人手机号")
	private String receiver;

	/**
	 * 用户ID
	 */
	@ApiModelProperty(value = "用户ID")
	private String userId;

	/**
	 * 发送状态
	 */
	@ApiModelProperty(value = "发送状态")
	private MessageStatusEnum status;


}
