/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.api.sms.client.result;

import com.bench.common.model.BaseResult;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;


/**
 * 
 * @author cold
 * 
 * @version $Id: SmsClientSendResultUpdateResult.java, v 0.1 2014-9-26 下午2:58:05
 *          cold Exp $
 */
@Data
public class SmsClientSendResultUpdateResult extends BaseResult {
	@ApiModelProperty(value = "updateResultEntries")
	private List<SmsClientSendResultUpdateResultEntry> updateResultEntries;

}
