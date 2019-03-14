package com.jcex.test.utils;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {

    /**
     * 数据源1 prefix指定从application文件里读取的配置前缀名
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "db.datasource.ds1")
    public DataSource ds1(){
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 数据源2 prefix指定从application文件里读取的配置前缀名
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "db.datasource.ds2")
    public DataSource ds2(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    public DataSource dataSource(){
        //按照目标数据源名称和目标数据源对象的映射存放在Map中
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceKey.DATA_SOURCE_1, ds1());
        targetDataSources.put(DataSourceKey.DATA_SOURCE_2, ds2());
        //采用是想AbstractRoutingDataSource的对象包装多数据源
        DynamicDataSource dataSource = new DynamicDataSource();
        //这里就是把多个数据源信息赋值给resolvedDataSources属性
        dataSource.setTargetDataSources(targetDataSources);
        //设置默认的数据源，当拿不到数据源时，使用此配置
        dataSource.setDefaultTargetDataSource(ds1());
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager txManager(){
        return new DataSourceTransactionManager(dataSource());
    }

}