package rent.app.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DriveReportDto {
    private Long id;
    private float traveledDistance;
    private String describe;
    private Date dateOfReport;
    private Long carId;
}
