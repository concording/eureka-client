//package com.grb.springcloud.eurekaclient;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class UserExport2Ctl{
//
//	/*@Autowired
//	private DiscoveryClient discoveryClient;*/
//	@Autowired
//	private LoadBalancerClient loadBalancerClient;
//	
//    @RequestMapping(value="/test")
//	public String echo() {
//		try {
//			/*List<ServiceInstance> instances = discoveryClient.getInstances("pay-indonesia");
//			for(ServiceInstance serviceInstance:instances){
//				System.out.println(serviceInstance.getHost()+":"+serviceInstance.getPort());
//			}*/
//			ServiceInstance serviceInstance = loadBalancerClient.choose("pay-indonesia");
//			if (serviceInstance != null) {
//	            System.out.println(String.format("http://%s:%d", serviceInstance.getHost(), serviceInstance.getPort()));
//	        } else {
//	            throw new IllegalStateException("Unable to locate a leaderboard service");
//	        }
//		} catch (Exception e) {
//			System.out.println(e);
//			return "error";
//		}
//		return "final";
//	}
//}
