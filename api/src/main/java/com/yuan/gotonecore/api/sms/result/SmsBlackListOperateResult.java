package com.yuan.gotonecore.api.sms.result;

import com.bench.common.model.BaseResult;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @className SmsBlackListOperateResult
 * @autor cold
 * @DATE 2021/6/25 0:33
 **/
@Data
public class SmsBlackListOperateResult extends BaseResult {
    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private String id;
}
