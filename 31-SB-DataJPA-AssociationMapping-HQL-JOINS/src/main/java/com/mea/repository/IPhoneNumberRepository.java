package com.mea.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mea.entity.PhoneNumber;

public interface IPhoneNumberRepository extends JpaRepository<PhoneNumber, Integer> {

	//@Query("select regNo , mobileNo , numberType , provider , pid , pName , pAddress  from PhoneNumber ph inner join ph.person")
	//@Query("select regNo , mobileNo , numberType , provider , pid , pName , pAddress  from PhoneNumber ph left join ph.person")
	//@Query("select regNo , mobileNo , numberType , provider , pid , pName , pAddress  from PhoneNumber ph right join ph.person")
	@Query("select regNo , mobileNo , numberType , provider , pid , pName , pAddress  from PhoneNumber ph full join ph.person")
	public List<Object[]> showChildToParentJoinsData();
}
