package com.mea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

	@GetMapping("/")
	public String redirectHome() {
		return "redirect:/employee/";
	}
}
