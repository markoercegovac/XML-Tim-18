package rent.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rent.app.model.Picture;

public interface PictureRepository extends JpaRepository<Picture,Long> {
    Picture findByPath(String path);
}
