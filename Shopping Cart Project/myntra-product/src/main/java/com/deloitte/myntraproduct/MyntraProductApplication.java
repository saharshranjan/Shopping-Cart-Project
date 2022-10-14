package com.deloitte.myntraproduct;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MyntraProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyntraProductApplication.class, args);
	}
}
