package com.team18.WebServiceManager.mq.service.consumer;

import com.google.gson.Gson;
import com.team18.WebServiceManager.model.Agent;
import com.team18.WebServiceManager.mq.dto.AgentMQ;
import com.team18.WebServiceManager.repository.AgentRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConsumer {

	@Autowired
	private Gson gson;
	@Autowired
	private AgentRepository agents;

	@RabbitListener(queues="${rabbitmq.queue.from.user}")
	public void createAgent(String msg) {

		System.out.println(">MQ RECEIVED A NEW AGENT");
		AgentMQ ag = gson.fromJson(msg, AgentMQ.class);
		Agent a = new Agent();
		a.setAgentEmail(ag.getEmail());
		a.setAgentUrl(ag.getUrl());

		agents.save(a);
	}
}
