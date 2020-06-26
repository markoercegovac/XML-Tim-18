package rent.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rent.app.model.RegistrationRequest;


public interface RegistrationRequestRepository extends JpaRepository <RegistrationRequest ,String> {


}
