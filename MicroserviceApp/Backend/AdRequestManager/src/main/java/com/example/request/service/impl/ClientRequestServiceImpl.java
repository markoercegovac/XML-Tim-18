package com.example.request.service.impl;

import com.example.request.convertor.AdRequestClientConvertor;
import com.example.request.convertor.AdRequestDetailConverter;
import com.example.request.dto.AdRequestDetailedDTO;
import com.example.request.dto.AdRequestForClientDTO;
import com.example.request.dto.CreateAdBundleRequestDTO;
import com.example.request.model.AdvertCopy;
import com.example.request.model.AdvertStateEnum;
import com.example.request.model.Request;
import com.example.request.model.RequestBundle;
import com.example.request.repository.AdvertCopyRepository;
import com.example.request.repository.RequestBundleRepository;
import com.example.request.repository.RequestRepository;
import com.example.request.service.ClientRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ClientRequestServiceImpl implements ClientRequestService {

    private final RequestRepository requestRepository;
    private final RequestBundleRepository requestBundleRepository;
    private final AdvertCopyRepository advertCopyRepository;
    private final AdRequestDetailConverter adRequestDetailConverter;

    @Transactional(rollbackFor = Exception.class)
    public void createNewRequestBundle(CreateAdBundleRequestDTO createBundle) throws RuntimeException, Exception {

        List<Request> requests = new ArrayList<>();
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

                //provera da li moze da rezervise
                foundAdvert.getCarReservedDate().forEach(reserved -> {
                    if((reserved.getEndDate().compareTo(advert.getStartDate()) >= 0) &&
                        (reserved.getStartDate().compareTo(advert.getEndDate()) <= 0)) {
                            throw new RuntimeException("ADVERT IS REZERVED FOR ASKED DATE");
                    }
                });

                Request validRequest = new Request();
                validRequest.setStartReservationDate(advert.getStartDate());
                validRequest.setEndReservationDate(advert.getEndDate());
                requests.add(validRequest);
                requestRepository.save(validRequest);

                foundAdvert.getRequests().add(validRequest);
                advertCopyRepository.save(foundAdvert);
            }
        });

        RequestBundle wishedBundle = new RequestBundle();
        wishedBundle.setAdvertState(AdvertStateEnum.PENDING);
        wishedBundle.setCreationDateAndTime(new Date());
        wishedBundle.setOwnerEmail(createBundle.getAdvertOwnerEmail());
        wishedBundle.setRequestingUserEmail(createBundle.getRequestingUserEmail());
        wishedBundle.setPriceWithDiscount(createBundle.getPriceWithDiscount());
        wishedBundle.setRequests(requests);
        requestBundleRepository.save(wishedBundle);
    }

    public List<AdRequestDetailedDTO> findAllBundlesByStatus(String clientEmail, String status) {
        List<AdRequestDetailedDTO> retBundles = new ArrayList<>();
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
                retBundles.add(adRequestDetailConverter.fromBundleToAdRequestDetail(bundle));
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
