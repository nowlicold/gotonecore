package com.yuan.gotonecore.service.sms.impl;

import com.bench.cache.local.AbstractGmtModifiedRefreshableCacheComponent;
import com.bench.lang.base.array.utils.ArrayUtils;
import com.bench.lang.base.object.utils.ObjectUtils;
import com.bench.lang.base.string.utils.StringUtils;
import com.yuan.gotonecore.api.sms.model.SmsChannelConfig;
import com.yuan.gotonecore.api.sms.model.enums.SmsChannelEnum;
import com.yuan.gotonecore.repository.mapper.SmsChannelConfigMapper;
import com.yuan.gotonecore.service.sms.SmsChannelConfigConvert;
import com.yuan.gotonecore.service.sms.SmsChannelConfigQueryComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @className SmsChannelConfigQueryComponent
 * @autor cold
 * @DATE 2021/6/22 0:38
 **/
@Service
@Slf4j
public class SmsChannelConfigQueryComponentImpl extends AbstractGmtModifiedRefreshableCacheComponent<SmsChannelConfig,SmsChannelEnum> implements SmsChannelConfigQueryComponent {
    @Autowired
    private SmsChannelConfigMapper smsChannelConfigMapper;
    @Override
    public SmsChannelConfig getByChannelCode(SmsChannelEnum channel) {
        return super.getObject(channel);
    }

    @Override
    public SmsChannelConfig selectSmsChannel(String cell, SmsChannelEnum[] channels) {
        List<SmsChannelConfig> supportSmsChannelConfigList = new ArrayList<SmsChannelConfig>();
        if (ArrayUtils.isEmpty(channels)) {
            for (SmsChannelConfig channelConfig : super.getAll()) {
                if (channelConfig.isEnabled()) {
                    supportSmsChannelConfigList.add(channelConfig);
                }
            }
        } else {
            for (SmsChannelEnum channel : channels) {
                SmsChannelConfig channelConfig = getByChannelCode(channel);
                if (channelConfig == null) {
                    return null;
                }
                if (channelConfig.isEnabled()) {
                    supportSmsChannelConfigList.add(channelConfig);
                }
            }
        }
        if (supportSmsChannelConfigList.size() == 0) {
            return null;
        }
        // 权重排序
        Collections.sort(supportSmsChannelConfigList, new Comparator<SmsChannelConfig>() {
            @Override
            public int compare(SmsChannelConfig o1, SmsChannelConfig o2) {
                return o1.getWeight() - o2.getWeight();
            }
        });
        // 先按精确匹配查找，如138,136之类的
        for (SmsChannelConfig channelConfig : supportSmsChannelConfigList) {
            if (channelConfig.supportPrefixCell(cell)) {
                return channelConfig;
            }
        }
        // 全匹配查找，如*
        for (SmsChannelConfig channelConfig : supportSmsChannelConfigList) {
            if (channelConfig.supportAllCell()) {
                return channelConfig;
            }
        }

        log.error("无法选择短信通道配置，cell=" + cell + ",channels=" + ObjectUtils.toString(channels));
        return null;
    }

    @Override
    protected List loadAll() {
        return SmsChannelConfigConvert.convertList(smsChannelConfigMapper.selectAll());
    }

    @Override
    protected List<SmsChannelConfig> loadLargeThan(Date maxRefreshCompareValue) {
        return SmsChannelConfigConvert.convertList(smsChannelConfigMapper.selectGreaterThanModifiedDate(maxRefreshCompareValue));
    }

    @Override
    public List<SmsChannelConfig> getAllEnabled() {
        List<SmsChannelConfig> smsChannelConfigs = new ArrayList<SmsChannelConfig>();
        for (SmsChannelConfig smsChannelConfig : this.getAll()) {
            if (smsChannelConfig.isEnabled()) {
                smsChannelConfigs.add(smsChannelConfig);
            }
        }
        return smsChannelConfigs;
    }
}
