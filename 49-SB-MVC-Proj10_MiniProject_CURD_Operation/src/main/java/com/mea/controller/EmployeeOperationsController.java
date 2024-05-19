package com.mea.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.mea.entity.Employee;
import com.mea.service.IEmployeeMgmtService;

@Controller
public class EmployeeOperationsController {

	@Autowired
	private IEmployeeMgmtService empService;
	
	@GetMapping("/")
	public String showHomePage() {
		
		return "welcome";
	}
	
	@GetMapping("/report")
	public String fetchAllEmployee(Map<String, Object> map) {
		
		Iterable<Employee> it = empService.showAllEmployee();
		map.put("empList", it);
		return "show_report";
	}
}
