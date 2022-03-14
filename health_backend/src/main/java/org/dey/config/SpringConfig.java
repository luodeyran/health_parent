package org.dey.config;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * @author deyran
 * @Configuration 注解表示这是一个配置类，在我们这里，这个配置的作用类似于 applicationContext.xml
 * @ComponentScan 注解表示配置包扫描，里边的属性和 xml 配置中的属性都是一一对应的，useDefaultFilters 表示使用默认的过滤器，然后又除去 Controller 注解，即在 Spring 容器中扫描除了 Controller 之外的其他所有 Bean 。
 */
@Configuration
@ComponentScan(basePackages = "org.dey", excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Controller.class)})
//@Import({DataSourceConfig.class})
@Import({MybatisPlusConfig.class})
public class SpringConfig {

}
