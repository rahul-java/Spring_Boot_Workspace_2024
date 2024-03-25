package com.mea.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mea.controller.EmployeeOperationsController;
import com.mea.model.Employee;

@Component
public class MiniProjectTestRunner implements CommandLineRunner{

	@Autowired
	private EmployeeOperationsController controller;
	
	@Override
	public void run(String... args) throws Exception {
		
		try {
			//List<Employee> list=controller.showEmployeesByDesgs("CLERK", "MANAGER", "SALESMAN");
			List<Employee> list=controller.showEmployeesByDesgs(args[0], args[1], args[2]);
			list.forEach(emp->{
				System.out.println(emp);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
