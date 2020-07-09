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
			ClientCopy c = clientCopyRepository.findByEmail(u.getEmail());
			if(c == null) {
			 	c = new ClientCopy();
			}

			c.setEmail(u.getEmail());
			c.setAdverts(new ArrayList<>());
			c.setForbiddenAdvert(u.isForbiddenAdvert());
			c.setCreationEnabled(u.isCreationEnabled());
			c.setRemoved(u.isRemoved());
			c.setBanned(u.isBanned());
		
			clientCopyRepository.save(c);
		} catch(Exception e) {
			System.out.println("MQ>> EXCEPTION");
		}
    }
}
