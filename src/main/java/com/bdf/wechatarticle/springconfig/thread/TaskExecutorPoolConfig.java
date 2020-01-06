package com.bdf.wechatarticle.springconfig.thread;

import com.bdf.wechatarticle.springconfig.properties.ThreadPoolTaskProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池配置
 *
 * @author 张强 <15302026066@163.com>
 * @date 2018/10/15
 */
@Configuration
@EnableAsync
public class TaskExecutorPoolConfig {

    @Bean(destroyMethod = "shutdown")
    public ThreadPoolTaskScheduler taskScheduler(ThreadPoolTaskProperties threadPoolTaskProperties) {
        ThreadPoolTaskProperties.TaskScheduler taskScheduler = threadPoolTaskProperties.getTaskScheduler();
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(taskScheduler.getPoolSize());
        // 设置线程名开头
        scheduler.setThreadNamePrefix(taskScheduler.getSchedulerNamePrefix());
        scheduler.setAwaitTerminationSeconds(taskScheduler.getPoolSize());
        scheduler.setWaitForTasksToCompleteOnShutdown(true);
        return scheduler;
    }

    @Bean(destroyMethod = "shutdown")
    public ThreadPoolTaskExecutor threadPoolTaskExecutor(ThreadPoolTaskProperties threadPoolTaskProperties) {
        ThreadPoolTaskProperties.TaskExecutor taskExecutor = threadPoolTaskProperties.getTaskExecutor();
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(taskExecutor.getCorePoolSize());
        executor.setMaxPoolSize(taskExecutor.getMaxPoolSize());
        executor.setQueueCapacity(taskExecutor.getQueueCapacity());
        executor.setKeepAliveSeconds(taskExecutor.getKeepAliveSeconds());
        executor.setThreadNamePrefix(taskExecutor.getExecutorNamePrefix());
        executor.setAllowCoreThreadTimeOut(false);

        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是由调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }

}
