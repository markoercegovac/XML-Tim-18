package chat.service;

import chat.dto.LongMessageDTO;
import chat.dto.ShortMessageDTO;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface ReadMessageService {

    Set<ShortMessageDTO> readAllMessages(String email, boolean isOwner) throws NullPointerException;
    Set<ShortMessageDTO> readAllMessageExchange(String email, boolean isOwner,  String inCommunicationEmail) throws NullPointerException;
    LongMessageDTO readDetailMessage(Long id) throws NullPointerException;
}
