package com.mea.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.apache.catalina.servlets.CGIServlet;
import org.apache.el.parser.AstFalse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class RequestParamController {

	/*//url:/data?sno=101&sname=Rahul
	@GetMapping("/data")
	public String readParams(@RequestParam("sno")int no,@RequestParam("sname")String name) {
		
		System.out.println(no+"  :::   "+name);
		return "welcome";
	}*/

	/*// url:/data?sno=101&sname=Rahul
	@GetMapping("/data")
	public String readParams(@RequestParam int sno, @RequestParam String sname) {
	
		System.out.println(sno + "  :::   " + sname);
		return "welcome";
	}*/

	/*// url:/data?sname=Rahul
		@GetMapping("/data")
		public String readParams(@RequestParam(required = false) Integer sno, @RequestParam String sname) //byDefault (required=true)
		{
	
			System.out.println(sno + "  :::   " + sname); //null  :::   Rahul
			return "welcome";
		}*/

	/*// url:/data?sno=999
	@GetMapping("/data")
	public String readParams(@RequestParam("sno") Integer sno, @RequestParam(defaultValue = "Rahul Kumar Pandey") String sname)
	{
	
		System.out.println(sno + "  :::   " + sname); // 999  :::   Rahul Kumar Pandey
		return "welcome";
	}*/

	/*// url:/data?sno=&sname=
	@GetMapping("/data")
	public String readParams(@RequestParam(value="sno",required = false,defaultValue = "1010") Integer sno,
			@RequestParam(defaultValue = "Rahul Kumar Pandey", value="sname", required = false) String sname) {
	
		System.out.println(sno + "  :::   " + sname); // 1010  :::   Rahul Kumar Pandey
		return "welcome";
	}*/

	/*// url:/data?sno101=&sname=Raja&sadd=NewDelhi&sadd=NewYork&sadd=Germany
	@GetMapping("/data")
	public String readParams(@RequestParam(value = "sno", defaultValue = "1010") Integer sno,
			@RequestParam(defaultValue = "Rahul Kumar Pandey", value = "sname") String sname,
			@RequestParam String[] sadd,
			@RequestParam("sadd") List<String> addList,
			@RequestParam("sadd") Set<String> addSet) {
	
		System.out.println(sno + "  :::   " + sname+"   :::   "+Arrays.toString(sadd)+
				                "   :::   "+addList+"   :::   "+addSet);
		//1010  :::   Raja   :::   [NewDelhi, NewYork, Germany]   :::   [NewDelhi, NewYork, Germany]   :::   [NewDelhi, NewYork, Germany]
		return "welcome";
	}*/

	/*// url:/data?sno101=&sname=Raja&sadd=NewDelhi&sadd=NewYork&sadd=Germany
	@GetMapping("/data")
	public String readParams(@RequestParam(value = "sno", defaultValue = "1010") Integer sno,
			@RequestParam(defaultValue = "Rahul Kumar Pandey", value = "sname") String sname,
			@RequestParam String sadd) {
	
		System.out.println(sno + "  :::   " + sname + "   :::   " + sadd); //1010  :::   Raja   :::   NewDelhi,NewYork,Germany
		return "welcome";
	}*/
	
	@Autowired
	private ServletContext sc;
	@Autowired
	private ServletConfig sg;
	
	@GetMapping("/data")
	public String showData(HttpSession session, HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		System.out.println("Web Application Name : "+sc.getContextPath()); //Web Application Name : /48-SB-MVC-Proj09_DataBinding_RequestParamBinding
		System.out.println("DS Logical Name : "+sg.getServletName()); //DS Logical Name : dispatcherServlet
		System.out.println("Session Id : "+session.getId()); //Session Id : 28986311F4FEA6F2EE335C4198D32497
		System.out.println("Current Request URI : "+request.getRequestURI()); //Current Request URI : /48-SB-MVC-Proj09_DataBinding_RequestParamBinding/data
		System.out.println("Response Context Type : "+response.getContentType()); //Response Context Type : null
		
		return "welcome";
	}
}
