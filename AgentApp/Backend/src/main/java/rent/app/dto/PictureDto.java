package rent.app.dto;

import lombok.Data;

@Data
public class PictureDto {

    private Long id;
    private String picture;
    private Long advertId;
    private boolean isDeleted;
    private String path;
}
