package chat.service.impl;

import chat.convertor.MessageConverter;
import chat.dto.LongMessageDTO;
import chat.dto.ShortMessageDTO;
import chat.model.Message;
import chat.repository.MessageRepository;
import chat.service.ReadMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReadMessageServiceImpl implements ReadMessageService {

    private final MessageRepository messageRepository;


    @Override
    @Transactional(readOnly = true)
    public Set<ShortMessageDTO> readAllMessages(String email, boolean isOwner) throws NullPointerException {

        Set<ShortMessageDTO> ret = new HashSet<>();
        List<Message> found;
        if(isOwner == true) {
            found = messageRepository.findAllByValidUserOwnerCommunicationOwnerEmail(email).orElse(null);
        } else {
            found =  messageRepository.findAllByValidUserOwnerCommunicationUserEmail(email).orElse(null);
        }

        if(found!= null && found.size() != 0) {
            found.forEach(msg -> {
                ret.add(MessageConverter.messageToShort(msg));
            });
        }
        return ret;
    }

    @Override
    @Transactional(readOnly = true)
    public Set<ShortMessageDTO> readAllMessageExchange(String email, boolean isOwner, String inCommunicationEmail) throws NullPointerException {
        Set<ShortMessageDTO> ret = new HashSet<>();
        List<Message> found;
        if(isOwner == true) {
            found = messageRepository
                    .findAllByValidUserOwnerCommunicationOwnerEmailAndValidUserOwnerCommunicationUserEmail(email, inCommunicationEmail)
                    .orElse(null);
        } else {
            found =  messageRepository
                    .findAllByValidUserOwnerCommunicationUserEmailAndValidUserOwnerCommunicationOwnerEmail(email, inCommunicationEmail)
                    .orElse(null);
        }

        if(found!= null && found.size() != 0) {
            found.forEach(msg -> {
                ret.add(MessageConverter.messageToShort(msg));
            });
        }
        return ret;
    }

    @Override
    @Transactional(readOnly = true)
    public LongMessageDTO readDetailMessage(Long id) throws NullPointerException {

        Message msg = messageRepository.findById(id).orElseThrow(NullPointerException::new);

        return MessageConverter.messageToLong(msg);
    }
}
