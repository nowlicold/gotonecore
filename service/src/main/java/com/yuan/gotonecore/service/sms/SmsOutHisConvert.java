package com.yuan.gotonecore.service.sms;

import java.util.List;

import org.springframework.cglib.beans.BeanCopier;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.bench.common.model.PageVO;
import com.yuan.gotonecore.api.sms.model.SmsOutHis;
import com.yuan.gotonecore.repository.entity.SmsOutHisDO;

/**
 * @className SmsOutHisConvert
 * @autor cold
 * @DATE 2021/5/23 19:51
 **/
public class SmsOutHisConvert {
    private static final BeanCopier ENTRY_TO_MODEL = BeanCopier
            .create(SmsOutHisDO.class, SmsOutHis.class, false);
    private static final BeanCopier PAGE_TO_PAGEDO = BeanCopier
            .create(Page.class, PageVO.class, false);
    public static SmsOutHis convert(SmsOutHisDO SmsOutHisDO) {
        SmsOutHis SmsOutHis = new SmsOutHis();
        ENTRY_TO_MODEL.copy(SmsOutHisDO, SmsOutHis, null);
        return SmsOutHis;
    }
    public static List<SmsOutHis> convertList(List<SmsOutHisDO> SmsOutHisDOList) {
        List<SmsOutHis> SmsOutHisList = Lists.newArrayList();
        SmsOutHisDOList.forEach(SmsOutHisDO -> {
            SmsOutHisList.add(convert(SmsOutHisDO));
        });
        return SmsOutHisList;
    }
    public static PageVO<SmsOutHis> convertPage(Page<SmsOutHisDO> page){
        return new PageVO<SmsOutHis>(convertList(page.getRecords()),page.getTotal(),page.getSize(),page.getPages(),page.getTotal());
    }

}
