package rent.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rent.app.model.CarModel;

public interface CarModelRepository extends JpaRepository<CarModel,Long> {
}
