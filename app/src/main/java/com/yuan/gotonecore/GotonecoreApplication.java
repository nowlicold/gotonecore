package com.yuan.gotonecore;

import com.yuan.gotonecore.service.msg.PushMessageChannel;
import com.yuan.gotonecore.service.msg.RecvMessageChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author by cold
 * @date 2020/12/13
 */
@Slf4j
/*
@EnableFeignClients(basePackages = {
        "com.jxmc.account.api.*",
        "com.jxmc.horn.api.*",
        "com.jxmc.member.api.*",
        "com.jxmc.erpcore.api.*"
})
*/
@SpringBootApplication(scanBasePackages = {
        "com.yuan",
        "com.bench"
})
@EnableScheduling
@EnableBinding({PushMessageChannel.class, RecvMessageChannel.class})
public class GotonecoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(GotonecoreApplication.class, args);
        log.info("gotonecoreApplication start success!");
        System.out.println("gotonecoreApplication start success!");
        System.out.println("http://localhost:11002/swagger-ui.html");
    }
}
