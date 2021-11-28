package com.yuan.gotonecore.api.user.result;

import com.bench.common.model.BaseResult;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 @className UserCreateResult
 @autor cold
 @DATE 2021/6/18 1:45
 **/
@Data
public class UserCreateResult extends BaseResult {
    @ApiModelProperty(value = "编号")
    private Integer id;
}
