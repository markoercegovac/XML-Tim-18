package com.example.advert_search.service;

import com.example.advert_search.dto.AdvertCopyDto;
import com.example.advert_search.model.AdvertCopy;
import com.example.advert_search.repository.SearchRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public interface SearchService {

    void save(AdvertCopyDto a);
    List<AdvertCopyDto> findAll();
    List<AdvertCopyDto> findFreeAdverts(Date start, Date end);
    void makeObjects();

}
