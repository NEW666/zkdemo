package com.myproject.zkdemo;


import com.myproject.zkdemo.conf.ZKCustor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;

import java.util.List;


@EnableDiscoveryClient
@SpringBootApplication
@RefreshScope
public class ZkdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZkdemoApplication.class, args);
	}

	@Bean(initMethod = "init")
	public ZKCustor zkCustor(){
		return new ZKCustor();
	}

}
