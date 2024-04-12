package com.mea.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mea.service.IOneToManyMgmtService;

@Component
public class OneToManyTestRunner implements CommandLineRunner {

	@Autowired
	private IOneToManyMgmtService oTmService;
	
	@Override
	public void run(String... args) throws Exception {

		//String resMsg1 = oTmService.saveDataUsingParentToChild();
		//System.out.println(resMsg1);
		//String resMsg2 = oTmService.saveDataUsingChildToParent();
		//System.out.println(resMsg2);
		
		//oTmService.loadDataUsingParent();
		
		//String resMsg3 = oTmService.removeDataByParent(10);
		//System.out.println(resMsg3);
		
		//Deleting the childs of the Parent
		//System.out.println(oTmService.removeAllChildsOfTheParent(102));
		
		System.out.println(oTmService.addNewChildToExistingParent(102));
	}

}
