package com.mea.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student-api")
public class StudentOperationsController {

	// http://localhost:8080/78-SB-REST-Proj09_RestAPI_ProviderApp-PathVariables/student-api/show/101/Rahul
	@GetMapping("/show/{sno}/{sname}")
	public ResponseEntity<String> showData(@PathVariable("sno") Integer no, @PathVariable("sname") String name) {
		System.out.println("StudentOperationsController.showData() ::: " + no + " ::: " + name);
		return new ResponseEntity<String>(no + " ::: " + name, HttpStatus.OK);
	}

	// http://localhost:8080/78-SB-REST-Proj09_RestAPI_ProviderApp-PathVariables/student-api/show1/Rahul/101
	@GetMapping("/show1/{sno}/{sname}")
	public ResponseEntity<String> showData1(@PathVariable("sno") String no, @PathVariable("sname") String name) {
		System.out.println("StudentOperationsController.showData() ::: " + no + " ::: " + name);
		return new ResponseEntity<String>(no + " ::: " + name, HttpStatus.OK);
	}

	// http://localhost:8080/78-SB-REST-Proj09_RestAPI_ProviderApp-PathVariables/student-api/show1/Rahul/101/Hyd
	// => ERROR(type=Not Found, status=404) More value that expected
	// http://localhost:8080/78-SB-REST-Proj09_RestAPI_ProviderApp-PathVariables/student-api/show1/Rahul
	// => ERROR(type=Not Found, status=404) Less value than expected

	// http://localhost:8080/78-SB-REST-Proj09_RestAPI_ProviderApp-PathVariables/student-api/show2/Rahul/101
	@GetMapping("/show2/{sno}/{sname}")
	public ResponseEntity<String> showData2(@PathVariable("sno") String no, @PathVariable String sname) {
		System.out.println("StudentOperationsController.showData() ::: " + no + " ::: " + sname);
		return new ResponseEntity<String>(no + " ::: " + sname, HttpStatus.OK);
	}

	// http://localhost:8080/78-SB-REST-Proj09_RestAPI_ProviderApp-PathVariables/student-api/show3/Rahul
	// => ERROR
	@GetMapping("/show3/{sno}/{sname}")
	public ResponseEntity<String> showData3(@PathVariable("sno") String no,
			@PathVariable(name = "sname",required = false) String sname) {
		System.out.println("StudentOperationsController.showData() ::: " + no + " ::: " + sname);
		return new ResponseEntity<String>(no + " ::: " + sname, HttpStatus.OK);
	}

	//Both Works
	// http://localhost:8080/78-SB-REST-Proj09_RestAPI_ProviderApp-PathVariables/student-api/show4/101/Rahul
	// http://localhost:8080/78-SB-REST-Proj09_RestAPI_ProviderApp-PathVariables/student-api/show4/Rahul
	@GetMapping({"/show4/{sno}/{sname}","/show4/{sno}"})
	public ResponseEntity<String> showData4(@PathVariable("sno") String no,
			@PathVariable(name = "sname" ,required = false) String sname) {
		System.out.println("StudentOperationsController.showData() ::: " + no + " ::: " + sname);
		return new ResponseEntity<String>(no + " ::: " + sname, HttpStatus.OK);
	}
	
	//Static Dynamic URLs
	
	//http://localhost:8080/78-SB-REST-Proj09_RestAPI_ProviderApp-PathVariables/student-api/report/sno/sname
	// both static
	@GetMapping("/report/sno/sname")
	public ResponseEntity<String> showReport1() {
		System.out.println("StudentOperationsController.showReport1()");
		return new ResponseEntity<String>("showReport1", HttpStatus.OK);
	}
	
	//http://localhost:8080/78-SB-REST-Proj09_RestAPI_ProviderApp-PathVariables/student-api/report/1001/sname
	@GetMapping("/report/{sno}/sname")
	public ResponseEntity<String> showReport2() {
		System.out.println("StudentOperationsController.showReport2()");
		return new ResponseEntity<String>("showReport2", HttpStatus.OK);
	}
	
	//http://localhost:8080/78-SB-REST-Proj09_RestAPI_ProviderApp-PathVariables/student-api/report/sno/Rahul
	@GetMapping("/report/sno/{sname}")
	public ResponseEntity<String> showReport3() {
		System.out.println("StudentOperationsController.showReport3()");
		return new ResponseEntity<String>("showReport3", HttpStatus.OK);
	}
	
	//http://localhost:8080/78-SB-REST-Proj09_RestAPI_ProviderApp-PathVariables/student-api/report/1001/Rahul
	// both dynamic
	@GetMapping("/report/{sno}/{sname}")
	public ResponseEntity<String> showReport4() {
		System.out.println("StudentOperationsController.showReport4()");
		return new ResponseEntity<String>("showReport4", HttpStatus.OK);
	}

	
	//=================================================Receiving Values===================================================================================
	
	//http://localhost:8080/78-SB-REST-Proj09_RestAPI_ProviderApp-PathVariables/student-api/report1/sno/sname
	@GetMapping("/report1/sno/sname")
	public ResponseEntity<String> showReport11(@PathVariable(value = "sno",required = false) Integer sno,
			                                   @PathVariable(value = "sname",required = false) String sname) {
		System.out.println("StudentOperationsController.showReport11() "+sno+" ::: "+sname);
		return new ResponseEntity<String>("showReport11"+sno+" ::: "+sname, HttpStatus.OK);
	}
	
	//http://localhost:8080/78-SB-REST-Proj09_RestAPI_ProviderApp-PathVariables/student-api/report1/1001/sname
	@GetMapping("/report1/{sno}/sname")
	public ResponseEntity<String> showReport21(@PathVariable(value = "sno",required = false) Integer sno,
            @PathVariable(value = "sname",required = false) String sname) {
		System.out.println("StudentOperationsController.showReport21()"+sno+" ::: "+sname);
		return new ResponseEntity<String>("showReport21"+sno+" ::: "+sname, HttpStatus.OK);
	}
	
	//http://localhost:8080/78-SB-REST-Proj09_RestAPI_ProviderApp-PathVariables/student-api/report1/sno/Rahul
	@GetMapping("/report1/sno/{sname}")
	public ResponseEntity<String> showReport31(@PathVariable(value = "sno",required = false) Integer sno,
            @PathVariable(value = "sname",required = false) String sname) {
		System.out.println("StudentOperationsController.showReport31()"+sno+" ::: "+sname);
		return new ResponseEntity<String>("showReport31"+sno+" ::: "+sname, HttpStatus.OK);
	}
	
	//http://localhost:8080/78-SB-REST-Proj09_RestAPI_ProviderApp-PathVariables/student-api/report1/1001/Rahul
	// both dynamic
	@GetMapping("/report1/{sno}/{sname}")
	public ResponseEntity<String> showReport41(@PathVariable(value = "sno",required = false) Integer sno,
            @PathVariable(value = "sname",required = false) String sname) {
		System.out.println("StudentOperationsController.showReport41()"+sno+" ::: "+sname);
		return new ResponseEntity<String>("showReport41"+sno+" ::: "+sname, HttpStatus.OK);
	}

}
