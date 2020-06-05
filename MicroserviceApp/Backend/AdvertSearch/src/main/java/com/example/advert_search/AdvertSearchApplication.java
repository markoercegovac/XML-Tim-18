package com.example.advert_search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class AdvertSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdvertSearchApplication.class, args);
    }

}
