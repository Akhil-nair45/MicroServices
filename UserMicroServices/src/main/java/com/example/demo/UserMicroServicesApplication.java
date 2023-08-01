package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class UserMicroServicesApplication {
	
	
	//here if u want this not to be done in main package then we can also do it in new config package so thats the reason why we comment this and wrote the same in the config package now look into the config package
//	@Bean
//	public RestTemplate restTemplate()
//	{
//		return new RestTemplate();
//	}

	public static void main(String[] args) {
		SpringApplication.run(UserMicroServicesApplication.class, args);
	}

}
