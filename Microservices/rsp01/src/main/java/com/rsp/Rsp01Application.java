package com.rsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Rsp01Application {

	public static void main(String[] args) {
		SpringApplication.run(Rsp01Application.class, args);
	}

}
