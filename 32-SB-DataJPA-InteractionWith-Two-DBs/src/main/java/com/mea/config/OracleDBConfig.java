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
@EnableJpaRepositories(basePackages = "com.mea.repository.product", 
                       entityManagerFactoryRef = "oracleEMF",
                       transactionManagerRef = "oracleTxMngr")
public class OracleDBConfig {

	@Bean(name = "oracleDS")
	@Primary
	@ConfigurationProperties(prefix = "oracle.datasource")
	public DataSource createOracleDs() {
		return DataSourceBuilder.create().build();
	}
	
	@SuppressWarnings("unchecked")
	@Bean(name = "oracleEMF")
	@Primary
	public LocalContainerEntityManagerFactoryBean createOraclEntityManagerFactoryBean(EntityManagerFactoryBuilder builder) {
		//prepare hibernate properties as the Map collection
		Map<String, Object> map=new HashMap();
		map.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
		map.put("hibernate.hbm2ddl.auto", "update");
		map.put("hibernate.show_sql", true);
		
		//use EntityManagerFactoryBuilder to create LocalContainerEntityManagerFactoryBean and indirectly EntityManagerFactory Object
		return builder.dataSource(createOracleDs()) //datasource
		       .packages("com.mea.entity.product") //entity class package name
		       .properties(map)  //hibernate properties
		       .build();
	}
	
	@Bean(name = "oracleTxMngr")
	@Primary
	public PlatformTransactionManager createOracleTransactionManager(@Qualifier("oracleEMF") EntityManagerFactory factory) {
		return new JpaTransactionManager(factory);
	}
}
