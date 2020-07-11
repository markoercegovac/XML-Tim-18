package com.team18.WebServiceManager.mq.service.consumer;

import com.google.gson.Gson;
import com.team18.WebServiceManager.model.Agent;
import com.team18.WebServiceManager.model.Comment;
import com.team18.WebServiceManager.mq.dto.CommentMQ;
import com.team18.WebServiceManager.repository.AdvertRepository;
import com.team18.WebServiceManager.repository.AgentRepository;
import com.team18.WebServiceManager.repository.CommentRepository;
import com.team18.WebServiceManager.ws.client.CommentWSClinet;
import com.team18.WebServiceManager.ws.endpoint.dto.CommentRequest;
import com.team18.WebServiceManager.ws.endpoint.dto.SoapResponse;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommentConsumer {

	@Autowired
	private Gson gson;
	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private AgentRepository agentRepository;
	@Autowired
	private AdvertRepository advertRepository;
	@Autowired
	private CommentWSClinet commentWSClinet;

	@RabbitListener(queues="${rabbitmq.queue.soap.comment.soap}")
	public void createComment(String msg) {

		CommentMQ mq = gson.fromJson(msg, CommentMQ.class);

		List<Agent> agents = agentRepository.findAll();
		agents.forEach(ag -> {
			//SVAKOM AGENTU POSLATI SOAP
			CommentRequest request = new CommentRequest();
			Comment b = commentRepository.findByAgentAgentIdAndKeyMS(ag.getAgentId(), mq.getId());
			request.setId(b!=null?b.getKeyAG():0);
			request.setToken(ag.getAgentEmail());
			request.setContent(mq.getContent());
			request.setCreationDate(mq.getCreationDate());
			request.setHeader(mq.getHeader());
			request.setUserEmail(mq.getUserEmail());
			request.setAdvertId(advertRepository.findByAgentAgentIdAndKeyAG(ag.getAgentId(), mq.getAdvertId()).getKeyAG());

			//POZOVE SE ODGOVARAJUCI KLIENT DA SE POSALJE SOAP
			commentWSClinet.setDefaultUri(ag.getAgentUrl());
			SoapResponse response = commentWSClinet.handleComment(request);

			if(b==null) {
				//TREBA DA SE KREIRA
				b = new Comment();
				b.setAgent(ag);
				b.setKeyMS(mq.getId());
				b.setKeyAG(response.getAgId());//dobijemo u SOAP RESPONSU, agId

				commentRepository.save(b);
			}
		});
	}
}
