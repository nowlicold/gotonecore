package com.yuan.gotonecore.repository.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 沟通活动
 * </p>
 *
 * @author cold_auto
 * @since 2021-11-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("gtc_activity")
@ApiModel(value="ActivityDO对象", description="沟通活动")
public class ActivityDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "活动名称")
    private String activityName;

    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;

    @ApiModelProperty(value = "修改时间")
    private Date gmtModified;

    @ApiModelProperty(value = "备注")
    private String memo;

    @ApiModelProperty(value = "活动状态")
    private String activityStatus;

    @ApiModelProperty(value = "活动码")
    private String activityCode;


    public static final String ID = "id";

    public static final String ACTIVITY_NAME = "activity_name";

    public static final String GMT_CREATE = "gmt_create";

    public static final String GMT_MODIFIED = "gmt_modified";

    public static final String MEMO = "memo";

    public static final String ACTIVITY_STATUS = "activity_status";

    public static final String ACTIVITY_CODE = "activity_code";

}
