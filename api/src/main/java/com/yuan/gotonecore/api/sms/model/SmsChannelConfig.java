package com.yuan.gotonecore.api.sms.model;

import com.bench.lang.base.string.utils.StringUtils;
import com.bench.common.cache.local.GmtModifiedRefreshableCacheObject;
import com.bench.common.model.BaseModel;
import com.yuan.gotonecore.api.sms.model.enums.SmsChannelEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.Map;

/**
 * @className SmsChannelConfig
 * @autor cold
 * @DATE 2021/6/22 0:33
 **/
@Data
public class SmsChannelConfig extends BaseModel  implements GmtModifiedRefreshableCacheObject<SmsChannelEnum> {
    @ApiModelProperty(value = "通道名称")
    private SmsChannelEnum channel;

    /**
     * 支持的手机号前缀
     */
    @ApiModelProperty(value = "支持的手机号前缀")
    private String supportCellPrefix;

    /**
     * 附加内容前缀
     */
    @ApiModelProperty(value = "附加内容前缀")
    private String contentAppendPrefix;

    /**
     * 附加内容后缀
     */
    @ApiModelProperty(value = "附加内容后缀")
    private String contentAppendSuffix;

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
     * 权重，值大的通道优先考虑
     */
    @ApiModelProperty(value = "权重，值大的通道优先考虑")
    private int weight;

    /**
     * 是否有效
     */
    @ApiModelProperty(value = "是否有效")
    private boolean enabled;

    /**
     * 运行模式
     */
    @ApiModelProperty(value = "运行模式")
    private String runMode;

    /**
     * 属性集合
     */
    @ApiModelProperty(value = "属性集合")
    private Map<String, String> properties;
    /**
     * 支持的手机号前缀
     */
    @ApiModelProperty(value = "支持的手机号前缀")
    private String[] supportCellPrefixs;
    @Override
    public SmsChannelEnum returnCacheKey() {
        return this.channel;
    }
    /**
     * 是否支持该手机号前缀
     *
     * @param cell
     * @return
     */
    public boolean supportPrefixCell(String cell) {
        for (String supportCellPrefix : this.supportCellPrefixs) {
            if (StringUtils.startsWith(cell, supportCellPrefix)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 是否支持所有手机号
     *
     * @return
     */
    public boolean supportAllCell() {
        for (String supportCellPrefix : this.supportCellPrefixs) {
            if (StringUtils.equals(supportCellPrefix, StringUtils.ASTERRISK_SIGN)) {
                return true;
            }
        }
        return false;
    }
}
