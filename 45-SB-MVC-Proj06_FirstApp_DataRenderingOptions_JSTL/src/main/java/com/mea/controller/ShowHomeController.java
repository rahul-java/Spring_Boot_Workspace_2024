package com.mea.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.mea.model.Tourist;

@Controller
public class ShowHomeController {
	
	/*	@GetMapping("/")
		public String showData(Map<String, Object> map) {
			
			//set simple values as the model attriute
			map.put("friends", new String[] {"Rahul","Rajesh","Raja","Aman","Ankit"});
			map.put("nickNames", List.of("bhaiya","Raju","Maharaj","Ashu","Akki"));
			map.put("phoneNumbers", Set.of(9999999999L,8888888888L,7777777777L,6666666666L,5555555555L));
			map.put("idDetails", Map.of("aadhar,",12345,"voterId",234234,"passport",456456456,"drivingLicense",203010,"panCard",741852));
			return "welcome";
		}*/
	
	
	/*@GetMapping("/")
	public String showData(Map<String, Object> map) {
		
		//set model class object as the model attriute
		Tourist tourist=new Tourist(101, "Rahul", 9999999999L, "New-York", "New-Delhi", 600000.0);
		map.put("touristInfo", tourist);
		return "welcome";
	}*/
	
	
	@GetMapping("/")
	public String showData(Map<String, Object> map) {
		
		//set Collection of model class object as the model attriute
		List<Tourist> touristList=List.of(new Tourist(101, "Rahul", 9999999999L, "New-York", "New-Delhi", 600000.0),
				new Tourist(102, "Amit", 8888888888L, "Neitherland", "Noida", 500000.0),
				new Tourist(103, "Ravi", 7777777777L, "Hong-Kong", "Hyd", 300000.0),
				new Tourist(104, "Lokesh", 6666666666L, "Australia", "Alld", 800000.0),
				new Tourist(105, "Manish", 5555555555L, "Georgia", "Gurugram", 1200000.0));
		//touristList=null;
		map.put("touristListInfo", touristList);
		return "welcome";
	}
}
