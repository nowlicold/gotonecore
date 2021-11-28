package com.yuan.gotonecore.common;

import com.bench.common.model.BaseModel;
import com.yuan.gotonecore.common.enums.SmsInterceptObjectTypeEnum;

import java.util.Date;

/**
 * 短信黑名单
 *
 * @author fangbianmian
 * @version : SmsBlackList, v 0.1 2019/5/16 0016 15:46 fangbianmian Exp $$
 */
public class SmsBlackList extends BaseModel {

    private static final long serialVersionUID = -3350611449960924997L;
    /**
     * 主键id
     */
    private String id;

    /**
     * 拦截对象类型
     */
    private SmsInterceptObjectTypeEnum interceptObjectType;

    /**
     * 拦截对象值
     */
    private String interceptObjectValue;

    /**
     * 备注
     */
    private String memo;

    /**
     * 移除时间
     */
    private Date gmtRemove;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModified;

    /**
     * 是否有效
     */
    private boolean enabled;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SmsInterceptObjectTypeEnum getInterceptObjectType() {
        return interceptObjectType;
    }

    public void setInterceptObjectType(SmsInterceptObjectTypeEnum interceptObjectType) {
        this.interceptObjectType = interceptObjectType;
    }

    public String getInterceptObjectValue() {
        return interceptObjectValue;
    }

    public void setInterceptObjectValue(String interceptObjectValue) {
        this.interceptObjectValue = interceptObjectValue;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Date getGmtRemove() {
        return gmtRemove;
    }

    public void setGmtRemove(Date gmtRemove) {
        this.gmtRemove = gmtRemove;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
