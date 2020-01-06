package com.bdf.wechatarticle.springconfig.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * 创建时间：2019-01-13
 * 类名：SwaggerProperties
 * 描述：swagger 配置
 * @author : 张强 <zhangqiang@miaozhen.com>
 * @version : v1.0
 */
@Data
@Component
@RefreshScope
@ConfigurationProperties(prefix = "swagger.ui")
public class SwaggerProperties {

    private String basePackage;

    @NestedConfigurationProperty
    private Info info;

    @Data
    public static class Info {

        private String title;

        private String description;

        private String version;

        @NestedConfigurationProperty
        private Contact contact;

        @Data
        public static class Contact {

            private String name;

            private String url;

            private String email;

        }
    }
}
