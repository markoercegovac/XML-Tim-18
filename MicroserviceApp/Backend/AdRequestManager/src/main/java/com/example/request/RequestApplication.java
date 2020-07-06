package com.example.request;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableEurekaClient
@EnableResourceServer
@EnableAspectJAutoProxy
public class RequestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RequestApplication.class, args);
		System.out.println("REQUEST APP STARTED_____________________________");
	}

}
