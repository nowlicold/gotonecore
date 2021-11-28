package com.yuan.gotonecore.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @className User
 * @autor cold
 * @DATE 2021/5/23 19:38
 **/
@Data
public class User implements Serializable {

    @ApiModelProperty(value = "编号")
    private Integer id;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;
    @ApiModelProperty(value = "修改时间")
    private Date gmtModified;

}
