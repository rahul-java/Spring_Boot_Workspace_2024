package com.mea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.mea.model.Customer;

@Controller
public class CustomerOperationsController {

	@GetMapping("/")
	public String showHomePage() {
		return "welcome";
	}
	
	@GetMapping("/register")
	public String showFormPage(@ModelAttribute("cust")Customer cust)
	{
		return "customer_register";
	}
}
