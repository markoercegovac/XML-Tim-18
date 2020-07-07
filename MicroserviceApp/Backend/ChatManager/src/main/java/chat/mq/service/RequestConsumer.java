package chat.mq.service;

import com.google.gson.Gson;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import chat.model.ValidUserOwnerCommunication;
import chat.mq.dto.ChatMQ;
import chat.repository.ValidCommunicationRepository;

@Component
public class RequestConsumer {
	
	@Autowired
	private Gson gson;
	@Autowired
	private ValidCommunicationRepository validCommunicationRepo;

	@RabbitListener(queues="${rabbitmq.queue.from.request}")
    public void recievedMessage(String msg) {
	    System.out.println("MQ>> Got from user manager" +msg);

		try {
			ChatMQ mq = gson.fromJson(msg, ChatMQ.class);
			
			ValidUserOwnerCommunication v = new ValidUserOwnerCommunication();
			v.setOwnerEmail(mq.getOwnerEmail());
			v.setUserEmail(mq.getUserEmail());
			v.setDeleted(mq.isDeleted());

			validCommunicationRepo.save(v);
		} catch(Exception e) {
			System.out.println("MQ>> EXCEPTION");
		}
    }
}