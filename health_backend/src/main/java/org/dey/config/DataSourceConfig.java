package org.dey.config;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * @author deyran
 * @classname 数据源配置类
 * @see DataSourceConfig
 */
@PropertySource("classpath:jdbc.properties")
public class DataSourceConfig {

    @Value("${driver}")
    private String driver;
    @Value("${url}")
    private String url;
    @Value("${user}")
    private String username;
    @Value("${password}")
    private String password;


    /**
     * druid相关配置
     */
    @Bean(name = "devSource")
    @Profile("dev")
    @Lazy(false)
    public DataSource dataSource() {
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;
    }

}