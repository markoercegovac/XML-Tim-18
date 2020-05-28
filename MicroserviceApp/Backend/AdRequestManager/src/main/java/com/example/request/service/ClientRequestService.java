package com.example.request.service;

import com.example.request.convertor.FromRequestBundleToAdRequestForClient;
import com.example.request.dto.AdRequestDTO;
import com.example.request.dto.AdRequestForClientDTO;
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
import java.util.*;

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

        createBundle.getRequestedAdverts().forEach(advert -> {

            AdvertCopy foundAdvert = advertCopyRepository.findById(advert.getAdvertId()).orElse(null);
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

                requestRepository.save(validRequest);
            }
        }
        );
    }

    public List<AdRequestForClientDTO> findAllBunlesByStatus(String clientEmail, String status) {
        List<AdRequestForClientDTO> retBundles = new ArrayList<>();
        List<RequestBundle> foundBundles;

        if(status == null) {
            foundBundles = requestBundleRepository.findAllByRequestingUserEmail(clientEmail).orElse(null);
        } else {
            switch(status) {
                case "PENDING":
                    foundBundles = requestBundleRepository.findAllByRequestingUserEmailAndAdvertState(clientEmail, AdvertStateEnum.PENDING).orElse(null);
                    break;
                case "APPROVED":
                    foundBundles = requestBundleRepository.findAllByRequestingUserEmailAndAdvertState(clientEmail, AdvertStateEnum.APPROVED).orElse(null);
                    break;
                case "PAID":
                    foundBundles = requestBundleRepository.findAllByRequestingUserEmailAndAdvertState(clientEmail, AdvertStateEnum.PAID).orElse(null);
                    break;
                case "CANCEL":
                    foundBundles = requestBundleRepository.findAllByRequestingUserEmailAndAdvertState(clientEmail, AdvertStateEnum.CANCEL).orElse(null);
                    break;
                default:
                    foundBundles = requestBundleRepository.findAllByRequestingUserEmail(clientEmail).orElse(null);
            }
        }

        if(foundBundles != null) {
            foundBundles.forEach(bundle -> {
                retBundles.add(FromRequestBundleToAdRequestForClient.convert(bundle));
            });
        }

        return retBundles;
    }

    public void clientPaid(Long bundleId) throws Exception, NullPointerException{
        //verovatno ce trebati i client da se proveri

        RequestBundle forPaying = requestBundleRepository.getOne(bundleId);
        if(forPaying.getAdvertState().equals(AdvertStateEnum.APPROVED)) {
            forPaying.setAdvertState(AdvertStateEnum.PAID);
            requestBundleRepository.save(forPaying);
        } else {
            throw new Exception("REQUEST IS NOT APPROVED");
        }
    }

}
