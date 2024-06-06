package com.mea.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mea.entity.Employee;

@Component
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Employee.class);
	}

	@Override
	public void validate(Object model, Errors errors) {
		Employee emp=(Employee)model;
		
		if(emp.getEmpName()==null || emp.getEmpName().equals("") || emp.getEmpName().length()==0)
			errors.rejectValue("empName", "emp.name.required");
		else if(emp.getEmpName().length()<5 || emp.getEmpName().length()>15)
			errors.rejectValue("empName", "emp.name.length");
		
		if(emp.getJob()==null || emp.getJob().equals("") || emp.getJob().length()==0)
			errors.rejectValue("job", "emp.job.required");
		else if(emp.getJob().length()<5 || emp.getJob().length()>15)
			errors.rejectValue("job", "emp.job.length");
		
		if(emp.getSalary()==null)
			errors.rejectValue("salary", "emp.salary.required");
		else if(emp.getSalary()<10000.0 || emp.getSalary()>200000.0)
			errors.rejectValue("salary", "emp.salary.range");
			
		if(emp.getDeptNo()==null)
			errors.rejectValue("deptNo", "emp.deptNo.required");
		else if(emp.getDeptNo()<100 || emp.getDeptNo()>500)
			errors.rejectValue("deptNo", "emp.deptNo.range");

	}

}
