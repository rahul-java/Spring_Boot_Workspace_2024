package com.mea.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mea.service.ISeasonFinderService;

@Controller
public class SeasonFinderOperationsController {

	@Autowired
	private ISeasonFinderService seasonFinderService;
	
	@RequestMapping("/")
	public String showHomePage() {
		
		return "welcome";
	}
	
	@RequestMapping("/season")
	public String showSeason(Map<String, Object> map) {
		
		String msg=seasonFinderService.findSeason();
		map.put("seasonName", msg);
		return "display";
	}
}
