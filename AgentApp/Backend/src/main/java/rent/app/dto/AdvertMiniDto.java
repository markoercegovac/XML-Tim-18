package rent.app.dto;

import lombok.Data;

@Data
public class AdvertMiniDto {
    private Long advertId;
    private String profilePicture;
    private String price;
    private String grade;
    private String traveledDistance;
    private String distanceUnit;
    private String carBrand;
    private String carModel;
}
