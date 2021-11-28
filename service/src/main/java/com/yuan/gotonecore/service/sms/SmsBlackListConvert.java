package com.yuan.gotonecore.service.sms;

import java.util.List;

import org.springframework.cglib.beans.BeanCopier;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.bench.common.model.PageVO;
import com.yuan.gotonecore.api.sms.model.SmsBlackList;
import com.yuan.gotonecore.repository.entity.SmsBlackListDO;

/**
 * @className SmsBlackListConvert
 * @autor cold
 * @DATE 2021/5/23 19:51
 **/
public class SmsBlackListConvert {
    private static final BeanCopier ENTRY_TO_MODEL = BeanCopier
            .create(SmsBlackListDO.class, SmsBlackList.class, false);
    private static final BeanCopier PAGE_TO_PAGEDO = BeanCopier
            .create(Page.class, PageVO.class, false);
    public static SmsBlackList convert(SmsBlackListDO SmsBlackListDO) {
        SmsBlackList SmsBlackList = new SmsBlackList();
        ENTRY_TO_MODEL.copy(SmsBlackListDO, SmsBlackList, null);
        return SmsBlackList;
    }
    public static List<SmsBlackList> convertList(List<SmsBlackListDO> SmsBlackListDOList) {
        List<SmsBlackList> SmsBlackListList = Lists.newArrayList();
        SmsBlackListDOList.forEach(SmsBlackListDO -> {
            SmsBlackListList.add(convert(SmsBlackListDO));
        });
        return SmsBlackListList;
    }
    public static PageVO<SmsBlackList> convertPage(Page<SmsBlackListDO> page){
        return new PageVO<SmsBlackList>(convertList(page.getRecords()),page.getTotal(),page.getSize(),page.getPages(),page.getTotal());
    }

}
