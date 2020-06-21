package rent.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rent.app.model.DriveReport;

import java.util.List;

@Repository
public interface DriveReportRepository extends JpaRepository<DriveReport,Long> {

    List<DriveReport> findAll();
    List<DriveReport> findAllByCarReportId(Long carId);
}
