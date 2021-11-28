package com.yuan.gotonecore.api.sms.model;

import com.bench.common.model.BaseModel;
import com.yuan.gotonecore.api.sms.model.enums.SmsInterceptObjectTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @className SmsBlackList
 * @autor cold
 * @DATE 2021/6/25 0:21
 **/
@Data
public class SmsBlackList extends BaseModel {
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private String id;

    /**
     * 拦截对象类型
     */
    @ApiModelProperty(value = "拦截对象类型")
    private SmsInterceptObjectTypeEnum interceptObjectType;

    /**
     * 拦截对象值
     */
    @ApiModelProperty(value = "拦截对象值")
    private String interceptObjectValue;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String memo;

    /**
     * 移除时间
     */
    @ApiModelProperty(value = "移除时间")
    private Date gmtRemove;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    private Date gmtModified;

    /**
     * 是否有效
     */
    @ApiModelProperty(value = "是否有效")
    private boolean enabled;
}
