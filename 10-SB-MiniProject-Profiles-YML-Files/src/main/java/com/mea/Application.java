package com.mea;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.mea.controller.EmployeeOperationsController;
import com.mea.model.Employee;

@SpringBootApplication
public class Application {

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
