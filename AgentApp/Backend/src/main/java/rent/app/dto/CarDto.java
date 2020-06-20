package rent.app.dto;

import lombok.Data;

@Data
public class CarDto implements DTOEntity {
    private Long id;
    private Long childrenSitNumber;
    private boolean isInsurance;
    private int travelDistance;
    private Long carBrand;
    private Long carClass;
    private Long carFuelType;
    private Long carModel;
    private Long carTransmissionType;
}
