package com.yuan.gotonecore.service.sms.task;

import com.bench.xtask.BenchDistributeTask;
import com.bench.xtask.annotation.DistributeTask;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @className TestTask
 * @autor cold
 * @DATE 2021/6/28 16:14
 **/
@Component
@Slf4j
@DistributeTask(repeatIntervalMillseconds = 5000)
public class TestTask implements BenchDistributeTask {

    @Override
    public void execute() {
        log.info("开始执行task");
        System.out.println("TEST");
        log.info("执行task结束");
    }
}
