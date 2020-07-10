package rent.app.dto;

import lombok.Data;

@Data
public class AdvertMiniDto implements DTOEntity {
    private Long advertId;
    private String profilePicture;
    private float price;
    private float grade;
    private String traveledDistance;
    private String distanceUnit;
    private String carBrand;
    private String carModel;
}
