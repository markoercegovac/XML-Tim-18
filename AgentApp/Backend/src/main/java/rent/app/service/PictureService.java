package rent.app.service;

import org.springframework.stereotype.Service;
import rent.app.dto.AdvertDto;
import rent.app.dto.PictureDto;

import java.io.IOException;
import java.util.List;


public interface PictureService {
    void saveProfilePicture(PictureDto pictureDto) throws IOException;
    void savePictures(AdvertDto advertDto);
    String getProfilePicture();
    List<PictureDto> getPictures();
}
