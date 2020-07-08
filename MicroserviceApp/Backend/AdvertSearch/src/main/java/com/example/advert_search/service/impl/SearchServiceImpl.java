package com.example.advert_search.service.impl;

import com.example.advert_search.dto.*;
import com.example.advert_search.dto.mapper.AdvertCopyMapper;
import com.example.advert_search.dto.mapper.CarReservedDateMapper;
import com.example.advert_search.dto.mapperGenericki.DtoUtils;
import com.example.advert_search.model.AdvertCopy;
import com.example.advert_search.model.CarReservedDate;
import com.example.advert_search.repository.CarReservedDateRepository;
import com.example.advert_search.repository.SearchRepository;
import com.example.advert_search.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {


    private final SearchRepository searchRepository;
    private final CarReservedDateRepository carReservedDateRepository;
    private final DtoUtils dtoUtils;
    private final AdvertCopyMapper advertCopyMapper;
    private final CarReservedDateMapper carReservedDateMapper;

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
    public Set<AdvertCopyDto> findFreeAdverts(String city, Date start, Date end) {
        List<AdvertCopyDto> advertCopyD = this.findAll();

        Set<AdvertCopyDto> konacna = new HashSet<>();
        Set<AdvertCopyDto> listaSlobodnihDatuma = new HashSet<>();
        boolean prekinuto = false;
        boolean cityHelp = false;

        for (AdvertCopyDto aa: advertCopyD) {
            label1:
            for (CarReservedDate cc : aa.getCarReservedDate()) {
                if(cc.getStartOfAdvert().compareTo(start) > 0 && cc.getStartOfAdvert().compareTo(end) < 0 ||
                        cc.getEndOfAdvert().compareTo(start) > 0 && cc.getEndOfAdvert().compareTo(end) < 0  ){
                    prekinuto=true;
                    break label1;
                }
            }
            if(!prekinuto){
                listaSlobodnihDatuma.add(aa);
            }
            prekinuto=false;
        }

        for (AdvertCopyDto a: listaSlobodnihDatuma) {
            if(a.getCity().equals(city)){
                konacna.add(a);
            }
        }

        return konacna;
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

        AdvertCopy advertCopy1 = new AdvertCopy("Sabac", "Audi", "A8", "Dizel", "Manuelni", "Visoka", 500,500,300,"YES",5,5,lista1);
        AdvertCopy advertCopy2 = new AdvertCopy("Beograd", "BMW", "X5", "Dizel", "Automatski", "Visoka", 550,400,200,"YES",5,5,lista2);;
        AdvertCopy advertCopy3 = new AdvertCopy("Sabac", "Citroen", "C5", "Benzin", "Manuelni", "Srednja",400,900,150,"NO",4,4,lista3);;

        CarReservedDate carReservedDate1 = new CarReservedDate(datep1, datek1);
        CarReservedDate carReservedDate2 = new CarReservedDate(datep2, datek2);
        CarReservedDate carReservedDate3 = new CarReservedDate(datep3, datek3);
        CarReservedDate carReservedDate4 = new CarReservedDate(datep4, datek4);
        CarReservedDate carReservedDate5 = new CarReservedDate(datep5, datek5);

        lista1.add(carReservedDate1);
        lista1.add(carReservedDate2);
        lista2.add(carReservedDate3);
        lista2.add(carReservedDate4);
        lista3.add(carReservedDate5);

        advertCopy1.setCarReservedDate(lista1);
        advertCopy2.setCarReservedDate(lista2);
        advertCopy3.setCarReservedDate(lista3);

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

    @Override
    public Set<AdvertCopyDto> findAdvertsByParameters(Set<AdvertCopyDto> freeAdverts) {
        return null;
    }


    @Override
    public Set<CarBrandPomocnaDto> findAllMarks() {

        List<AdvertCopyDto> advertCopyD = this.findAll();

        Set<CarBrandPomocnaDto> list = new HashSet<>();
        for (AdvertCopyDto a: advertCopyD) {
            CarBrandPomocnaDto c = new CarBrandPomocnaDto();
            c.setName(a.getCarMark());
            list.add(c);
        }

        return list;
    }

    @Override
    public Set<CarClassPomocnaDto> findAllClasses() {

        List<AdvertCopyDto> advertCopyD = this.findAll();

        Set<CarClassPomocnaDto> list = new HashSet<>();
        for (AdvertCopyDto a: advertCopyD) {
            CarClassPomocnaDto c = new CarClassPomocnaDto();
            c.setClassName(a.getCarClass());
            list.add(c);
        }
        return list;
    }

    @Override
    public Set<CarFuelTypePomocnaDto> findAllFuel() {

        List<AdvertCopyDto> advertCopyD = this.findAll();

        Set<CarFuelTypePomocnaDto> list = new HashSet<>();
        for (AdvertCopyDto a: advertCopyD) {
            CarFuelTypePomocnaDto c = new CarFuelTypePomocnaDto();
            c.setFuelType(a.getCarFuelType());
            list.add(c);
        }
        return list;
    }

    @Override
    public Set<CarModelPomocnaDto> findAllModels() {

        List<AdvertCopyDto> advertCopyD = this.findAll();

        Set<CarModelPomocnaDto> list = new HashSet<>();
        for (AdvertCopyDto a: advertCopyD) {
            CarModelPomocnaDto c = new CarModelPomocnaDto();
            c.setModelName(a.getModelMark());
            list.add(c);
        }
        return list;
    }

    @Override
    public Set<CarTransmissionTypePomocnaDto> findAllTransmission() {

        List<AdvertCopyDto> advertCopyD = this.findAll();

        Set<CarTransmissionTypePomocnaDto> list = new HashSet<>();
        for (AdvertCopyDto a: advertCopyD) {
            CarTransmissionTypePomocnaDto c = new CarTransmissionTypePomocnaDto();
            c.setTransmissionType(a.getCarTransmissionType());
            list.add(c);
        }
        return list;
    }

    @Override
    public Set<AdvertCopyDto> findAdvertsByParameters(String city, Date start, Date end, String carMark, String modelMark, String carFuelType, String carTransmissionType, String carClass,String priceFrom2, String priceTo2, String traveledKm2, String insurance, String numberOfSeats2, String mark2) {

        Set<AdvertCopyDto> konacnaLista = new HashSet<>();
        Set<AdvertCopyDto> list = this.findFreeAdverts(city, start, end);



            if(priceFrom2.equals("") && priceTo2.equals("") && traveledKm2.equals("")){
                for (AdvertCopyDto a: list) {
                    if (a.getCarMark().contains(carMark) && a.getModelMark().contains(modelMark) && a.getCarFuelType().contains(carFuelType) && a.getCarTransmissionType().contains(carTransmissionType) && a.getCarClass().contains(carClass) && a.getInsurance().contains(insurance) && Float.toString(a.getMark()).contains(mark2) && Integer.toString(a.getNumberOfSeats()).contains(numberOfSeats2)) {
                        konacnaLista.add(a);
                    }
                }
            }

           if(!priceFrom2.equals("") && !priceTo2.equals("") && !traveledKm2.equals("")){
               for (AdvertCopyDto a: list) {
                   if(a.getPrice() >= Float.parseFloat(priceFrom2) && a.getPrice() <= Float.parseFloat(priceTo2) && a.getTraveledKm() <= Float.parseFloat(traveledKm2)) {
                       if (a.getCarMark().contains(carMark) && a.getModelMark().contains(modelMark) && a.getCarFuelType().contains(carFuelType) && a.getCarTransmissionType().contains(carTransmissionType) && a.getCarClass().contains(carClass) && a.getInsurance().contains(insurance) && Float.toString(a.getMark()).contains(mark2) && Integer.toString(a.getNumberOfSeats()).contains(numberOfSeats2)) {
                           konacnaLista.add(a);
                       }
                   }
            }
        }

        if(priceFrom2.equals("") && !priceTo2.equals("") && !traveledKm2.equals("")){
            for (AdvertCopyDto a: list) {
                if(a.getPrice() <= Float.parseFloat(priceTo2) && a.getTraveledKm() <= Float.parseFloat(traveledKm2)) {
                    if (a.getCarMark().contains(carMark) && a.getModelMark().contains(modelMark) && a.getCarFuelType().contains(carFuelType) && a.getCarTransmissionType().contains(carTransmissionType) && a.getCarClass().contains(carClass) && a.getInsurance().contains(insurance) && Float.toString(a.getMark()).contains(mark2) && Integer.toString(a.getNumberOfSeats()).contains(numberOfSeats2)) {
                        konacnaLista.add(a);
                    }
                }
            }
        }

        if(!priceFrom2.equals("") && priceTo2.equals("") && !traveledKm2.equals("")){
            for (AdvertCopyDto a: list) {
                if(a.getPrice() >= Float.parseFloat(priceFrom2) && a.getTraveledKm() <= Float.parseFloat(traveledKm2)) {
                    if (a.getCarMark().contains(carMark) && a.getModelMark().contains(modelMark) && a.getCarFuelType().contains(carFuelType) && a.getCarTransmissionType().contains(carTransmissionType) && a.getCarClass().contains(carClass) && a.getInsurance().contains(insurance) && Float.toString(a.getMark()).contains(mark2) && Integer.toString(a.getNumberOfSeats()).contains(numberOfSeats2)) {
                        konacnaLista.add(a);
                    }
                }
            }
        }

        if(!priceFrom2.equals("") && !priceTo2.equals("") && traveledKm2.equals("")){
            for (AdvertCopyDto a: list) {
                if(a.getPrice() >= Float.parseFloat(priceFrom2) && a.getPrice() <= Float.parseFloat(priceTo2) ) {
                    if (a.getCarMark().contains(carMark) && a.getModelMark().contains(modelMark) && a.getCarFuelType().contains(carFuelType) && a.getCarTransmissionType().contains(carTransmissionType) && a.getCarClass().contains(carClass) && a.getInsurance().contains(insurance) && Float.toString(a.getMark()).contains(mark2) && Integer.toString(a.getNumberOfSeats()).contains(numberOfSeats2)) {
                        konacnaLista.add(a);
                    }
                }
            }
        }

        if(priceFrom2.equals("") && priceTo2.equals("") && !traveledKm2.equals("")){
            for (AdvertCopyDto a: list) {
                if(a.getTraveledKm() <= Float.parseFloat(traveledKm2)) {
                    if (a.getCarMark().contains(carMark) && a.getModelMark().contains(modelMark) && a.getCarFuelType().contains(carFuelType) && a.getCarTransmissionType().contains(carTransmissionType) && a.getCarClass().contains(carClass) && a.getInsurance().contains(insurance) && Float.toString(a.getMark()).contains(mark2) && Integer.toString(a.getNumberOfSeats()).contains(numberOfSeats2)) {
                        konacnaLista.add(a);
                    }
                }
            }
        }

        if(priceFrom2.equals("") && !priceTo2.equals("") && traveledKm2.equals("")){
            for (AdvertCopyDto a: list) {
                if(a.getPrice() <= Float.parseFloat(priceTo2)) {
                    if (a.getCarMark().contains(carMark) && a.getModelMark().contains(modelMark) && a.getCarFuelType().contains(carFuelType) && a.getCarTransmissionType().contains(carTransmissionType) && a.getCarClass().contains(carClass) && a.getInsurance().contains(insurance) && Float.toString(a.getMark()).contains(mark2) && Integer.toString(a.getNumberOfSeats()).contains(numberOfSeats2)) {
                        konacnaLista.add(a);
                    }
                }
            }
        }

        if(!priceFrom2.equals("") && priceTo2.equals("") && traveledKm2.equals("")){
            for (AdvertCopyDto a: list) {
                if(a.getPrice() >= Float.parseFloat(priceFrom2) && a.getPrice() <= Float.parseFloat(priceTo2) && a.getTraveledKm() <= Float.parseFloat(traveledKm2)) {
                    if (a.getCarMark().contains(carMark) && a.getModelMark().contains(modelMark) && a.getCarFuelType().contains(carFuelType) && a.getCarTransmissionType().contains(carTransmissionType) && a.getCarClass().contains(carClass) && a.getInsurance().contains(insurance) && Float.toString(a.getMark()).contains(mark2) && Integer.toString(a.getNumberOfSeats()).contains(numberOfSeats2)) {
                        konacnaLista.add(a);
                    }
                }
            }
        }
        return konacnaLista;
    }
}
