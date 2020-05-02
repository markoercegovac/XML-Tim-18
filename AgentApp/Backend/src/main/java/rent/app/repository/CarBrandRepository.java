package rent.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rent.app.model.CarBrand;

public interface CarBrandRepository extends JpaRepository<CarBrand,Long> {
}
