/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.api.sms.result;
import com.bench.common.model.PageVO;
import com.yuan.gotonecore.api.sms.model.SmsConfig;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * @author Debug
 * 
 * @version $Id: SmsOutQueryResult.java, v 0.1 2011-9-29 下午12:27:03 Debug Exp $
 */
@Data
public class SmsOutQueryResult {

	@ApiModelProperty(value="分页器")
	PageVO<SmsConfig> page;
}
