package rent.app.dto;

import lombok.Data;

@Data
public class PictureDto implements DTOEntity {

    private Long id;
    private String picture;
    private Long advertId;
    private boolean isDeleted;
    private String path;
}
