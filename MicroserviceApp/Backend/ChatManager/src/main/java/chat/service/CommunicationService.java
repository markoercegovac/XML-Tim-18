package chat.service;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface CommunicationService {

    Set<String> getAllForCommunication(String email, boolean isOwner) throws NullPointerException;
}
