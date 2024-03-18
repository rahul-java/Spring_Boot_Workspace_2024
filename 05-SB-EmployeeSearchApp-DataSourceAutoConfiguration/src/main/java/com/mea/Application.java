package com.mea;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mea.controller.EmployeeOperationsController;
import com.mea.model.Employee;

@SpringBootApplication(exclude = {
		JdbcTemplateAutoConfiguration.class
		//, DataSourceAutoConfiguration.class
		})
public class Application {
	
	/*
	@Bean(name = "c3PoDs")
	public ComboPooledDataSource createDs() throws Exception{
		ComboPooledDataSource cds=new ComboPooledDataSource();
		cds.setDriverClass("oracle.jdbc.driver.OracleDriver");
		cds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		cds.setUser("system");
		cds.setPassword("Manager");
		return cds;
	}
      */
	
	/*
	@Autowired
	private Environment env;
	
	@Bean(name = "c3PoDs")
	public ComboPooledDataSource createDs() throws Exception{
		ComboPooledDataSource cds=new ComboPooledDataSource();
		cds.setDriverClass(env.getProperty("spring.datasource.driver-class-name"));
		cds.setJdbcUrl(env.getProperty("spring.datasource.url"));
		cds.setUser(env.getProperty("spring.datasource.username"));
		cds.setPassword(env.getProperty("spring.datasource.password"));
		return cds;
	}
	
	*/
	
	
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		EmployeeOperationsController controller = ctx.getBean("empController",EmployeeOperationsController.class);
		
		//invoke the b.method
		try {
			List<Employee> list = controller.showEmployeesByDesgs("CLERK", "MANAGER", "SALESMAN");
			list.forEach(emp->System.out.println(emp));
		} catch (Exception e) {
			e.printStackTrace();
		}
		ctx.close();
	}
	
	

}
