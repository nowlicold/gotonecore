package com.yuan.gotonecore.api.user.request;

import com.bench.common.model.PageRequest;
import com.yuan.gotonecore.api.user.enums.UserOrderByEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @className UserSearchRequest
 * @autor cold
 * @DATE 2021/5/23 19:56
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class UserSearchRequest extends PageRequest {
    @ApiModelProperty("名称")
    private String name;
    @ApiModelProperty("编号")
    private Integer id;
    @ApiModelProperty("编号清单")
    private List<Integer> ids;
    @ApiModelProperty("排序值")
    private UserOrderByEnum orderByEnum;

}
