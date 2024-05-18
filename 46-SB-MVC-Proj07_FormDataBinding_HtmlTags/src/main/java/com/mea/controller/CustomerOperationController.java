package com.mea.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mea.model.Customer;

import jakarta.annotation.PostConstruct;

@Controller
public class CustomerOperationController {

	@GetMapping("/")
	public String showHomePage() {
		System.out.println("CustomerOperationController.showHomePage()");
		return "welcome";
	}
	
	//for Form Page launching
	@GetMapping("/register")
	public String showRegisterPage() {
		System.out.println("CustomerOperationController.showRegisterPage()");
		return "customer_register";
	}
	
	@PostMapping("/register")
	public String registerCustomer(Map<String, Object> map,@ModelAttribute("cust")Customer customer)
	{
		System.out.println("CustomerOperationController.registerCustomer()");
		System.out.println("Model class obj data :"+customer);
		map.put("formData", customer);
		return "show_result";
	}
}
