package com.mea.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mea.entity.Person;
import com.mea.entity.PhoneNumber;
import com.mea.repository.IPersonRepository;
import com.mea.repository.IPhoneNumberRepository;

@Service("oTmService")
public class OneToManyMgmtServiceImpl implements IOneToManyMgmtService {

	@Autowired
	private IPersonRepository personRepo;
	@Autowired
	private IPhoneNumberRepository phoneRepo;
	
	@Override
	public String saveDataUsingParentToChild() {
		
		//prepare the parent and child obj
		Person person1=new Person("raja","hyd");
		PhoneNumber phone1=new PhoneNumber(9999999999L,"residence","jio");
		PhoneNumber phone2=new PhoneNumber(8888888888L,"office","airtel");
		//assign parent to child
		phone1.setPerson(person1);
		phone2.setPerson(person1);
		//assign childs to parent
		person1.setContactDetails(Set.of(phone1,phone2));
		//save data using parent
		int id = personRepo.save(person1).getPid();
		return "Parent and its child objects are saved having the id value:"+id;
	}
	
	@Override
	public String saveDataUsingChildToParent() {
		
		//prepare the parent and child obj
				Person person1=new Person("rani","sec");
				PhoneNumber phone1=new PhoneNumber(9999999990L,"residence","jio");
				PhoneNumber phone2=new PhoneNumber(8888888880L,"office","airtel");
				//assign parent to child
				phone1.setPerson(person1);
				phone2.setPerson(person1);
				//assign childs to parent
				person1.setContactDetails(Set.of(phone1,phone2));
				//save data using child
				int regNo1 = phoneRepo.save(phone1).getRegNo();
				int regNo2 = phoneRepo.save(phone2).getRegNo();
				return "Child and its associated Parent Object are saved having the id values:"+regNo1 +" , "+regNo2;
	}

	@Override
	public void loadDataUsingParent() {

		Iterable<Person> it=personRepo.findAll();
		it.forEach(p->{
			System.out.println("Person : "+p);
			Set<PhoneNumber> child = p.getContactDetails();
			child.forEach(ph->{
				System.out.println("PhoneNumber : "+ph);
			});		
			System.out.println("------------------------------------------------------------------");
		});
	}
}
