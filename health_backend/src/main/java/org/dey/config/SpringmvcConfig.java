package org.dey.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author deyran
 * @classname
 * @see WebMvcConfigurationSupport
 */
@Configuration
@EnableWebMvc//启用MVC默认配置
@ComponentScan(basePackages = "org.dey", useDefaultFilters = false, includeFilters = {@ComponentScan.Filter(classes = {Controller.class, ControllerAdvice.class})})
public class SpringmvcConfig extends WebMvcConfigurationSupport {
    /**
     * 配置静态资源过滤
     * /*和/**的区别  /*指一级目录,/**指下面的所有目录
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/*").addResourceLocations("/");
    }
}

