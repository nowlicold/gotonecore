package com.yuan.gotonecore.api.hello.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author by cold
 * @date 2020/12/15
 */
@ApiModel(description = "打招呼请求")
@Data
public class SayHelloRequest {

    @ApiModelProperty(value = "用户姓名")
    private String userName;

    @ApiModelProperty(value = "用户年龄")
    private Integer age;
}
