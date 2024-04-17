package com.mea.service;

import java.util.List;

import com.mea.document.DrivingLicense;
import com.mea.document.PersonDetails;

public interface ILicenseMgmtService {

	public String registerDocUsingParent(PersonDetails details);
	public String registerDocUsingChild(DrivingLicense license);
	
	public List<PersonDetails> showDocUsingParent();
	public List<DrivingLicense> showDocUsingChild();
}
