package chat.service.impl;

import chat.model.ValidUserOwnerCommunication;
import chat.repository.ValidCommunicationRepository;
import chat.service.CommunicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommunicationServiceImpl implements CommunicationService {

    private final ValidCommunicationRepository communicationRepository;

    @Override
    public Set<String> getAllForCommunication(String email, boolean isOwner) throws NullPointerException {

        List<ValidUserOwnerCommunication> found;
        Set<String> ret = new HashSet<>();

        if(isOwner == true) {
            found = communicationRepository
                    .findAllByOwnerEmailAndIsDeletedFalse(email)
                    .orElseThrow(NullPointerException::new);
        } else {
            found = communicationRepository
                    .findAllByUserEmailAndIsDeletedFalse(email)
                    .orElseThrow(NullPointerException::new);
        }

        if(found != null && found.size() != 0) {
            found.forEach(pair -> {
                if(isOwner == true) {
                    ret.add(pair.getUserEmail());
                } else {
                    ret.add(pair.getOwnerEmail());
                }
            });
        }

        return ret;
    }
}
