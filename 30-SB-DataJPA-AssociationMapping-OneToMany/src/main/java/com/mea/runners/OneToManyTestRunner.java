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

		//String resMsg = oTmService.saveDataUsingParentToChild();
		//String resMsg = oTmService.saveDataUsingChildToParent();
		//System.out.println(resMsg);
		
		oTmService.loadDataUsingParent();
	}

}
