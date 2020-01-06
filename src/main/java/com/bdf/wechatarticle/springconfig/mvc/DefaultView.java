package com.bdf.wechatarticle.springconfig.mvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p>
 *   说明: springmvc默认页面
 * </p>
 * @author 张强<zq15302026066@163.com>
 * @date  2019/4/8 10:56
 */
@Configuration
public class DefaultView implements WebMvcConfigurer {

    /**
     * <p>
     *     方法说明: 设置默认路径页面
     * </p>
     * @author 张强<:zq15302026066@163.com>
     * @param registry springmvc注册对象
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("index");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    /**
     * <p>
     *     方法说明: 解决跨域问题
     * </p>
     * @author 张强<:zq15302026066@163.com>
     */
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH")
                .allowCredentials(true).maxAge(3600);
    }

}
