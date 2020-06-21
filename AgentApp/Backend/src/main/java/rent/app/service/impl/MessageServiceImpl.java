package rent.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rent.app.dto.DTOEntity;
import rent.app.dto.DtoUtils;
import rent.app.dto.MessageDto;
import rent.app.model.Message;
import rent.app.repository.MessageRepository;
import rent.app.service.MessageService;

import javax.websocket.server.ServerEndpoint;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final DtoUtils dtoUtils;

    @Override
    public void saveMessage(MessageDto messageDto) {
        Message m= (Message) dtoUtils.convertToEntity(new Message(),messageDto);
        messageRepository.save(m);
    }

    @Override
    public List<DTOEntity> getInbox(String recipient) {
        return messageRepository.findAllByRecipient(recipient)
                .stream()
                .map(m->dtoUtils.convertToDto(m,new MessageDto())).collect(Collectors.toList());
    }

    @Override
    public List<DTOEntity> getSentMessages(String sender) {
        return messageRepository.findAllBySender(sender)
                .stream()
                .map(m->dtoUtils.convertToDto(m,new MessageDto())).collect(Collectors.toList());
    }
}
