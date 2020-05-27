package com.example.request.service;

import com.example.request.dto.CreateAdBundleRequestDTO;
import com.example.request.model.AdvertCopy;
import com.example.request.model.AdvertStateEnum;
import com.example.request.model.Request;
import com.example.request.model.RequestBundle;
import com.example.request.repository.AdvertCopyRepository;
import com.example.request.repository.RequestBundleRepository;
import com.example.request.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ClientRequestService {

    private final RequestRepository requestRepository;
    private final RequestBundleRepository requestBundleRepository;
    private final AdvertCopyRepository advertCopyRepository;

    @Transactional(rollbackOn = Exception.class)
    public void createNewRequestBundle(CreateAdBundleRequestDTO createBundle) throws RuntimeException, Exception {

        RequestBundle wishedBundle = new RequestBundle();
        wishedBundle.setAdvertState(AdvertStateEnum.PENDING);
        wishedBundle.setCreationDateAndTime(new Date());
        wishedBundle.setOwnerEmail(createBundle.getAdvertOwnerEmail());
        wishedBundle.setRequestingUserEmail(createBundle.getRequestingUserEmail());
        wishedBundle.setPriceWithDiscount(createBundle.getPriceWithDiscount());
        requestBundleRepository.save(wishedBundle);

        Set<Request> wishedAdverts = new HashSet<>();
        createBundle.getRequestedAdverts().forEach(advert -> {

            AdvertCopy foundAdvert = advertCopyRepository.getOne(advert.getAdvertId());
            if(foundAdvert.equals(null)) {
                //oglas ne postoji u bazi
                throw new RuntimeException("ADVERT DOSE NOT EXIST");

            } else if(!foundAdvert.getOwnerEmail().equals(createBundle.getAdvertOwnerEmail())){
                //oglas nije od trazenog vlasnika
                throw new RuntimeException("ADVERT DOSE NOT HAVE APPROPRIATED OWNER");

            } else if(advert.getStartDate().after(advert.getEndDate())) {
                //datumi zauzeca idu u kontra smeru
                throw new RuntimeException("ADVERT DOSE NOT HAVE VALID DATE");

            } else if(advert.getStartDate().before(new Date())) {
                //datum zauzeca je u proslosti
                throw new RuntimeException("ADVERT DOSE NOT HAVE VALID START DATE");
            } else {
                Request validRequest = new Request();
                validRequest.setAdvertCopy(foundAdvert);
                validRequest.setStartReservationDate(advert.getStartDate());
                validRequest.setEndReservationDate(advert.getEndDate());
                validRequest.setRequestBundle(wishedBundle);

                wishedAdverts.add(validRequest);
                requestRepository.save(validRequest);
            }
        });
    }

}
