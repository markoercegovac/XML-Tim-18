package rent.app.dto;

import lombok.Data;

@Data
public class CarClassDto implements DTOEntity{
    private Long id;
    private String className;
    private boolean isRemoved;
}
