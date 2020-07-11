package rent.app.aspect;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import rent.app.controller.ws.client.AdvertClient;
import rent.app.controller.ws.generate.AdvertRequest;
import rent.app.controller.ws.generate.SoapResponse;
import rent.app.model.Advert;
import rent.app.model.Picture;
import rent.app.repository.PictureRepository;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.util.ArrayList;
import java.util.List;


@Component
@Aspect
@RequiredArgsConstructor
public class AdvertAspect {

    private final AdvertClient advertClient;

    @AfterReturning(value = "execution(* com.example.advertmanagerapp.service.impl.AdvertServiceImpl.saveAdvert(..))", returning = "advert")
    public void afterSavedAdvert(JoinPoint joinPoint, Advert advert) throws DatatypeConfigurationException {
        AdvertRequest request=new AdvertRequest();
        request.setId(advert.getId());
        request.setCarId(advert.getCar().getId());
        request.setPriceId(advert.getPrice().getId());
        request.setDeleted(false);
        String dateTimeString = advert.getEndOfAdvert().toString();
        request.setDescription(advert.getDescription());
        request.setEnd(DatatypeFactory.newInstance().newXMLGregorianCalendar(dateTimeString));
        request.setProfileImgId(advert.getProfilePicture().getId());
        request.setToken("firm@com");
        List<Picture> pictureList= advert.getPictureSet();
        List<Long>ids=new ArrayList<>();
        pictureList.forEach(p->{ids.add(p.getId());});


        List<Long> captureIds=new ArrayList<>();
        advert.getReservations().forEach(r->{captureIds.add(r.getId());});

        if(request.getGalleryImgIds()!=null){
            request.getGalleryImgIds().addAll(ids);
        }
        if(request.getCaptureIds()!=null){
            request.getCaptureIds().addAll(captureIds);
        }
        String start = advert.getStartOfAdvert().toString();
        request.setStart(DatatypeFactory.newInstance().newXMLGregorianCalendar(start));
        SoapResponse response = advertClient.handleAdvert(request);
        System.out.println("STATUS: "+ response.getStatus());

    }

}
