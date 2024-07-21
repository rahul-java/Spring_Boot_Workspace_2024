package com.mea.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mea.model.Actor;

@RestController
@RequestMapping("/actor-api")
public class ActorOperationsAPI {

	@GetMapping("/wish")
	public ResponseEntity<String> showResultMsg(){
		System.out.println("ActorOperationsAPI.showResultMsg()");
		return new ResponseEntity<String>("Good Morning",HttpStatus.OK);
	}
	
	@GetMapping("/wish/{id}/{name}")
	public ResponseEntity<String> showResultMsg1(@PathVariable Integer id,@PathVariable String name){
		System.out.println("ActorOperationsAPI.showResultMsg1()");
		return new ResponseEntity<String>("Good Morning : "+id+" ::: "+name,HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> registerActor(@RequestBody Actor actor){
		System.out.println("ActorOperationsAPI.registerActor()");
		System.out.println("Actor ::: "+actor);
		return new ResponseEntity<String>(actor.toString(),HttpStatus.OK);
	}
	
	@GetMapping("/report")
	public ResponseEntity<Actor> showReport(){
		Actor actor=new Actor(101020,"A-Raja","Hyd",500000.0,"Hero");
		return new ResponseEntity<Actor>(actor,HttpStatus.OK);
	}
}
