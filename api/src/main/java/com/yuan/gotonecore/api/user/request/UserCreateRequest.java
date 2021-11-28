package com.yuan.gotonecore.api.user.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @className UserCreateRequest
 * @autor cold
 * @DATE 2021/6/18 1:23
 **/
@Data
public class UserCreateRequest {
    @ApiModelProperty("名称")
    private String name;
}
