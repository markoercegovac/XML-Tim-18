package rent.app.dto;

import lombok.Data;

import java.util.List;

@Data
public class AdvertFullDto {
    private Long advertId;
    private String profileImage;
    private List<String> galleryImages;
    private float price;
    private float grade;
    private String ownerEmail;
    private String firmName;
    private String carBrand;
    private String carModel;
}

