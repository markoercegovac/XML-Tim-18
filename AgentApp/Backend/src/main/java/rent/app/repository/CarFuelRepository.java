package rent.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rent.app.model.CarFuelType;

public interface CarFuelRepository extends JpaRepository<CarFuelType,Long> {
}
