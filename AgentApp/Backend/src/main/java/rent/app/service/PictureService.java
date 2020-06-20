package rent.app.service;

import rent.app.dto.PictureDto;
import rent.app.model.Picture;

import java.io.IOException;
import java.util.List;


public interface PictureService {
    void saveProfilePicture(PictureDto pictureDto) throws IOException;
    byte[] getProfilePicture(Picture picture) throws IOException;
    List<String> getPictures(List<Picture> gallery);
}
