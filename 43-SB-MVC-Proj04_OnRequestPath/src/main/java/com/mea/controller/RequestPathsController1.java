package com.mea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/First")
public class RequestPathsController1 {
	
	@GetMapping("/all")
	public String showReport1() {
		System.out.println("RequestPathsController1.showReport1()");
		return "report1";
	}
}
