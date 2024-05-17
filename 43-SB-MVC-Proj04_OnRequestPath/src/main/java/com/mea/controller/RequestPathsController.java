package com.mea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@Controller
public class RequestPathsController {
	
	/*@RequestMapping("/")
	public String showHomePage() {
		
		return "welcome";
	}*/
	
	/*@RequestMapping
	public String showHomePage() {
		
		return "welcome";
	}*/
	
	/*@RequestMapping("/report")
	public String showReport1() {
		
		return "report1";
	}
	
	@RequestMapping("/REPORT")
	public String showReport2() {
		
		return "report2";
	}*/
	
	/*@RequestMapping({"/report1","/report2","/report3"})
	public String showReport1() {
		
		return "report1";
	}*/
	
	//@RequestMapping(value =  "/report",method = RequestMethod.GET)
	@GetMapping("/report")
	public String showReport1() {
		System.out.println("RequestPathsController.showReport1()");
		return "report1";
	}
	
	//@RequestMapping(value =  "/report",method = RequestMethod.POST)
	//ALLOWED with same request mapping but different mode GET/POST
	@PostMapping("/report")
	public String showReport2() {
		System.out.println("RequestPathsController.showReport2()");
		return "report2";
	}
	
	//NOT ALLOWED , it will throw exception
	/*@GetMapping("/report")
	public String showReport2() {
		System.out.println("RequestPathsController.showReport2()");
		return "report2";
	}*/
	
	@GetMapping
	public String showHomePage1() {
		System.out.println("RequestPathsController.showHomePage1()");
		return "welcome";
	}
	
	@PostMapping
	public String showHomePage2() {
		System.out.println("RequestPathsController.showHomePage2()");
		return "welcome";
	}
}
