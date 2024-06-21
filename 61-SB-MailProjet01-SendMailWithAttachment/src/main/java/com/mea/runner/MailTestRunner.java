package com.mea.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.mea.service.IPurchaseMgmtService;
@Component
public class MailTestRunner implements CommandLineRunner {

	@Autowired
	private IPurchaseMgmtService service;
	
	@Autowired
	private Environment env;
	
	@Override
	public void run(String... args) throws Exception {

		String fromMail = env.getRequiredProperty("spring.mail.username");
		String resultMsg = service.shopping(new String[] {"shirt","trouser","cap"},
				new Float[] {4000.0f,5000.0f,1000.0f} , fromMail ,
				new String[] {"rp201291@gmail.com","rkpandey.java@gmail.com","rahul@gmail.com"});
		
		System.out.println(resultMsg);
	}

}
