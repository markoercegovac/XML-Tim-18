package com.gateway.gateway;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="user-manager")
public interface AuthClient {

    @GetMapping("/verify/{email}")
    boolean verify(@PathVariable("email") String email);

    @GetMapping("/test")
    String test();

}
