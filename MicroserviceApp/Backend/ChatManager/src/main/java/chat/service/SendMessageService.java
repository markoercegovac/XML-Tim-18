package chat.service;

import chat.dto.SendMessageDTO;
import org.springframework.stereotype.Service;

@Service
public interface SendMessageService {

    void send(SendMessageDTO sendMessage) throws Exception;
}
