package com.yuan.gotonecore.repository.service;

import com.yuan.gotonecore.api.user.request.UserCreateRequest;
import com.yuan.gotonecore.api.user.result.UserCreateResult;
import com.yuan.gotonecore.service.user.UserCreateComponent;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @className UserTest
 * @autor cold
 * @DATE 2021/6/18 2:24
 **/
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserCreateComponentTest {
    @Autowired
    private UserCreateComponent userCreateComponent;
    @Test
    public void create(){
        UserCreateRequest request = new UserCreateRequest();
        request.setName("test2");
        UserCreateResult result = userCreateComponent.create(request);
        log.info("result{}",result);

    }
}
