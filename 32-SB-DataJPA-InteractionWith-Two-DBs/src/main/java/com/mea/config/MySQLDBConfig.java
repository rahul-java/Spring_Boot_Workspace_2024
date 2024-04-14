package com.mea.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.mea.repository.promotions", 
                       entityManagerFactoryRef = "mysqlEMF",
                       transactionManagerRef = "mysqlTxMngr")
public class MySQLDBConfig {

	@Bean(name = "mysqlDS")
	@ConfigurationProperties(prefix = "mysql.datasource")
	//@Primary
	public DataSource createMySQLDs() {
		
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "mysqlEMF")
	//@Primary
	public LocalContainerEntityManagerFactoryBean createMySQLEntityManagerFactoryBean(EntityManagerFactoryBuilder builder) {
		//prepare hibernate properties as the Map collection
		Map<String, Object> map=new HashMap();
		map.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		map.put("hibernate.hbm2ddl.auto", "update");
		map.put("hibernate.show_sql", true);
		
		//use EntityManagerFactoryBuilder to create LocalContainerEntityManagerFactoryBean and indirectly EntityManagerFactory Object
		return builder.dataSource(createMySQLDs()) //datasource
		       .packages("com.mea.entity.promotions") //entity class package name
		       .properties(map)  //hibernate properties
		       .build();
	}
	
	@Bean(name = "mysqlTxMngr")
	//@Primary
	public PlatformTransactionManager createMySQLTransactionManager(@Qualifier("mysqlEMF") EntityManagerFactory factory) {
		return new JpaTransactionManager(factory);
	}
}
