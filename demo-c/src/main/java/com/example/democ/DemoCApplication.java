package com.example.democ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DemoCApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoCApplication.class, args);
	}
}
