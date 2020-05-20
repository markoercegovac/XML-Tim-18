package chat.service;

import chat.dto.LongMessageDTO;
import chat.model.Message;
import chat.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    public LongMessageDTO getSpecificMessage(String userEmail, Long messageId) {

        LongMessageDTO retVal = null;
        Message finded = messageRepository.findById(messageId).orElse(null);
        if(finded != null) {
            retVal = new LongMessageDTO();
            retVal.setContent(finded.getContent());
            retVal.setCreationDate(finded.getCreationDate());
            retVal.setHeader(finded.getHeader());
            retVal.setReceiverEmail(finded.getReceiverEmail());
            retVal.setSenderEmail(finded.getSenderEmail());
            retVal.setMessageId(finded.getMessageId());
        }

        return retVal;
    }
}
