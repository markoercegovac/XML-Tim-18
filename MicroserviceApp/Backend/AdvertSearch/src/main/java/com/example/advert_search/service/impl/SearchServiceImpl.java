package com.example.advert_search.service.impl;

import com.example.advert_search.dto.AdvertCopyDto;
import com.example.advert_search.dto.mapper.DtoUtils;
import com.example.advert_search.model.AdvertCopy;
import com.example.advert_search.repository.SearchRepository;
import com.example.advert_search.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {


    private final SearchRepository searchRepository;
    private final DtoUtils dtoUtils;

    Date datep1 = new Date();
    Date datek1 = new Date();
    Date datep2 = new Date();
    Date datek2 = new Date();
    Date datep3 = new Date();
    Date datek3 = new Date();




    @Override
    public void save(AdvertCopyDto a) {

        AdvertCopy advertCopy = (AdvertCopy) dtoUtils.convertToEntity(new AdvertCopy(), a);
        searchRepository.save(advertCopy);

    }

    @Override
    public List<AdvertCopyDto> findAll() {
        List<AdvertCopy> list = new ArrayList<>();
        list.addAll(this.searchRepository.findAll());
        List<AdvertCopyDto> listDto = new ArrayList<>();

        for (AdvertCopy a:list) {
            AdvertCopyDto advertCopyDto = (AdvertCopyDto) dtoUtils.convertToDto(a, new AdvertCopyDto());
            listDto.add(advertCopyDto);
        }


        return listDto;
    }

    @Override
    public List<AdvertCopyDto> findFreeAdverts(Date start, Date end) {
        List<AdvertCopy> list = this.searchRepository.findAllByStartOfAdvertGreaterThanAndStartOfAdvertGreaterThanOrEndOfAdvertLessThanAndEndOfAdvertLessThan(start, end, start, end);
      //     6jun -7jun /  8 jun - 13juna/ 14jun-15jun

        List<AdvertCopyDto> listDto = new ArrayList<>();

        for (AdvertCopy a:list) {
            AdvertCopyDto advertCopyDto = (AdvertCopyDto) dtoUtils.convertToDto(a, new AdvertCopyDto());
            listDto.add(advertCopyDto);
        }

        return listDto;
    }

    @Override
    public void makeObjects() {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String dateInStringp1 = "5-Aug-2020";
        String dateInStringk1 = "9-Aug-2020";
        String dateInStringp2 = "11-Aug-2020";
        String dateInStringk2 = "15-Aug-2020";
        String dateInStringp3 = "25-Aug-2020";
        String dateInStringk3 = "27-Aug-2020";
        try{
            datep1 = formatter.parse(dateInStringp1);
            datek1 = formatter.parse(dateInStringk1);
            datep2 = formatter.parse(dateInStringp2);
            datek2 = formatter.parse(dateInStringk2);
            datep3 = formatter.parse(dateInStringp3);
            datek3 = formatter.parse(dateInStringk3);

        }
        catch (ParseException e) {
            e.printStackTrace();
        }

        AdvertCopyDto advertCopyDto1 = new AdvertCopyDto("Sabac", datep1, datek1);
        AdvertCopyDto advertCopyDto2 = new AdvertCopyDto("Sabac", datep2, datek2);
        AdvertCopyDto advertCopyDto3 = new AdvertCopyDto("Sabac", datep3, datek3);

        save(advertCopyDto1);
        save(advertCopyDto2);
        save(advertCopyDto3);

    }
}
