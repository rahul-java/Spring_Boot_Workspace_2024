package com.mea.controller;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShowHomeController {

	//Handler Method
	/*@RequestMapping("/home")
	public String showHomePage() {
		
		//return logical view name
		return "welcome";
	}*/
	
	/*@RequestMapping("/")
	public String showHomePage() {
		
		//return logical view name(LVN)
		return "welcome";
	}*/
	
	/*@RequestMapping("/")
	public String showHomePage(Map<String, Object> map) {
		
		System.out.println("ShowHomeController.showHomePage() ::: Shared Memory Object Class Name:"+map.getClass() );
		//keep data in shared memory as the model attribute
		map.put("attr1", "var1");
		map.put("attr2", "var2");
		map.put("attr3", "var3");
		return "welcome";
	}*/
	
	/*@RequestMapping("/")
	public String showHomePage(Model model) {
		
		System.out.println("ShowHomeController.showHomePage() ::: Shared Memory Object Class Name:"+model.getClass() );
		//keep data in shared memory as the model attribute
		model.addAttribute("attr1", new Date());
		model.addAttribute("attr2", "var22");
		model.addAttribute("attr3", "var33");
		return "welcome";
	}*/
	
	@RequestMapping("/")
	public String showHomePage(ModelMap map) {
		
		System.out.println("ShowHomeController.showHomePage() ::: Shared Memory Object Class Name:"+map.getClass() );
		//keep data in shared memory as the model attribute
		map.addAttribute("attr1", new Date());
		map.addAttribute("attr2","Rahul");
		map.addAttribute("attr3", "Pandey");
		return "welcome";
	}
	
	/*@RequestMapping("/process")
	public Model showHomeProcess() {
		
		//keep data in shared memory as the model attribute
		Model model=new BindingAwareModelMap();
		model.addAttribute("attr1", new Date());
		model.addAttribute("attr2","RequestPath as a LVN");
		model.addAttribute("attr3", "Process");
		return model;
	}*/
	
	/*@RequestMapping("/process")
	public Map<String, Object> showHomeProcess() {
		
		//keep data in shared memory as the model attribute
		Map<String, Object> map=new HashMap();
		map.put("attr1", new Date());
		map.put("attr2","RequestPath as a LVN(Logical View Name)");
		map.put("attr3", "process");
		return map;
	}*/
	
	/*@RequestMapping("/process")
	public ModelAndView showHomeProcess() {
		
		//keep data in shared memory as the model attribute
		ModelAndView mav=new ModelAndView();
		mav.addObject("attr1", "First");
		mav.addObject("attr2", "Second");
		mav.addObject("attr3", "Third");
		
		mav.setViewName("welcome");  //LVN logical view name
		
		return mav;
	}*/
	
	/*@RequestMapping("/process")
	public void showHomeProcess(Map<String, Object> map) {
		
		//keep data in shared memory as the model attribute
		map.put("attr1", new Date());
		map.put("attr2","RequestPath as a LVN(Logical View Name)");
		map.put("attr3", "process");
		
	}*/
	
	/*@RequestMapping("/process")
	public String showHomeProcess(Map<String, Object> map) {
		
		//keep data in shared memory as the model attribute
		map.put("attr1", new Date());
		map.put("attr2","RequestPath as a LVN(Logical View Name)");
		map.put("attr3", "null");
		
		return null;
		
	}*/
	
	/*@RequestMapping("/process")
	public String showHomeProcess(Map<String, Object> map) {
		System.out.println("ShowHomeController.showHomeProcess()");
		//keep data in shared memory as the model attribute
		map.put("attr1", new Date());
		map.put("attr2","Forward");
		map.put("attr3", "Report");
		
		return "forward:report";  //source 
		
	}
	
	@RequestMapping("/report")  //destination
	public String showReportPage(Map<String, Object> map) {
		System.out.println("ShowHomeController.showReportPage()");
		//keep data in shared memory as the model attribute
		map.put("attr1", new Date());
		map.put("attr2","Show");
		map.put("attr3", "Report");
		
		return "show_report";
		
	}*/
	
	@RequestMapping("/process")
	public String showHomeProcess(Map<String, Object> map) {
		System.out.println("ShowHomeController.showHomeProcess()");
		//keep data in shared memory as the model attribute
		map.put("attr1", new Date());
		map.put("attr2","Forward");
		map.put("attr3", "Report");
		
		return "redirect:report";  //source 
		
	}
	
	@RequestMapping("/report")  //destination
	public String showReportPage(Map<String, Object> map) {
		System.out.println("ShowHomeController.showReportPage()");
		//keep data in shared memory as the model attribute
		map.put("attr1", new Date());
		map.put("attr2","Show");
		map.put("attr3", "Report");
		
		return "show_report";
		
	}
}
