package com.ashish.cactus.school.notice.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableAutoConfiguration
@EntityScan("com.ashish.cactus.school.notice.db.model")
@EnableJpaRepositories(basePackages = "com.ashish.cactus.school.notice.db.repositories")
public class NoticeDBDataSourceConfig {

	@Autowired
	private Environment env;
	
	
	@Bean
    public DataSource dataSource() {

        AbstractRoutingDataSource dataSource = new TenantAwareRoutingSource();

        Map<Object,Object> targetDataSources = new HashMap<>();

        targetDataSources.put("TenantOne", tenantOne());
        targetDataSources.put("TenantTwo", tenantTwo());

        dataSource.setTargetDataSources(targetDataSources);

        dataSource.afterPropertiesSet();

        return dataSource;
    }

    public DataSource tenantOne() {

        HikariDataSource dataSource = new HikariDataSource();

        dataSource.setInitializationFailTimeout(0);
        dataSource.setMaximumPoolSize(5);
        dataSource.setDataSourceClassName(env.getProperty("spring.mysql.datasource"));
        dataSource.addDataSourceProperty("url", env.getProperty("spring.datasource.server.ip") + "/" + "tenant1");
        dataSource.addDataSourceProperty("user", env.getProperty("spring.datasource.username"));
        dataSource.addDataSourceProperty("password", env.getProperty("spring.datasource.password"));

        return dataSource;
    }

    public DataSource tenantTwo() {

        HikariDataSource dataSource = new HikariDataSource();

        dataSource.setInitializationFailTimeout(0);
        dataSource.setMaximumPoolSize(5);
        dataSource.setDataSourceClassName(env.getProperty("spring.mysql.datasource"));
        dataSource.addDataSourceProperty("url", env.getProperty("spring.datasource.server.ip") + "/" + "tenant2");
        dataSource.addDataSourceProperty("user", env.getProperty("spring.datasource.username"));
        dataSource.addDataSourceProperty("password", env.getProperty("spring.datasource.password"));
        return dataSource;
    }
}
