/**
 * 
 */
package com.yuan.gotonecore.api.sms.result;

import com.bench.common.model.BaseResult;
import io.swagger.annotations.ApiModelProperty;

/**
 * 短息配置操作结果集
 * 
 * @author cold
 *
 * @version $Id: SmsConfigOperateResult.java, v 0.1 2016年8月24日 下午4:45:35 Admin
 *          Exp $
 */
public class SmsConfigOperateResult extends BaseResult {
	@ApiModelProperty(value = "编号")
	private long id;
}
