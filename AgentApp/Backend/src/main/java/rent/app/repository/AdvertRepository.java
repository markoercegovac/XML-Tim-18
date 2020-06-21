package rent.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rent.app.model.Advert;

import java.util.Optional;

public interface AdvertRepository extends JpaRepository<Advert,Long> {
     Advert findAllById(Long advertId);

}
