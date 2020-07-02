package com.example.advertmanagerapp.service.impl;

import com.example.advertmanagerapp.dto.PictureDto;
import com.example.advertmanagerapp.model.Picture;
import com.example.advertmanagerapp.service.PictureService;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

@Service
public class PictureServiceImplementation implements PictureService {

    static String filePath="../images/";

    @Override
    public void savePicture(PictureDto picture) throws IOException {
        String base64Image = picture.getPicture().split(",")[1];
        byte[] imgBytes = DatatypeConverter.parseBase64Binary(base64Image);
        BufferedImage img = ImageIO.read(new ByteArrayInputStream(imgBytes));
        String path = filePath + picture.getPath();
        Files.createDirectories(Paths.get("../images"));
        File file = new File(path);
        ImageIO.write(img, "jpeg", file);
    }

    @Override
    public String getPicture(Picture picture) throws IOException {
        byte[] fileContent = FileUtils.readFileToByteArray(new File(filePath+picture.getPath()));
        String encodedString = Base64.getEncoder().encodeToString(fileContent);
        return encodedString;
    }
}
