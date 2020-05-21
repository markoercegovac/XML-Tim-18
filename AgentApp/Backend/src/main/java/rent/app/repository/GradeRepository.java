package rent.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rent.app.model.Grade;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade,Long> {

    List<Grade> findAllByAdvertId(Long advertId);
}
