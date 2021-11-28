package com.yuan.gotonecore.service.sms.task;

import java.util.List;
import java.util.concurrent.Executor;

import com.bench.lang.base.date.utils.DateUtils;
import com.bench.lang.base.list.utils.ListUtils;
import com.bench.lang.base.math.utils.MathUtils;
import com.bench.xtask.BenchDistributeTask;
import com.bench.xtask.annotation.DistributeTask;
import com.yuan.gotonecore.api.sms.result.SmsBlackListOperateResult;
import com.yuan.gotonecore.repository.entity.SmsBlackListDO;
import com.yuan.gotonecore.repository.mapper.SmsBlackListMapper;
import com.yuan.gotonecore.service.sms.SmsBlackListManageComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 短信黑名单移除task
 *
 * @author fangbianmian
 * @version : SmsBlackListRemoveTask, v 0.1 2019/5/16 0016 22:05 fangbianmian Exp $$
 */
@DistributeTask(repeatIntervalMillseconds = 2000)
@Slf4j
@Component
public class SmsBlackListRemoveTask implements BenchDistributeTask {


    /**
     * 发送短信线程执行器
     */
    @Autowired
    private Executor smsBlackListRemoveThreadPoolExecutor;

    @Autowired
    private SmsBlackListMapper smsBlackListMapper;

    @Autowired
    private SmsBlackListManageComponent smsBlackListManageComponent;

    @Override
    public void execute() {
        List<SmsBlackListDO> smsBlackListDOS = smsBlackListMapper.selectReadyToRemove(100);
        List<List<SmsBlackListDO>> averageList = MathUtils.average(smsBlackListDOS, 4);

        for (final List<SmsBlackListDO> eachList : averageList) {
            if (ListUtils.isEmpty(eachList)) {
                continue;
            }
            for (final SmsBlackListDO smsBlackListDO : eachList) {
                smsBlackListRemoveThreadPoolExecutor.execute(new Runnable() {
                    public void run() {
                        //还没到移除时间
                        if (!DateUtils.isBeforeNow(smsBlackListDO.getGmtRemove())) {
                            return;
                        }
                        SmsBlackListOperateResult result = smsBlackListManageComponent.remove(smsBlackListDO.getId());
                        if (!result.isSuccess()) {
                            log.error("短信黑名单移除失败：" + smsBlackListDO);
                        }
                    }
                });
            }
        }
    }
}
