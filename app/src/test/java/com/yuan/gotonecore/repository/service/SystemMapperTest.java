package com.yuan.gotonecore.repository.service;

import com.yuan.gotonecore.GotonecoreApplication;
import com.yuan.gotonecore.repository.mapper.SystemMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @className SystemMapperTest
 * @autor cold
 * @DATE 2021-12-02 16:26
 **/
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = GotonecoreApplication.class)
public class SystemMapperTest {
    @Resource
    private SystemMapper systemMapper;
    @Test
    public void testDate(){
        System.out.println("时间为"+systemMapper.getCurrentDate());;
    }

}
