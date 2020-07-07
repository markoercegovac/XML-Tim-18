package chat.service.impl;

import chat.dto.SendMessageDTO;
import chat.model.DirectionEnum;
import chat.model.Message;
import chat.model.ValidUserOwnerCommunication;
import chat.repository.MessageRepository;
import chat.repository.ValidCommunicationRepository;
import chat.service.SendMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class SendMessageServiceImpl implements SendMessageService {

    private final MessageRepository messageRepository;
    private final ValidCommunicationRepository validCommunicationRepository;

    @Override
    @Transactional
    public void send(SendMessageDTO sendMessage) throws Exception {

        String sender = sendMessage.getSenderEmail();
        String receiver = sendMessage.getReceiverEmail();
        DirectionEnum direction = sendMessage.isOwnerSending()? DirectionEnum.FOR_OWNER:DirectionEnum.FOR_USER;

        ValidUserOwnerCommunication communication;
        if(direction.equals(DirectionEnum.FOR_OWNER)) {
            communication = validCommunicationRepository
                    .findByOwnerEmailAndUserEmailAndIsDeletedFalse(sender, receiver)
                    .orElseThrow(Exception::new);
        } else {
            communication = validCommunicationRepository
                    .findByOwnerEmailAndUserEmailAndIsDeletedFalse(receiver, sender)
                    .orElseThrow(Exception::new);
        }

        Message msg = new Message();
        msg.setContent(sendMessage.getContent());
        msg.setCreationDate(new Date());
        msg.setDirection(direction);
        msg.setHeader(sendMessage.getHeader());
        msg.setValidUserOwnerCommunication(communication);
        msg.setSeen(false);

        messageRepository.save(msg);
    }
}
