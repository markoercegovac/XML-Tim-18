package rent.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rent.app.model.DriveReport;

import java.util.List;

public interface DriveReportRepository extends JpaRepository<DriveReport,Long> {


    List<DriveReport> findAllByCarReportId(Long carId);
}
