package com.example.advertmanagerapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.context.annotation.EnableAspectJAutoProxy;


@SpringBootApplication
//@EnableEurekaClient
@EnableAspectJAutoProxy
//@EnableResourceServer
public class AdvertmanagerAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdvertmanagerAppApplication.class, args);
        System.out.println("ADVERT MANAGER STARTED______________________________");
    }
}
