package com.example.advert_search.service;

import com.example.advert_search.dto.*;
import com.example.advert_search.model.AdvertCopy;
import com.example.advert_search.model.CarReservedDate;
import com.example.advert_search.repository.SearchRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


public interface SearchService {

    void saveAdvert(AdvertCopy a);
    void saveCarReserved(CarReservedDate a);
    List<AdvertCopyDto> findAll();
    Set<AdvertCopyDto> findFreeAdverts(String city, Date start, Date end);
    void makeObjects();
    AdvertCopyDto findById(Long id);
    Set<AdvertCopyDto> findAdvertsByParameters(Set<AdvertCopyDto> freeAdverts);
    Set<CarBrandPomocnaDto> findAllMarks();
    Set<CarClassPomocnaDto> findAllClasses();
    Set<CarFuelTypePomocnaDto> findAllFuel();
    Set<CarModelPomocnaDto> findAllModels();
    Set<CarTransmissionTypePomocnaDto> findAllTransmission();
    Set<AdvertCopyDto> findAdvertsByParameters(String city, Date start, Date end, String carMark, String modelMark, String carFuelType, String carTransmissionType, String carClass, String priceFrom2, String priceTo2, String traveledKm2, String insurance, String numberOfSeats2, String mark2);
}
