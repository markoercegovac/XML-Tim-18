package com.example.advert_search.service.impl;

import com.example.advert_search.dto.AdvertCopyDto;
import com.example.advert_search.dto.CarReservedDateDto;
import com.example.advert_search.dto.mapper.DtoUtils;
import com.example.advert_search.model.AdvertCopy;
import com.example.advert_search.model.CarReservedDate;
import com.example.advert_search.repository.CarReservedDateRepository;
import com.example.advert_search.repository.SearchRepository;
import com.example.advert_search.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {


    private final SearchRepository searchRepository;
    private final CarReservedDateRepository carReservedDateRepository;
    private final DtoUtils dtoUtils;

    Date datep1 = new Date();
    Date datek1 = new Date();
    Date datep2 = new Date();
    Date datek2 = new Date();
    Date datep3 = new Date();
    Date datek3 = new Date();
    Date datep4 = new Date();
    Date datek4 = new Date();
    Date datep5 = new Date();
    Date datek5 = new Date();

    int i=0;


    @Override
    public void saveAdvert(AdvertCopy a) {

      //  AdvertCopy advertCopy = (AdvertCopy) dtoUtils.convertToEntity(new AdvertCopy(), a);
        searchRepository.save(a);

    }

    @Override
    public void saveCarReserved(CarReservedDate a) {

   //     CarReservedDate carReservedDate = (CarReservedDate) dtoUtils.convertToEntity(new CarReservedDate(), a);
        carReservedDateRepository.save(a);

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
    public Set<AdvertCopyDto> findFreeAdverts(Date start, Date end) {
        //iz baze vracam listu zauzeca koja ne uticu na zelju korisnika, pomocu Id-a, pronadjem i oglas sa tim zauzecima
        List<CarReservedDate> list = this.carReservedDateRepository.findAllByStartOfAdvertGreaterThanAndStartOfAdvertGreaterThanOrEndOfAdvertLessThanAndEndOfAdvertLessThan(start, end, start, end);
       //  6jun -7jun /  8 jun - 13juna/ 14jun-15jun

        List<AdvertCopy> advert = new ArrayList<>();
        Set<AdvertCopyDto> advertDto = new HashSet<>();

        for (CarReservedDate a:list) {
            advert.add(searchRepository.findByAdvertCopyId(a.getAdvertCopy().getAdvertCopyId()));
        }
  //      List<CarReservedDateDto> listWithoutDuplicates = listDto.stream().distinct().collect(Collectors.toList());

        //lista oglasa koji su slobodni(bez duplikata)
        for (AdvertCopy aaa: advert) {
            AdvertCopyDto advertCopyDto = (AdvertCopyDto) dtoUtils.convertToDto(aaa, new AdvertCopyDto());
            advertDto.add(advertCopyDto);
        }


        return advertDto;
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
        String dateInStringp4 = "4-Jul-2020";
        String dateInStringk4 = "9-Jul-2020";
        String dateInStringp5 = "11-Jul-2020";
        String dateInStringk5 = "15-Jul-2020";
        try{
            datep1 = formatter.parse(dateInStringp1);
            datek1 = formatter.parse(dateInStringk1);
            datep2 = formatter.parse(dateInStringp2);
            datek2 = formatter.parse(dateInStringk2);
            datep3 = formatter.parse(dateInStringp3);
            datek3 = formatter.parse(dateInStringk3);
            datep4 = formatter.parse(dateInStringp4);
            datek4 = formatter.parse(dateInStringk4);
            datep5 = formatter.parse(dateInStringp5);
            datek5 = formatter.parse(dateInStringk5);

        }
        catch (ParseException e) {
            e.printStackTrace();
        }


        List<CarReservedDate> lista1 = new ArrayList<>();
        List<CarReservedDate> lista2 = new ArrayList<>();
        List<CarReservedDate> lista3 = new ArrayList<>();

        AdvertCopy advertCopy1 = new AdvertCopy("Sabac", lista1);
        AdvertCopy advertCopy2 = new AdvertCopy("Sabac", lista2);
        AdvertCopy advertCopy3 = new AdvertCopy("Sabac", lista3);

        CarReservedDate carReservedDate1 = new CarReservedDate(datep1, datek1, advertCopy1);
        CarReservedDate carReservedDate2 = new CarReservedDate(datep2, datek2, advertCopy1);
        CarReservedDate carReservedDate3 = new CarReservedDate(datep3, datek3, advertCopy2);
        CarReservedDate carReservedDate4 = new CarReservedDate(datep4, datek4, advertCopy2);
        CarReservedDate carReservedDate5 = new CarReservedDate(datep5, datek5, advertCopy3);

        lista1.add(carReservedDate1);
        lista1.add(carReservedDate2);
        lista2.add(carReservedDate3);
        lista2.add(carReservedDate4);
   //     lista3.add(carReservedDate5);

        advertCopy1.setCarReservedDate(lista1);
        advertCopy2.setCarReservedDate(lista2);
     //   advertCopy3.setCarReservedDate(lista3);

        saveAdvert(advertCopy1);
        saveAdvert(advertCopy2);
        saveAdvert(advertCopy3);

        saveCarReserved(carReservedDate1);
        saveCarReserved(carReservedDate2);
        saveCarReserved(carReservedDate3);
        saveCarReserved(carReservedDate4);
        saveCarReserved(carReservedDate5);

    }

    @Override
    public AdvertCopyDto findById(Long id) {
        AdvertCopyDto advertCopyDto = (AdvertCopyDto) dtoUtils.convertToDto(searchRepository.findByAdvertCopyId(id), new AdvertCopyDto());
        return advertCopyDto;
    }
}
