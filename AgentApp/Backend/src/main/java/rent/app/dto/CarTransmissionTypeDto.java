package rent.app.dto;

import lombok.Data;

@Data
public class CarTransmissionTypeDto implements DTOEntity {
    private Long id;
    private String transmissionType;
    private boolean isRemoved;
}
