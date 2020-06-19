package rent.app.service.impl;


import org.apache.catalina.Server;
import org.springframework.boot.autoconfigure.rsocket.RSocketProperties;
import org.springframework.stereotype.Service;
import rent.app.dto.AdvertDto;
import rent.app.dto.PictureDto;
import rent.app.service.PictureService;


import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.xml.bind.DatatypeConverter;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;
@Service
public class PictureServiceImpl implements PictureService {
    @Override
    public void saveProfilePicture(PictureDto picture) throws IOException {
        String base64Image = picture.getPicture().split(",")[1];
        byte[] imgBytes=DatatypeConverter.parseBase64Binary(base64Image);
        BufferedImage img= ImageIO.read(new ByteArrayInputStream(imgBytes));
        String path="images/"+picture.getPath();

        File file=new File(path);
        ImageIO.write(img,"png", file);
    }

    @Override
    public void savePictures(AdvertDto advertDto) {

    }

    @Override
    public String getProfilePicture() {
        return null;
    }

    @Override
    public List<PictureDto> getPictures() {
        return null;
    }
}
