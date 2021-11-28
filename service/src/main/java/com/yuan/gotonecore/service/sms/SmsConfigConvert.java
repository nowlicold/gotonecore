package com.yuan.gotonecore.service.sms;

import java.util.List;

import com.yuan.gotonecore.api.sms.model.SmsConfig;
import org.springframework.cglib.beans.BeanCopier;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.bench.common.model.PageVO;
import com.yuan.gotonecore.repository.entity.SmsConfigDO;

/**
 * @className SmsConfigConvert
 * @autor cold
 * @DATE 2021/5/23 19:51
 **/
public class SmsConfigConvert {
    private static final BeanCopier ENTRY_TO_MODEL = BeanCopier
            .create(SmsConfigDO.class, SmsConfig.class, false);
    private static final BeanCopier PAGE_TO_PAGEDO = BeanCopier
            .create(Page.class, PageVO.class, false);
    public static SmsConfig convert(SmsConfigDO SmsConfigDO) {
        SmsConfig SmsConfig = new SmsConfig();
        ENTRY_TO_MODEL.copy(SmsConfigDO, SmsConfig, null);
        return SmsConfig;
    }
    public static List<SmsConfig> convertList(List<SmsConfigDO> SmsConfigDOList) {
        List<SmsConfig> SmsConfigList = Lists.newArrayList();
        SmsConfigDOList.forEach(SmsConfigDO -> {
            SmsConfigList.add(convert(SmsConfigDO));
        });
        return SmsConfigList;
    }
    public static PageVO<SmsConfig> convertPage(Page<SmsConfigDO> page){
        return new PageVO<SmsConfig>(convertList(page.getRecords()),page.getTotal(),page.getSize(),page.getPages(),page.getTotal());
    }

}
