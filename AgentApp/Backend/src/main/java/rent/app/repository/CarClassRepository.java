package rent.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rent.app.model.CarClass;

public interface CarClassRepository extends JpaRepository<CarClass,Long> {
}
