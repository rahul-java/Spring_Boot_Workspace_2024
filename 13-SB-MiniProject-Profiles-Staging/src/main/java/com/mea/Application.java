package com.mea;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import com.mea.controller.EmployeeOperationsController;
import com.mea.model.Employee;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		
		 EmployeeOperationsController controller = ctx.getBean("empController",EmployeeOperationsController.class);
		//invoke the b.method
		try {
			List<Employee> list = controller.showEmployeesByDesgs("CLERK", "MANAGER", "SALESMAN");
			list.forEach(emp->System.out.println(emp));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("=========================================");
		Environment env=ctx.getEnvironment();
		System.out.println("Current Profile Name ::: "+Arrays.toString(env.getActiveProfiles()));
		((ConfigurableApplicationContext) ctx).close();
	}

}
