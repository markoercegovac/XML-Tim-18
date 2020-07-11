package rent.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rent.app.model.Advert;
import rent.app.model.Comment;

import java.util.Optional;

public interface AdvertRepository extends JpaRepository<Advert,Long> {
     Advert findAllById(Long advertId);
     Advert findByCommentsId(Long commentId);
}
