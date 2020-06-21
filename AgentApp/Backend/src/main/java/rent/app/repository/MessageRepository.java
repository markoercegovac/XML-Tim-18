package rent.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rent.app.model.Message;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Long> {

    List<Message> findAllBySender(String sender);
    List<Message> findAllByRecipient(String recipient);

}
