package com.bdf.wechatarticle.springconfig.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

/**
 * <p>
 *   说明: 事务管理器配置
 * </p>
 * @author 张强<zq15302026066@163.com>
 * @date  2019/4/27 0:01
 */
@Configuration
public class PlatformTransactionManagerConfiguration implements TransactionManagementConfigurer {

    private final DataSource dataSource;

    @Autowired
    public PlatformTransactionManagerConfiguration(@Qualifier("dataSource") DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean("txManager")
    public PlatformTransactionManager txManager() {
        return new DataSourceTransactionManager(dataSource);
    }

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return txManager();
    }

}
