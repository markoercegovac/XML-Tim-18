package com.example.advertmanagerapp.mq.service;

import com.example.advertmanagerapp.model.ClientCopy;
import com.example.advertmanagerapp.mq.dto.UserMQ;
import com.example.advertmanagerapp.repository.ClientCopyRepository;
import com.google.gson.Gson;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UserConsumer {

	@Autowired
    private Gson gson;
	@Autowired
	private ClientCopyRepository clientCopyRepository;


	@RabbitListener(queues="${rabbitmq.queue.from.user}")
    public void recievedMessage(String msg) {
	    System.out.println("MQ>> Got from user manager" +msg);

		try {
			UserMQ u = gson.fromJson(msg, UserMQ.class);
			
			ClientCopy c = new ClientCopy();
			c.setEmail(u.getEmail());
			c.setName(u.getName());
			c.setSurname(u.getSurname());
			c.setCompanyName(u.getCompanyName());
			c.setAdverts(new ArrayList<>());
		
			clientCopyRepository.save(c);
		} catch(Exception e) {
			System.out.println("MQ>> EXCEPTION");
		}
    }
}