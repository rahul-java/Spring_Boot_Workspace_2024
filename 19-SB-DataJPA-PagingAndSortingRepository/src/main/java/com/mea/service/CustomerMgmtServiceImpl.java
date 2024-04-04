package com.mea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	public Iterable<Customer> showCustomersSorted(boolean asc, String... properties) {

		// prepare Sort obj
		Sort sort = Sort.by(asc ? Direction.ASC : Direction.DESC, properties);
		Iterable<Customer> itr = custRepo.findAll(sort);
		return itr;
	}

	@Override
	public Page<Customer> showCustomersByPageNo(int pageNo, int pageSize) {
		// create pageable obj(pageNo,pageSize)
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

		// get Page<T> obj having page records
		Page<Customer> page = custRepo.findAll(pageable);
		return page;
	}

	@Override
	public Page<Customer> showCustomersByPageNoAndSorted(int pageNo, int pageSize, boolean flagOrder,
			String... properties) {

		Sort sort = Sort.by(flagOrder ? Direction.ASC : Direction.DESC, properties);

		// create pageable obj(pageNo,pageSize)
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);

		// get Page<T> obj having page records
		Page<Customer> page = custRepo.findAll(pageable);

		return page;
	}
	
	
	@Override
	public void showCustomersDataPageByPage(int pageSize) {

		long count=custRepo.count();
		long pagesCount=count/pageSize;
		if(count%pageSize!=0)
		{
			pagesCount++;
		}
		
		//display each page records
		for(int i=0;i<pagesCount;i++)
		{
			//create Pageable obj
			Pageable pageable=PageRequest.of(i, pageSize);
			//get each page records
			Page<Customer> page = custRepo.findAll(pageable);
			System.out.println(page.getNumber()+1+"/"+page.getTotalPages()+" records are ::: ");
			page.getContent().forEach(System.out::println);
			System.out.println("-----------------------------------------------------------");
		}
	}
}
