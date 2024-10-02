package com.mea.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mea.entity.IPLTeam;

@FeignClient("IPLTEAM-SERVICE")
public interface IPLTeamServiceMSClient {

	 @GetMapping("/team-api/find/{id}")
	 public  IPLTeam   getTeamById(@PathVariable int id);
}
