package com.example.advert_search.service;

import com.example.advert_search.dto.AdvertCopyDto;
import com.example.advert_search.dto.CarReservedDateDto;
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
    Set<AdvertCopyDto> findFreeAdverts(Date start, Date end);
    void makeObjects();
    AdvertCopyDto findById(Long id);

}
