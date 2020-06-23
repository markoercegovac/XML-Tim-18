package rent.app.service.impl;


import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import rent.app.dto.PictureDto;
import rent.app.model.Picture;
import rent.app.service.PictureService;


import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
@Service
@RequiredArgsConstructor
public class PictureServiceImpl implements PictureService {

    static String filePath="images/";

    @Override
    public void saveProfilePicture(PictureDto picture) throws IOException {
        String base64Image = picture.getPicture().split(",")[1];
        byte[] imgBytes = DatatypeConverter.parseBase64Binary(base64Image);
        BufferedImage img = ImageIO.read(new ByteArrayInputStream(imgBytes));
        String path = filePath + picture.getPath();

        File file = new File(path);
        ImageIO.write(img, "jpeg", file);
    }

    @Override
    public String getProfilePicture(Picture picture) throws IOException {
        byte[] fileContent = FileUtils.readFileToByteArray(new File(filePath+picture.getPath()));
        String encodedString = Base64.getEncoder().encodeToString(fileContent);
        return encodedString;
    }

    @Override
    public List<String> getPictures(List<Picture> gallery) {
        return null;
    }


}
