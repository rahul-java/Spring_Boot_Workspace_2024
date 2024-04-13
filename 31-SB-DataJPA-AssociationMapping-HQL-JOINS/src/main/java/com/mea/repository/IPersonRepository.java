package com.mea.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mea.entity.Person;

public interface IPersonRepository extends JpaRepository<Person, Integer> {

	//@Query("select pid , pName , pAddress , regNo , mobileNo , numberType , provider from Person per inner join per.contactDetails")
	//@Query("select pid , pName , pAddress , regNo , mobileNo , numberType , provider from Person per left join per.contactDetails")
	//@Query("select pid , pName , pAddress , regNo , mobileNo , numberType , provider from Person per right join per.contactDetails")
	@Query("select pid , pName , pAddress , regNo , mobileNo , numberType , provider from Person per full join per.contactDetails")
	public List<Object[]> showParentToChildJoinsData();
}
