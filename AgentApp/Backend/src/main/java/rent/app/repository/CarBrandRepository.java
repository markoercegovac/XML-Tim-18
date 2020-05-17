package rent.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rent.app.model.CarBrand;

import java.util.Set;

@Repository
public interface CarBrandRepository extends JpaRepository<CarBrand,Long> {



}
