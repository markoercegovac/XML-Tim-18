package rent.app.controller.ws.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import rent.app.controller.ws.WsNameSpace;
import rent.app.controller.ws.generate.PictureRequest;
import rent.app.controller.ws.generate.SoapResponse;
import rent.app.dto.PictureDto;
import rent.app.model.Picture;
import rent.app.repository.PictureRepository;
import rent.app.service.PictureService;

import java.io.IOException;

@RequiredArgsConstructor
@Endpoint
public class PictureWSService {


    private final PictureRepository pictureRepository;

    private final PictureService pictureService;

    @PayloadRoot(namespace = WsNameSpace.namespace, localPart = "pictureRequest")
    @ResponsePayload
    public SoapResponse handlePicture(@RequestPayload PictureRequest request) throws IOException {
        Picture picture=new Picture();
        picture.setId(request.getId()==0?null:request.getId());
        picture.setDeleted(request.isDeleted());
        picture.setPath(request.getName());
        PictureDto pictureDto=new PictureDto();
        pictureDto.setPath(request.getName());
        pictureDto.setPicture(request.getBase64());
        pictureService.saveProfilePicture(pictureDto);
        System.out.println("WS RECEIVED PICTURE "+request);
        request.setToken("firm@com");
        Picture saved=pictureRepository.save(picture);
        SoapResponse response = new SoapResponse();
        if(request.getId()==0) {
            response.setAgId(saved.getId());
            response.setStatus("CREATED");
        } else {
            response.setAgId(saved.getId());
            response.setStatus("UPDATED");
        }

        return response;
    }
}
