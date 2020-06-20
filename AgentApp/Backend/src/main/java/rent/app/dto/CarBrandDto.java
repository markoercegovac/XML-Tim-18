package rent.app.dto;

import lombok.Data;

@Data
public class CarBrandDto implements DTOEntity{
    private Long id;
    private String name;
    private boolean isRemoved;
}
