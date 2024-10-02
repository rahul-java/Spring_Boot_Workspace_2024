package com.mea.ms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mea.entity.IPLTeam;
import com.mea.service.IPLTeamMgmtService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/team-api")
@Slf4j  //gives  Logger obj having  log
public class IPLTeamOperationsController {
	@Autowired
	private IPLTeamMgmtService teamService;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerTeam(@RequestBody IPLTeam team){
		//use service
			String resultMsg=teamService.registerIPLTeam(team);
			log.info("registerTeam method -- controller ");
			return new ResponseEntity<String>(resultMsg,HttpStatus.CREATED);
	}//method
	
	@GetMapping("/all")
	public  ResponseEntity<List<IPLTeam>>   showAllTeams(){
			//use service
			 List<IPLTeam> list=teamService.getAllTeams();
				log.info("showAllTeams() method -- controller ");
			 return  new ResponseEntity<List<IPLTeam>>(list,HttpStatus.OK);
	}//method
	
	@GetMapping("/find/{id}")
	public  ResponseEntity<IPLTeam>  showTeamById(@PathVariable int id){
			//use service
			IPLTeam team=teamService.getTeamById(id);
			log.info("showByTeamId(-) method -- controller ");
			return new ResponseEntity<IPLTeam>(team,HttpStatus.OK);
	}//method

}
