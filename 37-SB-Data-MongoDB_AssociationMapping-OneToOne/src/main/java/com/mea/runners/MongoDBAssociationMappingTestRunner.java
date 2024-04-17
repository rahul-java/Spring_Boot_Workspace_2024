package com.mea.runners;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mea.document.DrivingLicense;
import com.mea.document.PersonDetails;
import com.mea.service.ILicenseMgmtService;

@Component
public class MongoDBAssociationMappingTestRunner implements CommandLineRunner {

	@Autowired
	private ILicenseMgmtService licenseService;
	
	@Override
	public void run(String... args) throws Exception {

		/*try {
			//prepare Parent
			PersonDetails details=new PersonDetails();
			details.setName("Raja");
			details.setAddress("Hyd");
			//Prepare Child
			DrivingLicense license =new DrivingLicense();
			license.setType("Two Wheeler");
			license.setExpiryDate(LocalDate.of(2026, 12, 31));
			
			details.setLicense(license);  
			
			String resMsg = licenseService.registerDocUsingParent(details);
			System.out.println(resMsg);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			//prepare Parent
			PersonDetails details=new PersonDetails();
			details.setName("RaJesh");
			details.setAddress("Delhi");
			//Prepare Child
			DrivingLicense license =new DrivingLicense();
			license.setType("Four Wheeler");
			license.setExpiryDate(LocalDate.of(2028, 12, 31));
			
			license.setPerson(details);
			
			String resMsg = licenseService.registerDocUsingChild(license);
			System.out.println(resMsg);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		
		try {
			List<PersonDetails> detailsList = licenseService.showDocUsingParent();
			detailsList.forEach(person->{
				System.out.println("Person :: "+person);
				DrivingLicense license = person.getLicense();
				System.out.println("License :: "+license);
			});
			System.out.println("-----------------------------------------------------------------------------");
			List<DrivingLicense> licenseList = licenseService.showDocUsingChild();
			licenseList.forEach(license->{
				System.out.println("License :: "+license);
				PersonDetails person = license.getPerson();
				System.out.println("Person :: "+person);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
