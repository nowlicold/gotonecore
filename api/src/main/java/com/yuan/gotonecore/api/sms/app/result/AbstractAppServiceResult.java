package com.yuan.gotonecore.api.sms.app.result;

import java.util.Date;

import com.bench.lang.base.date.utils.DateUtils;
import com.bench.common.enums.EnumBase;
import com.bench.common.model.BaseResult;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 抽象Response
 * 
 * @author cold
 * 
 * @version $Id: AbstractAppServiceResponse.java, v 0.1 2014-5-29 上午10:52:24
 *          cold Exp $
 */
@Data
public abstract class AbstractAppServiceResult extends BaseResult {


	@ApiModelProperty(value = "当前时间")
	private String nowDate = DateUtils.getNewFormatDateString(new Date());

}
