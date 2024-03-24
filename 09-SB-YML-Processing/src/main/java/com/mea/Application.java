package com.mea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.mea.sbeans.EmployeeInfo;
import com.mea.sbeans.StudentInfo;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		EmployeeInfo employeeInfo = ctx.getBean("empInfo",EmployeeInfo.class);
		System.out.println(employeeInfo);
		StudentInfo studentInfo = ctx.getBean("studInfo",StudentInfo.class);
		System.out.println("-------------------------------------------------------------------");
		System.out.println(studentInfo);
		((ConfigurableApplicationContext) ctx).close();
	}

}
