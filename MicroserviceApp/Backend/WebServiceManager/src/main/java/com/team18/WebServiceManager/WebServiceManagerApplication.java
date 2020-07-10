package com.team18.WebServiceManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.ws.config.annotation.EnableWs;

@SpringBootApplication
public class WebServiceManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebServiceManagerApplication.class, args);
	}

}
