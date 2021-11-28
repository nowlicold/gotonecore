package com.yuan.gotonecore.repository.service;

import com.bench.common.model.PageVO;
import com.yuan.gotonecore.GotonecoreApplication;
import com.yuan.gotonecore.api.model.User;
import com.yuan.gotonecore.api.request.MailSendRequest;
import com.yuan.gotonecore.api.result.GotoneCoreServiceResult;
import com.yuan.gotonecore.api.user.enums.UserOrderByEnum;
import com.yuan.gotonecore.api.user.request.UserSearchRequest;
import com.yuan.gotonecore.common.enums.GotoneChannelEnum;
import com.yuan.gotonecore.common.enums.MailBodyPatternTypeEnum;
import com.yuan.gotonecore.service.mail.SendMailService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @className MailSendServiceTest
 * @autor cold
 * @DATE 2021-11-24 10:22
 **/
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = GotonecoreApplication.class)
public class SendMailServiceTest {
    @Autowired
    private SendMailService sendMailService;
    @Test
    public void sendMail(){
        MailSendRequest request = new MailSendRequest();
        request.setMailConfigName("test_config");
        request.setMailBodyPattern(MailBodyPatternTypeEnum.BY_TEMPLATE);
        request.setTemplateArgs(new HashMap<>());
        request.getTemplateArgs().put("url","http://www.baidu.com");
        request.setMailSubject("日报邮件");
        request.setReceiver("yuanbo521@qq.com");
        request.setChannel(GotoneChannelEnum.DEFAULT);
        GotoneCoreServiceResult gotoneCoreServiceResult =  sendMailService.doMailSend(request);
        System.out.println(gotoneCoreServiceResult);
    }
}
