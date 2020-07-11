package rent.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rent.app.model.AdvertRequest;
import java.util.List;

@Repository
public interface AdvertRequestRepository extends JpaRepository<AdvertRequest, Long> {

	List<AdvertRequest> findByAndApprovedTrue();

}
