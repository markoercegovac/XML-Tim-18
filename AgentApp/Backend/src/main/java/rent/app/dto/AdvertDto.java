package rent.app.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
public class AdvertDto implements DTOEntity {
    private Long id;
    private Long carId;
    private PictureDto profilePicture;
    private List<PictureDto> pictureSet;
    private Date startOfAdvert;
    private Date endOfAdvert;
    private String description;
    private boolean isActive;
    private Long priceId;
}
