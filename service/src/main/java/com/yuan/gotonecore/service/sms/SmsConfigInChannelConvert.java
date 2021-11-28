package com.yuan.gotonecore.service.sms;

import java.util.List;

import org.springframework.cglib.beans.BeanCopier;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.bench.common.model.PageVO;
import com.yuan.gotonecore.api.sms.model.SmsConfigInChannel;
import com.yuan.gotonecore.repository.entity.SmsConfigInChannelDO;

/**
 * @className SmsConfigInChannelConvert
 * @autor cold
 * @DATE 2021/5/23 19:51
 **/
public class SmsConfigInChannelConvert {
    private static final BeanCopier ENTRY_TO_MODEL = BeanCopier
            .create(SmsConfigInChannelDO.class, SmsConfigInChannel.class, false);
    private static final BeanCopier PAGE_TO_PAGEDO = BeanCopier
            .create(Page.class, PageVO.class, false);
    public static SmsConfigInChannel convert(SmsConfigInChannelDO SmsConfigInChannelDO) {
        SmsConfigInChannel SmsConfigInChannel = new SmsConfigInChannel();
        ENTRY_TO_MODEL.copy(SmsConfigInChannelDO, SmsConfigInChannel, null);
        return SmsConfigInChannel;
    }
    public static List<SmsConfigInChannel> convertList(List<SmsConfigInChannelDO> SmsConfigInChannelDOList) {
        List<SmsConfigInChannel> SmsConfigInChannelList = Lists.newArrayList();
        SmsConfigInChannelDOList.forEach(SmsConfigInChannelDO -> {
            SmsConfigInChannelList.add(convert(SmsConfigInChannelDO));
        });
        return SmsConfigInChannelList;
    }
    public static PageVO<SmsConfigInChannel> convertPage(Page<SmsConfigInChannelDO> page){
        return new PageVO<SmsConfigInChannel>(convertList(page.getRecords()),page.getTotal(),page.getSize(),page.getPages(),page.getTotal());
    }

}
