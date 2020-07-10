package com.example.advert_search.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import com.example.advert_search.dto.AdvertCopyDto;
import com.example.advert_search.dto.*;
import com.example.advert_search.repository.CarReservedDateRepository;
import com.example.advert_search.repository.SearchRepository;
import com.example.advert_search.service.SearchService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/search-manager")
@RestController
@CrossOrigin
public class SearchController {

    private final SearchService searchService;

    Date datumPoc = new Date();
    Date datumKraj = new Date();

    //pozovem jednom da mi se formiraju u bazi objekti
   @GetMapping("/objects")
   public ResponseEntity<?> getObjects(){

       searchService.makeObjects();

       return new ResponseEntity<>(HttpStatus.OK);
   }

    @PostMapping("/search/{city}/{startOfAdvert}/{endOfAdvert}")
    public ResponseEntity<Set<AdvertCopyDto>> getAdverts(@PathVariable("city") String city, @PathVariable("startOfAdvert") String startOfAdvert,
                                        @PathVariable("endOfAdvert") String endOfAdvert){


        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try{

            datumPoc = formatter.parse(startOfAdvert);
            datumKraj = formatter.parse(endOfAdvert);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }


        if (startOfAdvert.equals("undefined") || startOfAdvert.equals("")) {

            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        }
        if (endOfAdvert.equals("undefined") || endOfAdvert.equals("")) {

            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        }
        if (city.equals("undefined") || city.equals("")) {

            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        }

       Set<AdvertCopyDto> list = this.searchService.findFreeAdverts(city,datumPoc,datumKraj);

        for (AdvertCopyDto a : list) {
            System.out.println(a.getCity() + a.getAdvertCopyId());
        }

        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/allAdverts")
    public ResponseEntity<List<AdvertCopyDto>>getAllAdverts(){
    List<AdvertCopyDto> lista =  searchService.findAll();

      return new ResponseEntity<>(lista, HttpStatus.OK );
    }

    //Metode za select na frontu napredne pretrage(start)

    @GetMapping("/allMarks")
    public ResponseEntity<Set<CarBrandPomocnaDto>>getAllMarks(){
        Set<CarBrandPomocnaDto> lista =  searchService.findAllMarks();
//        for (CarBrandPomocnaDto c: lista) {
//            System.out.println(c.getName());
//        }

        return new ResponseEntity<>(lista, HttpStatus.OK );
    }

    @GetMapping("/allModels")
    public ResponseEntity<Set<CarModelPomocnaDto>>getAllModels(){
        Set<CarModelPomocnaDto> lista =  searchService.findAllModels();

        return new ResponseEntity<>(lista, HttpStatus.OK );
    }

    @GetMapping("/allFuelType")
    public ResponseEntity<Set<CarFuelTypePomocnaDto>>getAllFuel(){
        Set<CarFuelTypePomocnaDto> lista =  searchService.findAllFuel();

        return new ResponseEntity<>(lista, HttpStatus.OK );
    }

    @GetMapping("/allTransmissionType")
    public ResponseEntity<Set<CarTransmissionTypePomocnaDto>>getAllTransmission(){
        Set<CarTransmissionTypePomocnaDto> lista =  searchService.findAllTransmission();

        return new ResponseEntity<>(lista, HttpStatus.OK );
    }

    @GetMapping("/allClasses")
    public ResponseEntity<Set<CarClassPomocnaDto>>getAllClasses(){
        Set<CarClassPomocnaDto> lista =  searchService.findAllClasses();

        return new ResponseEntity<>(lista, HttpStatus.OK );
    }

    //Metode za select na frontu napredne pretrage(end)

    @PostMapping("/advancedAdverts/{city}/{startOfAdvert}/{endOfAdvert}/{carMark}/{modelMark}/{carFuelType}/{carTransmissionType}/{carClass}/{priceFrom}/{priceTo}/{traveledKm}/{plannedKm}/{insurance}/{numberOfSeats}/{mark}")
    public ResponseEntity<Set<AdvertCopyDto>> getAdvancedAdverts(@PathVariable("city") String city, @PathVariable("startOfAdvert") String startOfAdvert, @PathVariable("endOfAdvert") String endOfAdvert,
                                        @PathVariable("carMark") String carMark, @PathVariable("modelMark") String modelMark, @PathVariable("carFuelType") String carFuelType,
                                        @PathVariable("carTransmissionType") String carTransmissionType, @PathVariable("carClass") String carClass, @PathVariable("priceFrom") String priceFrom,
                                        @PathVariable("priceTo") String priceTo, @PathVariable("traveledKm") String traveledKm, @PathVariable("plannedKm") String plannedKm,
                                                @PathVariable("insurance") String insurance, @PathVariable("numberOfSeats") String numberOfSeats, @PathVariable("mark") String mark){



        if(carMark.equals("null")){
            carMark="";
        }
        if(modelMark.equals("null")){
            modelMark="";
        }
        if(carFuelType.equals("null")){
            carFuelType="";
        }
        if(carTransmissionType.equals("null")){
            carTransmissionType="";
        }
        if(carClass.equals("null")){
            carClass="";
        }
        if(insurance.equals("null")){
            insurance="";
        }
        if(priceFrom.equals("null")){
            priceFrom="";
        }
        if(priceTo.equals("null")){
            priceTo="";
        }
        if(traveledKm.equals("null")){
            traveledKm="";
        }
        if(mark.equals("null")){
            mark="";
        }
        if(numberOfSeats.equals("null")){
            numberOfSeats="";
        }

       SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try{

            datumPoc = formatter.parse(startOfAdvert);
            datumKraj = formatter.parse(endOfAdvert);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }


        if (startOfAdvert.equals("undefined") || startOfAdvert.equals("")) {

            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        }
        if (endOfAdvert.equals("undefined") || endOfAdvert.equals("")) {

            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        }
        if (city.equals("undefined") || city.equals("")) {

            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        }

        Set<AdvertCopyDto> list = this.searchService.findFreeAdverts(city, datumPoc,datumKraj);

        System.out.println("-----------------Slobodni oglasi-------------------");
        for (AdvertCopyDto a : list) {
            System.out.println(a.getCity() + a.getAdvertCopyId());
        }

        Set<AdvertCopyDto> konacnaLista = this.searchService.findAdvertsByParameters(city,datumPoc,datumKraj,carMark,modelMark,carFuelType,carTransmissionType,carClass, priceFrom, priceTo,traveledKm,insurance,numberOfSeats,mark);

        System.out.println("------------------Rezultat pretrage po dodatnim parametrima------------------");
        for (AdvertCopyDto a : konacnaLista) {
            System.out.println(a.getCity() + a.getAdvertCopyId());
        }

        return new ResponseEntity<>(konacnaLista, HttpStatus.OK);
    }

}
