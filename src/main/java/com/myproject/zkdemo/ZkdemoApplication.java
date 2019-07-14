package com.myproject.zkdemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.List;


@EnableDiscoveryClient
@SpringBootApplication
public class ZkdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZkdemoApplication.class, args);
	}



	@Autowired
	private DiscoveryClient discoveryClient;

	public String serviceUrl() {
		List<ServiceInstance> list = discoveryClient.getInstances("conf");
		if (list != null && list.size() > 0 ) {
			return list.get(0).getUri().toString();
		}
		return null;
	}

}
