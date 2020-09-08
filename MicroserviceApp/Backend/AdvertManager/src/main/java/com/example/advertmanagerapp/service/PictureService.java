package com.example.advertmanagerapp.service;

import com.example.advertmanagerapp.dto.PictureDto;
import com.example.advertmanagerapp.model.Picture;

import java.io.IOException;

public interface PictureService {
    void savePicture(PictureDto pictureDto) throws IOException;
    String getPicture(Picture picture) throws IOException;
    void saveSoapPicture(String base, String name) throws IOException;
}
