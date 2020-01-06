package com.bdf.wechatarticle.springconfig.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 说明：
 * </p>
 *
 * @author 张强<zq15302026066@163.com>
 * @date 2020/1/6 11:51
 */
@Data
@Component
@RefreshScope
@ConfigurationProperties(prefix="thread.pool")
public class ThreadPoolTaskProperties {

    /**
     * 调度器并发配置
     */
    @NestedConfigurationProperty
    private TaskScheduler taskScheduler;

    /**
     * 执行器并发配置
     */
    @NestedConfigurationProperty
    private TaskExecutor taskExecutor;

    @Data
    public static class TaskScheduler {

        private String schedulerNamePrefix;

        private int poolSize;

        private int awaitTerminationSeconds;
    }

    @Data
    public static class TaskExecutor {

        private String executorNamePrefix;

        private int corePoolSize;

        private int maxPoolSize;

        private int queueCapacity;

        private int keepAliveSeconds;
    }

}
