package rent.app.dto;

import lombok.Data;

@Data
public class CarFuelTypeDto implements DTOEntity {
    private Long id;
    private String fuelType;
    private boolean isRemoved;
}
