package rent.app.aspect;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import rent.app.controller.ws.client.PictureClient;
import rent.app.controller.ws.generate.PictureRequest;
import rent.app.controller.ws.generate.SoapResponse;
import rent.app.dto.PictureDto;
import rent.app.model.Picture;
import rent.app.repository.PictureRepository;

@Component
@Aspect
@RequiredArgsConstructor
public class PictureAspect {
    private final PictureClient pictureClient;
    private final PictureRepository pictureRepository;

    @After(value = "execution(* rent.app.service.impl.PictureServiceImpl.saveProfilePicture(..)) && args(picture)")
    public void afterSavedPicture(JoinPoint joinPoint, PictureDto picture){
        PictureRequest request=new PictureRequest();
        request.setBase64(picture.getPicture());
        Picture p=pictureRepository.findByPath(picture.getPath());
        request.setId(p.getId());
        request.setToken("firm@com");

        SoapResponse response= pictureClient.handlePicture(request);
        System.out.println("STATUS: "+ response.getStatus());

    }

}
