package com.team18.xml.MailManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MailManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailManagerApplication.class, args);
		System.out.println("MAIL MANAGER STARTED___________________________");
	}

}
