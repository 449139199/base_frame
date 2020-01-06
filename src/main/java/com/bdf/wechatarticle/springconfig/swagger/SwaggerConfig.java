package com.bdf.wechatarticle.springconfig.swagger;

import com.bdf.wechatarticle.springconfig.properties.SwaggerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * 创建时间：2019-01-13
 * 类名：SwaggerConfig
 * 描述：Swagger 配置
 * @author : 张强 <:zq15302026066@163.com>
 * @version : v1.0
 */
@Configuration
@RefreshScope
public class SwaggerConfig {

    @Value("${swagger.enable:false}")
    private boolean enable;

    private final SwaggerProperties swaggerProperties;

    @Autowired
    public SwaggerConfig(SwaggerProperties swaggerProperties) {
        this.swaggerProperties = swaggerProperties;
    }

    /**
     * 访问地址 http://ip:port/swagger-ui.html
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(enable)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(swaggerProperties.getBasePackage()))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        SwaggerProperties.Info info = swaggerProperties.getInfo();
        return new ApiInfoBuilder()
                .title(info.getTitle())
                .description(info.getDescription())
                .contact(new Contact(info.getContact().getName(), info.getContact().getUrl(), info.getContact().getEmail()))
                .version(info.getVersion())
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .build();
    }

}
