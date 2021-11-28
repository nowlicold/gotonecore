package com.yuan.gotonecore.repository.entity;

import java.math.BigDecimal;
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
 * 邮件配置
 * </p>
 *
 * @author cold_auto
 * @since 2021-11-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("gtc_mail_config")
@ApiModel(value="MailConfigDO对象", description="邮件配置")
public class MailConfigDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编码")
    private String charset;

    @ApiModelProperty(value = "主题")
    private String subject;

    private Date gmtModified;

    private Date gmtCreate;

    @ApiModelProperty(value = "发送人姓名")
    private String fromName;

    @ApiModelProperty(value = "活动ID")
    private Integer activityId;

    @ApiModelProperty(value = "模板ID")
    private String configName;

    @ApiModelProperty(value = "主键，PK")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "是否有效")
    private Integer enabled;

    @ApiModelProperty(value = "发送失败后，重试间隔秒数")
    private BigDecimal retryIntervalSeconds;


    public static final String CHARSET = "charset";

    public static final String SUBJECT = "subject";

    public static final String GMT_MODIFIED = "gmt_modified";

    public static final String GMT_CREATE = "gmt_create";

    public static final String FROM_NAME = "from_name";

    public static final String ACTIVITY_ID = "activity_id";

    public static final String CONFIG_NAME = "config_name";

    public static final String ID = "id";

    public static final String ENABLED = "enabled";

    public static final String RETRY_INTERVAL_SECONDS = "retry_interval_seconds";

}
