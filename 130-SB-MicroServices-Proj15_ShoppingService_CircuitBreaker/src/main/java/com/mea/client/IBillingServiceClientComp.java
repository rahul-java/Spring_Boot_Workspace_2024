package com.mea.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@FeignClient("Billing-Service")
public interface IBillingServiceClientComp {

	@GetMapping("/billing-api/payment")
	public String invokeDoPayment();
	
	@GetMapping("/billing-api/payment/{cardNo}")
	public String invokeDoPayment1(@PathVariable("cardNo") Long cardNo);
}
