package com.mea.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mea.entity.Person;
import com.mea.entity.PhoneNumber;
import com.mea.repository.IPersonRepository;
import com.mea.repository.IPhoneNumberRepository;

import jakarta.persistence.FetchType;

@Service("oTmService")
public class OneToManyMgmtServiceImpl implements IOneToManyMgmtService {

	@Autowired
	private IPersonRepository personRepo;
	@Autowired
	private IPhoneNumberRepository phoneRepo;
	
	@Override
	public List<Object[]> fetchParentToChildJoinsData() {
		
		List<Object[]> list=personRepo.showParentToChildJoinsData();
		return list;
	}
	
	@Override
	public List<Object[]> fetchChildToParentJoinsData() {
		List<Object[]> list=phoneRepo.showChildToParentJoinsData();
		return list;
	}
}
