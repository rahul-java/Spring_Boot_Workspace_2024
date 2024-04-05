package com.mea.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mea.entity.Customer;
import com.mea.repository.ICustomerRepository;

@Service
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {

	@Autowired
	private ICustomerRepository custRepo;

	@Override
	public String deleteCustomersByIdsInBatch(List<Integer> ids) {
		List<Customer> list = custRepo.findAllById(ids);
		custRepo.deleteAllByIdInBatch(ids);
		return list.size()+" customer records are deleted.";
	}
	
	@Override
	public List<Customer> showCustomersByExampleData(Customer cust,boolean flagOrder,String ...properties) {
		// create example obj
		Example<Customer> example=Example.of(cust);
		Sort sort = Sort.by(flagOrder?Direction.ASC:Direction.DESC, properties);
		List<Customer> list = custRepo.findAll(example, sort);
		return list;
	}
	
	@Override
	public Customer showCustomerById(int cno) {
		Customer cust = custRepo.getReferenceById(cno);  //lazy loading
		System.out.println(cust.getClass()+" ::: "+cust.getClass().getSuperclass());
		return cust;
	}
	
	@Override
	public Optional<Customer> fetchCustomerById(int cno) {
		Optional<Customer> optional = custRepo.findById(cno);  //eager loading
		return optional;
	}
}
