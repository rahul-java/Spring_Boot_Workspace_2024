package com.mea.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowHomeController {

	/*@GetMapping("/")
	public String showData(Map<String, Object> map) {
		
		//set simple values as the model attriute
		map.put("name", "Raja");
		map.put("sysDate", new Date());
		return "welcome";
	}*/
	
	@GetMapping("/")
	public String showData(Map<String, Object> map) {
		
		//set simple values as the model attriute
		map.put("friends", new String[] {"Rahul","Rajesh","Raja","Aman","Ankit"});
		map.put("nickNames", List.of("bhaiya","Raju","Maharaj","Ashu","Akki"));
		map.put("phoneNumbers", Set.of(9999999999L,8888888888L,7777777777L,6666666666L,5555555555L));
		map.put("idDetails", Map.of("aadhar,",12345,"voterId",234234,"passport",456456456,"drivingLicense",203010,"panCard",741852));
		return "welcome";
	}
}
