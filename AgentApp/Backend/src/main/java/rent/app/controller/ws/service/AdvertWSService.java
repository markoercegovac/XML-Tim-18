package rent.app.controller.ws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import rent.app.controller.ws.WsNameSpace;
import rent.app.controller.ws.generate.AdvertRequest;
import rent.app.controller.ws.generate.PictureRequest;
import rent.app.controller.ws.generate.SoapResponse;
import rent.app.model.*;
import rent.app.repository.*;

import java.util.Date;
import java.util.List;

@Endpoint
public class AdvertWSService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private AdvertRepository advertRepository;

    @Autowired
    private PictureRepository pictureRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private CommentRepository commentRepository;

    @PayloadRoot(namespace = WsNameSpace.namespace,localPart = "advertRequest")
    @ResponsePayload
    public SoapResponse handleAdvert(AdvertRequest request){
        Advert advert=new Advert();
        request.setToken("firm@com");
        Car car=carRepository.findById(request.getCarId()).get();
        Price price=priceRepository.findById(request.getPriceId()).get();
        Picture profilePicture=pictureRepository.findById(request.getProfileImgId()).get();
        List<Picture> gallery =pictureRepository.findAllById(request.getGalleryImgIds());
        List<Reservation> reservations=reservationRepository.findAllById(request.getCaptureIds());
        advert.setOwner("firm@com");
        advert.setCar(car);
        advert.setPrice(price);
        advert.setProfilePicture(profilePicture);
        advert.setDescription(request.getDescription());
        if(advert.getPictureSet()!=null) {
            advert.getPictureSet().addAll(gallery);
        }
        else{
            advert.setPictureSet(gallery);
        }
        if(advert.getReservations()!=null){
            advert.getReservations().addAll(reservations);
        }
        else {
            advert.setReservations(reservations);

        }

        Date end=request.getEnd().toGregorianCalendar().getTime();
        advert.setEndOfAdvert(end);
        System.out.println("WS RECEIVED ADVERT "+request);
        Advert saved=advertRepository.save(advert);

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
