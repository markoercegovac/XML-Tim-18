package rent.app.dto;

import lombok.Data;

@Data
public class CarModelDto implements DTOEntity {
    private Long id;
    private String modelName;
    private boolean isRemoved;
}
