package com.mea.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mea.entity.Customer;
import com.mea.repository.ICustomerRepository;

@Service
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {

	@Autowired
	private ICustomerRepository custRepo;

	@Override
	public String registerCustomer(Customer customer) {

		System.out.println("Proxy Class Name ::: " + custRepo.getClass() + "..."
				+ Arrays.toString(custRepo.getClass().getInterfaces()));
		Customer savedCust = custRepo.save(customer);
		return "Customer is saved (record inserted) with the id value :: " + savedCust.getCno();
	}

	@Override
	public boolean isCustomerAvailable(int id) {
		return custRepo.existsById(id);
	}

	@Override
	public long showCustomersCount() {
		return custRepo.count();
	}

	@Override
	public Iterable<Customer> getAllCustomer() {
		return custRepo.findAll();
	}

	@Override
	public Iterable<Customer> getAllCustomerByIds(Iterable<Integer> ids) {
		return custRepo.findAllById(ids);
	}

	@Override
	public String registerGroupCustomer(List<Customer> custList) {
		Iterable<Customer> saveAll = custRepo.saveAll(custList);
		return custList.size() + " no. of records are inserted successfully...";
	}

	/*@Override
	public Customer showCustomerById(Integer id) {
		return custRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid Id"));
	}*/

	/*@Override
	public Customer showCustomerById(Integer id) {
	
		Optional<Customer> optional = custRepo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new IllegalArgumentException("Invalid Id");
		}
	}*/
	
	
	@Override
	public Customer showCustomerById(Integer id) {

		Customer dummyCustomer = new Customer();
		dummyCustomer.setCadd("In House");
		dummyCustomer.setBillAmt(0.0f);
		
		return custRepo.findById(id).orElse(dummyCustomer);
	}

	@Override
	public String registerOrUpdateCustomer(Customer customer) {

		Optional<Customer> optional = custRepo.findById(customer.getCno());
		if(optional.isPresent())
		{
			custRepo.save(customer); //update the record
			return customer.getCno()+" Customer is updated";
		}
		else {
			Customer save = custRepo.save(customer);
			return save.getCno()+" Customer is saved";
		}
	}

}
