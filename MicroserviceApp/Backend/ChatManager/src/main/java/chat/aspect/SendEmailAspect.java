package chat.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import chat.dto.SendMessageDTO;
import chat.mq.dto.Mail;
import chat.mq.service.MailProducer;


@Component
@Aspect
public class SendEmailAspect {


	@Autowired
	private MailProducer mailProducer;

	@After(value = "execution(* chat.service.impl.SendMessageServiceImpl.send(..)) and args(sendMessage)")
	public void sendEmail(JoinPoint joinPoint, SendMessageDTO sendMessage) {
		
		Mail msg = new Mail(
			sendMessage.getReceiverEmail(),
			sendMessage.getSenderEmail(),
			sendMessage.getHeader(),
			sendMessage.getContent());

		try {
			mailProducer.produceMsg(msg);
		}catch (Exception e) {
			System.out.println("!!!MQ IS NOT AVAILABLE!!!");
		}
	}
}
