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
 * 
 * </p>
 *
 * @author cold_auto
 * @since 2021-11-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("gtc_mail_out_history_body")
@ApiModel(value="MailOutHistoryBodyDO对象", description="")
public class MailOutHistoryBodyDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "邮件ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "邮件发送后的内容")
    private String mailBody;

    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;


    public static final String ID = "id";

    public static final String MAIL_BODY = "mail_body";

    public static final String GMT_CREATE = "gmt_create";

}
