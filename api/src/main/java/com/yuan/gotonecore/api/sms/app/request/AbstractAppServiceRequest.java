package com.yuan.gotonecore.api.sms.app.request;

import com.bench.lang.base.object.ToStringObject;
import com.yuan.gotonecore.api.sms.model.enums.AppServiceNameEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.servlet.http.HttpServletRequest;


/**
 * 抽象的请求
 * 
 * @author cold
 * 
 * @version $Id: AbstractAppServiceRequest.java, v 0.1 2014-5-29 上午10:49:20
 *          cold Exp $
 */
@Data
public abstract class AbstractAppServiceRequest extends ToStringObject {

	@ApiModelProperty(value = "应用系统代码")
	protected String appCode;

	/**
	 * Http请求
	 */
	@ApiModelProperty(value = "Http请求")
	protected HttpServletRequest httpRequest;

	/**
	 * 返回服务名
	 * 
	 * @return
	 */
	@ApiModelProperty(value = "Http请求")
	public abstract AppServiceNameEnum getServiceName();

}
