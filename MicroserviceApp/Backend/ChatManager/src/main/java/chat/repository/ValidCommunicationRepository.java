package chat.repository;

import chat.model.ValidUserOwnerCommunication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface ValidCommunicationRepository extends JpaRepository<ValidUserOwnerCommunication, Long> {

    Optional<ValidUserOwnerCommunication> findByOwnerEmailAndUserEmailAndIsDeletedFalse(String ownerEmail, String userEmail);
    Optional<List<ValidUserOwnerCommunication>> findAllByOwnerEmailAndIsDeletedFalse(String ownerEmail);
    Optional<List<ValidUserOwnerCommunication>> findAllByUserEmailAndIsDeletedFalse(String userEmail);
}
