package chat.repository;

import chat.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    Optional<List<Message>> findAllByValidUserOwnerCommunicationUserEmail(String userEmail);
    Optional<List<Message>> findAllByValidUserOwnerCommunicationOwnerEmail(String ownerEmail);

    Optional<List<Message>> findAllByValidUserOwnerCommunicationOwnerEmailAndValidUserOwnerCommunicationUserEmail(String ownerEmail, String userEmail);
    Optional<List<Message>> findAllByValidUserOwnerCommunicationUserEmailAndValidUserOwnerCommunicationOwnerEmail(String userEmail, String ownerEmail);
}
