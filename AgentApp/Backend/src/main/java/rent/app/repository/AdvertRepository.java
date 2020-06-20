package rent.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rent.app.model.Advert;

public interface AdvertRepository extends JpaRepository<Advert,Long> {
}
