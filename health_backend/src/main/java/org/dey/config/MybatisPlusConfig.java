package org.dey.config;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.io.IOException;
import java.util.Properties;

/**
 * @author deyran
 * @classname
 * @see MybatisPlusConfig
 */
@Configuration
@ComponentScan(value = "org.dey", excludeFilters = { // 这里需要把MVC相关注解排除,否则test会报错!~无法创建bean工厂
        @ComponentScan.Filter(classes = {Controller.class, ControllerAdvice.class, Configuration.class})})
//@PropertySource({"classpath:log4j.properties"}) // 读取JDBC配置文件
@Import({DataSourceConfig.class})
@MapperScan("org.dey.mapper")//包扫描 接口
@EnableAspectJAutoProxy // 启动切面
//@EnableTransactionManagement//启动事务
public class MybatisPlusConfig {

    /**
     * 让系统支持多个properties文件应用,否则shiro会出错
     */
    @Bean
    public PropertySourcesPlaceholderConfigurer newPropertyPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    /**
     * 整合MyBatisPlus配置文件,接管SqlSessionFactory
     *
     * @Autowired 根据属性类型自动装配, 可以省略
     */
    @Bean
    @Lazy(false)
    public MybatisSqlSessionFactoryBean newSqlSessionFactory(@Autowired DataSourceConfig dataSource)
            throws IOException {
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(dataSource.dataSource());
        Resource[] mapperLocations = new PathMatchingResourcePatternResolver().getResources("classpath:*Mapper.xml");
        bean.setMapperLocations(mapperLocations);

        //MyBatisPlus,pageHelper插件
        PageHelper pHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("resonable", "true");
        p.setProperty("dialect", "mysql");
        p.setProperty("rowBoundsWithCount", "true");
        pHelper.setProperties(p);

        return bean;
    }

}
