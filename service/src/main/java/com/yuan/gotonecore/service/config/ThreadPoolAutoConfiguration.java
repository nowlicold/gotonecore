package com.yuan.gotonecore.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池自动配置类
 *
 * @author cold
 * @date 2020/5/22
 */
@EnableAsync
@Configuration
public class ThreadPoolAutoConfiguration  {
    //创建发送的线程池
    @Bean(name = "sendSmsThreadPoolExecutor")
    public Executor sendSmsThreadPoolExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);//配置核心线程数
        executor.setMaxPoolSize(20);//配置最大线程数
        executor.setKeepAliveSeconds(5);
        executor.setQueueCapacity(200);//配置队列大小
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());//拒绝策略
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.initialize();//执行初始化
        return executor;
    }
    @Bean(name = "smsBlackListRemoveThreadPoolExecutor")
    public Executor smsBlackListRemoveThreadPoolExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);//配置核心线程数
        executor.setMaxPoolSize(20);//配置最大线程数
        executor.setKeepAliveSeconds(5);
        executor.setQueueCapacity(200);//配置队列大小
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());//拒绝策略
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.initialize();//执行初始化
        return executor;
    }
    @Bean(name = "sendSmsTaskThreadPoolExecutor")
    public Executor sendSmsTaskThreadPoolExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);//配置核心线程数
        executor.setMaxPoolSize(20);//配置最大线程数
        executor.setKeepAliveSeconds(5);
        executor.setQueueCapacity(200);//配置队列大小
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());//拒绝策略
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.initialize();//执行初始化
        return executor;
    }
    @Bean(name = "sendMailThreadPoolExecutor")
    public Executor sendMailThreadPoolExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);//配置核心线程数
        executor.setMaxPoolSize(20);//配置最大线程数
        executor.setKeepAliveSeconds(5);
        executor.setQueueCapacity(200);//配置队列大小
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());//拒绝策略
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.initialize();//执行初始化
        return executor;
    }
}
