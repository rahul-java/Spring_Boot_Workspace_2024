package com.mea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShowHomeController {

	//Handler Method
	/*@RequestMapping("/home")
	public String showHomePage() {
		
		//return logical view name
		return "welcome";
	}*/
	
	@RequestMapping("/")
	public String showHomePage() {
		
		//return logical view name
		return "welcome";
	}
}
