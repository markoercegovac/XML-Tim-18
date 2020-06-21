package rent.app.service;

import rent.app.dto.DTOEntity;
import rent.app.dto.MessageDto;

import java.util.List;

public interface MessageService {

    void saveMessage(MessageDto messageDto);
    List<DTOEntity> getInbox(String recipient);
    List<DTOEntity> getSentMessages(String sender);


}
