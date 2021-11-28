package com.yuan.gotonecore.api.sms.request;

import com.yuan.gotonecore.api.sms.model.enums.SmsInterceptObjectTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @className SmsBlackListCreateRequest
 * @autor cold
 * @DATE 2021/6/25 0:30
 **/
@Data
public class SmsBlackListCreateRequest {
    /**
     * 拦截对象类型
     */
    @ApiModelProperty(value="拦截对象类型")
    private SmsInterceptObjectTypeEnum interceptObjectType;

    /**
     * 拦截对象值
     */
    @ApiModelProperty(value="拦截对象值")
    private String interceptObjectValue;

    /**
     * 备注
     */
    @ApiModelProperty(value="备注")
    private String memo;

    /**
     * 移除时间
     */
    @ApiModelProperty(value="移除时间")
    private Date gmtRemove;
}
