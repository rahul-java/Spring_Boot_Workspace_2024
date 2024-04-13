package com.mea.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mea.service.IOneToManyMgmtService;

@Component
public class HQLJoinsTestRunner implements CommandLineRunner {

	@Autowired
	private IOneToManyMgmtService oTmService;
	
	@Override
	public void run(String... args) throws Exception {

		/*List<Object[]> list = oTmService.fetchParentToChildJoinsData();
		list.forEach(row->{
			for(Object obj:row)
			{
				System.out.print(obj+" ");
			}
			System.out.println();
		});*/
		
		
		List<Object[]> list = oTmService.fetchChildToParentJoinsData();
		list.forEach(row->{
			for(Object obj:row)
			{
				System.out.print(obj+" ");
			}
			System.out.println();
		});
	}

}
