package com.yuan.gotonecore.service.sms;

import java.util.List;

import org.springframework.cglib.beans.BeanCopier;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.bench.common.model.PageVO;
import com.yuan.gotonecore.api.sms.model.SmsChannelConfig;
import com.yuan.gotonecore.repository.entity.SmsChannelConfigDO;

/**
 * @className SmsChannelConfigConvert
 * @autor cold
 * @DATE 2021/5/23 19:51
 **/
public class SmsChannelConfigConvert {
    private static final BeanCopier ENTRY_TO_MODEL = BeanCopier
            .create(SmsChannelConfigDO.class, SmsChannelConfig.class, false);
    private static final BeanCopier PAGE_TO_PAGEDO = BeanCopier
            .create(Page.class, PageVO.class, false);
    public static SmsChannelConfig convert(SmsChannelConfigDO SmsChannelConfigDO) {
        SmsChannelConfig SmsChannelConfig = new SmsChannelConfig();
        ENTRY_TO_MODEL.copy(SmsChannelConfigDO, SmsChannelConfig, null);
        return SmsChannelConfig;
    }
    public static List<SmsChannelConfig> convertList(List<SmsChannelConfigDO> SmsChannelConfigDOList) {
        List<SmsChannelConfig> SmsChannelConfigList = Lists.newArrayList();
        SmsChannelConfigDOList.forEach(SmsChannelConfigDO -> {
            SmsChannelConfigList.add(convert(SmsChannelConfigDO));
        });
        return SmsChannelConfigList;
    }
    public static PageVO<SmsChannelConfig> convertPage(Page<SmsChannelConfigDO> page){
        return new PageVO<SmsChannelConfig>(convertList(page.getRecords()),page.getTotal(),page.getSize(),page.getPages(),page.getTotal());
    }

}
