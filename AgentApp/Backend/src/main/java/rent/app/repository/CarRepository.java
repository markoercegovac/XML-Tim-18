package rent.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rent.app.model.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
}
