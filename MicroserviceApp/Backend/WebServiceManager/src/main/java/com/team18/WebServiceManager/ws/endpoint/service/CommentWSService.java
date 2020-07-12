package com.team18.WebServiceManager.ws.endpoint.service;

import com.team18.WebServiceManager.model.Agent;
import com.team18.WebServiceManager.model.Comment;
import com.team18.WebServiceManager.mq.dto.CommentMQ;
import com.team18.WebServiceManager.mq.service.producer.CommentProducer;
import com.team18.WebServiceManager.repository.AdvertRepository;
import com.team18.WebServiceManager.repository.AgentRepository;
import com.team18.WebServiceManager.repository.CommentRepository;
import com.team18.WebServiceManager.ws.WsNameSpace;
import com.team18.WebServiceManager.ws.endpoint.dto.CommentRequest;
import com.team18.WebServiceManager.ws.endpoint.dto.SoapResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class CommentWSService {

	@Autowired
	private CommentProducer commentProducer;
	@Autowired
	private AgentRepository agentRepository;
	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private AdvertRepository advertRepository;

	@PayloadRoot(namespace = WsNameSpace.namespace, localPart = "commentRequest") //MORA MALO POCETNO SLOVO iz ARGUMENTA METODE
	@ResponsePayload
	public SoapResponse handleComment(@RequestPayload CommentRequest request) {
		Agent ag = agentRepository.findByAgentEmail(request.getToken());
		Comment b = commentRepository.findByAgentAgentIdAndKeyAG(ag.getAgentId(), request.getId());
		System.out.println("WS COMMENT GOT"+request);
		CommentMQ mq = new CommentMQ();
		mq.setId(request.getId());
		mq.setAdvertId(advertRepository.findByAgentAgentIdAndKeyAG(ag.getAgentId(), request.getAdvertId()).getKeyMS());
		mq.setContent(request.getContent());
		mq.setHeader(request.getHeader());
		mq.setCreationDate(request.getCreationDate());
		mq.setUserEmail(request.getUserEmail());

		commentProducer.produceComment(mq);

		SoapResponse response = new SoapResponse();
		response.setAgId(ag.getAgentId());
		if(b==null) {
			Comment comment = new Comment();
			comment.setAgent(ag);
			comment.setKeyAG(request.getId());
			List<Comment> sort = commentRepository.findByAgentAgentIdOrderByKeyMSDesc(ag.getAgentId());
			if(sort.isEmpty()) {
				comment.setKeyMS(1l);
			} else {
				Long key = sort.get(0).getKeyMS();
				comment.setKeyMS(++key);
			}

			commentRepository.save(comment);
			response.setStatus("CREATED");
		} else {
			response.setStatus("UPDATED");
		}
		return response;
	}
}
