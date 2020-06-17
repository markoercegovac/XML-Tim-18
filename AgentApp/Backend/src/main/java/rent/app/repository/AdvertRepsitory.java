package rent.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rent.app.model.Advert;

@Repository
public interface AdvertRepsitory extends JpaRepository<Advert, Long>{
}