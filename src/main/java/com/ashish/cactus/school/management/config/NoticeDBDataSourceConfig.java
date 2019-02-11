package com.ashish.cactus.school.management.config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableAutoConfiguration
@PropertySource(ignoreResourceNotFound=false, value="${spring.database.config.location}")
@EntityScan(basePackages={"com.ashish.cactus.school.management.db.model","com.ashish.cactus.school.management.admin.db.model"})
@EnableJpaRepositories(basePackages = {"com.ashish.cactus.school.management.db.repositories","com.ashish.cactus.school.management.admin.db.repositories"})
public class NoticeDBDataSourceConfig {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment env;
	
	@Bean
	@Primary
    public DataSource noticeDataSource() {

        AbstractRoutingDataSource dataSource = new TenantAwareRoutingSource();

        Map<Object,Object> targetDataSources = new HashMap<>();

//        targetDataSources.put("cactusschool_admin", addSchoolDatabase("cactusschool_admin"));
        String databases = env.getProperty("school.database.names");
        List<String> allDatabases = Arrays.asList(databases.split("\\s*,\\s*"));
    	for(String databaseName: allDatabases) {
			try {
				databaseName = databaseName.trim();
				targetDataSources.put(databaseName, addSchoolDatabase(databaseName));
				logger.info("Created datasource for database: " + databaseName);
			} catch (Exception e) {
				logger.error("Database: " + databaseName + " does not exists. Moving to initialize the next database:", e);
			}
    	}

        dataSource.setTargetDataSources(targetDataSources);

        dataSource.afterPropertiesSet();

        return dataSource;
    }
	
	/*@Bean
	@Primary
    public LocalContainerEntityManagerFactoryBean noticeEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em
          = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(noticeDataSource());
        em.setPackagesToScan(
          new String[] { "com.ashish.cactus.school.management.db.model" });
 
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
        properties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
        em.setJpaPropertyMap(properties);
 
        return em;
    }
 
    @Bean
    @Primary
    public PlatformTransactionManager noticeTransactionManager() {
  
        JpaTransactionManager transactionManager
          = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
          noticeEntityManagerFactory().getObject());
        return transactionManager;
    }*/

	 private DataSource addSchoolDatabase(String schoolDatabaseName) {

	        HikariDataSource dataSource = new HikariDataSource();

	        dataSource.setInitializationFailTimeout(0);
	        dataSource.setMaximumPoolSize(Integer.parseInt(env.getProperty("spring.jpa.max.connection.pool")));
	        dataSource.setDataSourceClassName(env.getProperty("spring.mysql.datasource"));
	        dataSource.addDataSourceProperty("url", env.getProperty("spring.datasource.server.ip") + "/" + schoolDatabaseName);
	        dataSource.addDataSourceProperty("user", env.getProperty("spring.datasource.username"));
	        dataSource.addDataSourceProperty("password", env.getProperty("spring.datasource.password"));

	        return dataSource;
	}
	 
    private DataSource tenantOne() {

        HikariDataSource dataSource = new HikariDataSource();

        dataSource.setInitializationFailTimeout(0);
        dataSource.setMaximumPoolSize(Integer.parseInt(env.getProperty("spring.jpa.max.connection.pool")));
        dataSource.setDataSourceClassName(env.getProperty("spring.mysql.datasource"));
        dataSource.addDataSourceProperty("url", env.getProperty("spring.datasource.server.ip") + "/" + "tenant1");
        dataSource.addDataSourceProperty("user", env.getProperty("spring.datasource.username"));
        dataSource.addDataSourceProperty("password", env.getProperty("spring.datasource.password"));

        return dataSource;
    }

    private DataSource tenantTwo() {

        HikariDataSource dataSource = new HikariDataSource();

        dataSource.setInitializationFailTimeout(0);
        dataSource.setMaximumPoolSize(Integer.parseInt(env.getProperty("spring.jpa.max.connection.pool")));
        dataSource.setDataSourceClassName(env.getProperty("spring.mysql.datasource"));
        dataSource.addDataSourceProperty("url", env.getProperty("spring.datasource.server.ip") + "/" + "tenant2");
        dataSource.addDataSourceProperty("user", env.getProperty("spring.datasource.username"));
        dataSource.addDataSourceProperty("password", env.getProperty("spring.datasource.password"));
        return dataSource;
    }
    
    private DataSource cactusschoolAdmin() {

        HikariDataSource dataSource = new HikariDataSource();

        dataSource.setInitializationFailTimeout(0);
        dataSource.setMaximumPoolSize(Integer.parseInt(env.getProperty("spring.jpa.max.connection.pool")));
        dataSource.setDataSourceClassName(env.getProperty("spring.mysql.datasource"));
        dataSource.addDataSourceProperty("url", env.getProperty("spring.datasource.server.ip") + "/" + "cactusschool_admin");
        dataSource.addDataSourceProperty("user", env.getProperty("spring.datasource.username"));
        dataSource.addDataSourceProperty("password", env.getProperty("spring.datasource.password"));

        return dataSource;
    }
}
