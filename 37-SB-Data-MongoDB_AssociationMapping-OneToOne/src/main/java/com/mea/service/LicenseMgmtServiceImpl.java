package com.mea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mea.document.DrivingLicense;
import com.mea.document.PersonDetails;
import com.mea.repository.IDrivingLicenseRepository;
import com.mea.repository.IPersonDetailsRepository;

@Service("licenseService")
public class LicenseMgmtServiceImpl implements ILicenseMgmtService {

	@Autowired
	private IDrivingLicenseRepository licenseRepo;
	@Autowired
	private IPersonDetailsRepository personRepo;
	
	@Override
	public String registerDocUsingParent(PersonDetails details) {

		String personId = personRepo.save(details).getId();
		return "Person Doc and its associated DrivingLicense Doc is SAVED with id value : "+personId;
	}
	
	@Override
	public String registerDocUsingChild(DrivingLicense license) {

		String licenseId = licenseRepo.save(license).getId();
		return "License Doc and its associated PersonDetails Doc is SAVED with id value : "+licenseId;
	}
	
	@Override
	public List<DrivingLicense> showDocUsingChild() {
		return licenseRepo.findAll();
	}
	
	@Override
	public List<PersonDetails> showDocUsingParent() {
		return personRepo.findAll();
	}

}
