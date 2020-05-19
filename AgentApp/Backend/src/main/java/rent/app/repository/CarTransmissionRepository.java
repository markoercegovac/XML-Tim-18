package rent.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rent.app.model.CarTransmissionType;

public interface CarTransmissionRepository extends JpaRepository<CarTransmissionType,Long> {
}
