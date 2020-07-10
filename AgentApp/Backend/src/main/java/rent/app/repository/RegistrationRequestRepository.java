package rent.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rent.app.model.RegistrationRequest;
import rent.app.model.enums.RequestStatus;

import java.util.List;


public interface RegistrationRequestRepository extends JpaRepository <RegistrationRequest,String> {

    List<RegistrationRequest> findAllByStatus(RequestStatus aNew);

    RegistrationRequest findByEmail(String email);

}
