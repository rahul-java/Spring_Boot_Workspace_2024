package com.mea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/Second")
public class RequestPathsController2 {
	
	@GetMapping("/all")
	public String showReport2() {

		System.out.println("RequestPathsController2.showReport2()");
		return "report2";
	}
}
