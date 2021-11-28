/**
 * 
 */
package com.yuan.gotonecore.api.sms.result;

import java.util.List;
import com.bench.common.model.PageVO;
import com.yuan.gotonecore.api.sms.model.SmsConfig;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 短信配置分页查询结果集
 * @author cold
 *
 * @version $Id: SmsConfigPageQueryResult.java, v 0.1 2016年8月24日 下午4:31:02 Admin Exp $
 */
@Data
public class SmsConfigPageQueryResult {

	/**
	 * 分页器
	 */
	@ApiModelProperty(value="分页器")
	PageVO<SmsConfig> page;

	
	
	
}
