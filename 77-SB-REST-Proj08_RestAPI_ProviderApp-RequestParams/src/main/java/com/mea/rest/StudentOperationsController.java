package com.mea.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student-api")
public class StudentOperationsController {

	
	//http://localhost:8080/77-SB-REST-Proj08_RestAPI_ProviderApp-RequestParams/student-api/show?sno=1001&sname=Rahul
	@GetMapping("/show")
	public ResponseEntity<String> showData(@RequestParam("sno")Integer no,@RequestParam("sname")String name){
		System.out.println("StudentOperationsController.showData() ::: "+no+" ::: "+name);
		return new ResponseEntity<String>(no+":::"+name,HttpStatus.OK);
	}
	
	//http://localhost:8080/77-SB-REST-Proj08_RestAPI_ProviderApp-RequestParams/student-api/show1?sno=1001&sname=Rahul
	@GetMapping("/show1")
	public ResponseEntity<String> showData1(@RequestParam Integer sno,@RequestParam String sname){
		System.out.println("StudentOperationsController.showData() ::: "+sno+" ::: "+sname);
		return new ResponseEntity<String>(sno+":::"+sname,HttpStatus.OK);
	}
	
	//http://localhost:8080/77-SB-REST-Proj08_RestAPI_ProviderApp-RequestParams/student-api/show2?sno=1001
	@GetMapping("/show2")
	public ResponseEntity<String> showData2(@RequestParam Integer sno,
			                                @RequestParam (required = false) String sname){
		System.out.println("StudentOperationsController.showData() ::: "+sno+" ::: "+sname);
		return new ResponseEntity<String>(sno+":::"+sname,HttpStatus.OK);
	}
	
	
	//http://localhost:8080/77-SB-REST-Proj08_RestAPI_ProviderApp-RequestParams/student-api/show3?sno=1001
	@GetMapping("/show3")
	public ResponseEntity<String> showData3(@RequestParam Integer sno,
			                                @RequestParam (required = false,defaultValue = "Ram") String sname){
		System.out.println("StudentOperationsController.showData() ::: "+sno+" ::: "+sname);
		return new ResponseEntity<String>(sno+":::"+sname,HttpStatus.OK);
	}


}
