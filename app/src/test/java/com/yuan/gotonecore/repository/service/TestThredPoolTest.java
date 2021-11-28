package com.yuan.gotonecore.repository.service;

import com.bench.runtime.consts.ApplicationProperties;
import com.yuan.gotonecore.service.sms.SmsSendComponent;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Executor;

/**
 * @className TestThredPool
 * @autor cold
 * @DATE 2021/6/25 20:47
 **/

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestThredPoolTest {
    @Autowired
    private SmsSendComponent smsSendComponent;
    @Test
    public void testApplicationProperties(){
    }
    @Test
    public void testThredPool(){
        smsSendComponent.ThredTest();

    }
}
