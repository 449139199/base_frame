package com.bdf.wechatarticle.springconfig.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * 创建时间：2019-01-13
 * 类名：PageProperties
 * 描述：mybatis 分页配置
 * @author : 张强 <zq15302026066@163.com>
 * @version : v1.0
 */
@Data
@Component
@RefreshScope
@ConfigurationProperties(prefix = "mybatis.page")
public class PageProperties {

    private int defaultPageSize;

    private int maxPageSize;

}
