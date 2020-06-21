package rent.app.dto;

import lombok.Data;
import rent.app.model.CarModel;

@Data
public class CarDtoMini {
    private Long id;
    private String carName;
    private String travelDistance;

}
