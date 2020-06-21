package rent.app.service;

import org.springframework.stereotype.Service;
import rent.app.dto.DriveReportDto;

import java.util.List;

@Service
public interface DriveReportService {

    List<DriveReportDto> getAllReports();

    void addNewReport(DriveReportDto newReport);

    List<DriveReportDto> getAllReportsByCarId(Long carId);
}
