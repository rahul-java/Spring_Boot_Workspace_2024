package com.mea.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.mea.model.Employee;

@Component("empProcessor")
public class EmployeeItemProcessor implements ItemProcessor<Employee, Employee> {

	@Override
	public Employee process(Employee item) throws Exception {
		if(item.getSalary()>35000.0) {
			item.setGrossSalary(item.getSalary()+item.getSalary()*0.4);
			item.setNetSalary(item.getGrossSalary()-(item.getGrossSalary()*0.2));
			return item;
		}
		return null;
	}

}
