package com.team18.xml.MailManager.controller;

import com.team18.xml.MailManager.service.MyMailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/mail-manager")
public class TestController {
	
	@Autowired
	private MyMailSender mailSender;

	@GetMapping("/test")
	public ResponseEntity<?> test() {
		System.out.println("IN");
		try {
			mailSender.send("pera@maildrop.cc", "RENT IT", "Dear sir/madam");
		} catch(Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}
}