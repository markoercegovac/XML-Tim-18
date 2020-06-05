//package com.example.advertmanagerapp.service;
//
//import com.example.advertmanagerapp.dto.AdvertDetailDTO;
//import com.example.advertmanagerapp.model.*;
//import com.example.advertmanagerapp.model.enums.TraveledUnit;
//import com.example.advertmanagerapp.repository.AdvertRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import java.util.Date;
//import java.util.HashSet;
//import java.util.Optional;
//
//@SpringBootTest
//class AdvertServiceImplTest {
//
//    @Autowired
////    private AdvertService adService;
//
//    @MockBean
//    private AdvertRepository adRepository;
//
//    private Optional<Advert> ad1;
//    private Optional<Advert> ad2;
//    private Optional<Advert> ad3;
//
//    @BeforeEach
////    void setUp() {
////        Price p = new Price(1l, "Price ONE", 125.00f, null, null, null, false, null);
////        ConcreteCar c = new ConcreteCar(
////                404l,
////                new CarBrand(1l, "FORD", false),
////                new CarClass(1l, "MUSCLE", false),
////                new CarFuelType(1l, "BENZINE", false),
////                new CarModel(1l, "MUSTANG", false),
////                new CarTransmissionType(1l, "7 GEARS", false),
////                null
////        );
////        OwnersCar car = new OwnersCar(
////                2l,
////                null,
////                20000.00f,
////                TraveledUnit.KM,
////                false,
////                0,
////                c,
////                null,
////                null,
////                null
////         );
////
////        ad1 = Optional.of(new Advert(
////                        101l,
////                        car,
////                        null,
////                        new HashSet<Picture>(),
////                null,
////                new Date(),
////                new Date(),
////                "FIRST AD",
////                true,
////                p,
////                null
////         ));
////
////        ad2 = Optional.of(new Advert(
////                102l,
////                car,
////                null,
////                new HashSet<Picture>(),
////                null,
////                new Date(),
////                new Date(),
////                "IS DELETED",
////                false,
////                p,
////                null
////        ));
////
////        ad3 = Optional.of(new Advert(
////                103l,
////                null,
////                null,
////                new HashSet<Picture>(),
////                null,
////                new Date(),
////                new Date(),
////                "IS DELETED",
////                false,
////                p,
////                null
////        ));
////    }
//
//
//    @Test
//    public void shouldPass() {
//        Mockito.when(adRepository.findByIdAndIsActiveTrue(101l)).thenReturn(ad1);
//
//        AdvertDetailDTO ret = adService.detailAdForClient(101l);
//
//        assert(ret!=null &&
//                ret.getAdvertId().equals(101l) &&
//                ret.getCarBrand().equals("FORD")
//        );
//    }
//
//    @Test
//    public void emptyDB() {
//        AdvertDetailDTO ret = adService.detailAdForClient(105l);
//
//        assert(ret==null);
//    }
//
//    @Test
//    public void adIsNotActive() {
//        Mockito.when(adRepository.findByIdAndIsActiveTrue(102l)).thenReturn(null);
//        AdvertDetailDTO ret = adService.detailAdForClient(102l);
//
//        assert(ret==null);
//    }
//
//    @Test
//    public void noCar() {
//        Mockito.when(adRepository.findByIdAndIsActiveTrue(103l)).thenReturn(ad3);
//
//        AdvertDetailDTO ret = adService.detailAdForClient(103l);
//
//        assert(ret==null);
//    }
//}