package rent.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rent.app.model.Car;

@Repository
public interface CaRrepository extends JpaRepository<Car, Long> {
	
}