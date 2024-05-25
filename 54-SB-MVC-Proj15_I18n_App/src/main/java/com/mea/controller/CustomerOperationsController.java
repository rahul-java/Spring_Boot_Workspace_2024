package com.mea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerOperationsController {

	@GetMapping("/")
	public String showHomePage() {
		return "welcome";
	}
}
