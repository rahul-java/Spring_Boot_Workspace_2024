package com.mea.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mea.model.Student;

@RestController
@RequestMapping("/student")
public class StudentOperationsController {

	@PostMapping("/save")
	public ResponseEntity<String> registerStudent(@RequestBody Student student){
		System.out.println("StudentOperationsController.registerStudent() ::: "+student);
		return new ResponseEntity<String>(student.toString(),HttpStatus.OK);
	}
	
	
	
	
	
	/*
	  JSON Input
	 
	 {
    "sno":101,
    "sname":"Rahul",
    "sadd":"New Delhi",
    "avg":56.5,
    "dob":"1991-12-20T11:30:20",
    "friends":["Ram","Ravi","Rahul"],
    "favColors":["Red","Black","Blue"],
    "phoneNos":[9999999999,8888888888],
    "idDetails":{
        "adhar":123123123123,
        "pan":"ABCDE12345",
        "PassportNo":147258369123
    },
    "address":{
        "houseNo":"C-91",
        "streat":6,
        "landmark":"Shiv Mandir",
        "city":"Delhi",
        "pincode":123456
    }

}
	 * */
	
	/*
	 XML Input
	 
	   <student>
     <sno>101</sno>
     <sname>Rahul</sname>
     <sadd>New Delhi</sadd>
     <avg>56.5</avg>
     <dob>1991-12-20T11:30:20</dob>
     <friends>
        <friends>Ram</friends>
        <friends>Ravi</friends>
        <friends>Rahul</friends>
    </friends>
    
     <favColors>
        <favColors>Red</favColors>
        <favColors>Black</favColors>
        <favColors>Blue</favColors>
     </favColors>
     
     <phoneNos>
        <phoneNos>9999999999</phoneNos>
        <phoneNos>8888888888</phoneNos>
     </phoneNos>
    
     <idDetails>
         <adhar>123123123123</adhar>
         <pan>ABCDE12345</pan>
         <PassportNo>147258369123</PassportNo>
     </idDetails>
     <address>
         <houseNo>C-91</houseNo>
         <streat>6</streat>
         <landmark>Shiv Mandir</landmark>
         <city>Delhi</city>
         <pincode>123456</pincode>
     </address>
 </student>

	 * /
	 */
}
