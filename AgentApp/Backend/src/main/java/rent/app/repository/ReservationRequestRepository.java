package rent.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rent.app.model.ReservationRequest;

import java.util.List;

public interface ReservationRequestRepository extends JpaRepository<ReservationRequest, Long> {

    List<ReservationRequest> findAllByCustomerEmailAndIsAccepted(String customerEmail,boolean accepted);
    List<ReservationRequest> findAllByOwnerEmailAndIsAccepted(String ownerEmail,boolean accepted);
}
