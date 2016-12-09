package com.grb.springcloud.eurekaclient;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserExportCtl {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
    @RequestMapping(value="/test")
	public String echo() {
    	
		ServiceInstance serviceInstance = loadBalancerClient.choose("pay-indonesia");
		if (serviceInstance != null) {
            System.out.println(String.format("http://%s:%d", serviceInstance.getHost(), serviceInstance.getPort()));
        } else {
            throw new IllegalStateException("Unable to locate a leaderboard service");
        }
		URI url = URI.create(String.format("http://%s:%d/testEureka", serviceInstance.getHost(), serviceInstance.getPort()));

        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.set("exerciseName", "");
        params.set("lifterName", "");
        params.set("reps", "");
        params.set("weight", "");
        System.out.println(url.toString());
        String returnstr = this.restTemplate.getForObject(url, String.class);
        //this.restTemplate.postForLocation(url, params);
		return returnstr;
	}
	
}
