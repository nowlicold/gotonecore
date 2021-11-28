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
 * 邮件发送历史表
 * </p>
 *
 * @author cold_auto
 * @since 2021-11-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("gtc_mail_out_history")
@ApiModel(value="MailOutHistoryDO对象", description="邮件发送历史表")
public class MailOutHistoryDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键，PK")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "接收人")
    private String receiver;

    @ApiModelProperty(value = "用户ID")
    private String userId;

    @ApiModelProperty(value = "状态")
    private String status;

    @ApiModelProperty(value = "调度时间")
    private Date gmtSchedule;

    @ApiModelProperty(value = "修改时间")
    private Date gmtModified;

    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;

    @ApiModelProperty(value = "邮件消息创建时间")
    private Date gmtMailMsgCreate;

    @ApiModelProperty(value = "抄送")
    private String mailCc;

    @ApiModelProperty(value = "密送")
    private String mailBcc;

    @ApiModelProperty(value = "回复")
    private String mailReplayTo;

    @ApiModelProperty(value = "主题")
    private String mailSubject;

    @ApiModelProperty(value = "发送人")
    private String mailFrom;

    @ApiModelProperty(value = "消息属性")
    private String properties;

    @ApiModelProperty(value = "邮件通道")
    private String channel;

    @ApiModelProperty(value = "发送端ID")
    private Integer sendClientId;

    @ApiModelProperty(value = "邮件模板配置ID")
    private Integer mailConfigId;

    @ApiModelProperty(value = "活动编号")
    private Integer activityId;

    @ApiModelProperty(value = "发送次数")
    private BigDecimal sendTimes;

    @ApiModelProperty(value = "模板参数")
    private String templateArgs;

    @ApiModelProperty(value = "发送的用户ID")
    private Integer mailUserConfigId;

    @ApiModelProperty(value = "邮件内容的生成模式")
    private String mailBodyPattern;


    public static final String ID = "id";

    public static final String RECEIVER = "receiver";

    public static final String USER_ID = "user_id";

    public static final String STATUS = "status";

    public static final String GMT_SCHEDULE = "gmt_schedule";

    public static final String GMT_MODIFIED = "gmt_modified";

    public static final String GMT_CREATE = "gmt_create";

    public static final String GMT_MAIL_MSG_CREATE = "gmt_mail_msg_create";

    public static final String MAIL_CC = "mail_cc";

    public static final String MAIL_BCC = "mail_bcc";

    public static final String MAIL_REPLAY_TO = "mail_replay_to";

    public static final String MAIL_SUBJECT = "mail_subject";

    public static final String MAIL_FROM = "mail_from";

    public static final String PROPERTIES = "properties";

    public static final String CHANNEL = "channel";

    public static final String SEND_CLIENT_ID = "send_client_id";

    public static final String MAIL_CONFIG_ID = "mail_config_id";

    public static final String ACTIVITY_ID = "activity_id";

    public static final String SEND_TIMES = "send_times";

    public static final String TEMPLATE_ARGS = "template_args";

    public static final String MAIL_USER_CONFIG_ID = "mail_user_config_id";

    public static final String MAIL_BODY_PATTERN = "mail_body_pattern";

}
