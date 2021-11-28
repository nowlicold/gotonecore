/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.api.sms.result;
import com.bench.common.model.PageVO;
import com.yuan.gotonecore.api.sms.model.SmsConfig;
import com.yuan.gotonecore.api.sms.model.SmsOutHis;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 短信息发送历史记录查询请求集合
 * 
 * @author Debug
 * 
 * @version $Id: SmsOutHisQueryResult.java, v 0.1 2011-9-29 下午12:54:24 Debug Exp
 *          $
 */
@Data
public class SmsOutHisQueryResult {
	@ApiModelProperty(value="分页器")
	PageVO<SmsOutHis> page;

}
