package com.bdf.wechatarticle.springconfig.redis;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.integration.redis.util.RedisLockRegistry;

/**
 * @author zhangqiang
 */
@Configuration
public class RedisLockConfiguration {

    @Value("${spring.application.name}")
    private String projectName;

    @Bean
    public RedisLockRegistry redisLockRegistry(RedisConnectionFactory redisConnectionFactory) {
        //锁默认释放时间
        long expireAfter = 10 * 60 * 1000L;
        return new RedisLockRegistry(redisConnectionFactory, projectName, expireAfter);
    }
}
