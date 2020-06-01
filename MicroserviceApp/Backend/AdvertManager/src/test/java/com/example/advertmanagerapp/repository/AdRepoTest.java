package com.example.advertmanagerapp.repository;

import com.example.advertmanagerapp.model.*;
import com.example.advertmanagerapp.model.enums.TraveledUnit;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;

@SpringBootTest
public class AdRepoTest {

    /**
     * TESTS ARE FALLING BECOUSE AN ERROR IN INIT
     * */

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AdvertRepository adRepository;

    private Optional<Advert> ad1;
    private Optional<Advert> ad2;

    @BeforeEach
    void setUp() {
        Price p = new Price(1l, "Price ONE", 125.00f, null, null, null, false, null);
        ConcreteCar c = new ConcreteCar(
                404l,
                new CarBrand(1l, "FORD", false),
                new CarClass(1l, "MUSCLE", false),
                new CarFuelType(1l, "BENZINE", false),
                new CarModel(1l, "MUSTANG", false),
                new CarTransmissionType(1l, "7 GEARS", false),
                null
        );
        OwnersCar car = new OwnersCar(
                2l,
                null,
                1800000.0f,
                TraveledUnit.KM,
                false,
                0,
                c,
                null,
                null,
                null
        );

        ad1 = Optional.of(new Advert(
                101l,
                car,
                null,
                new HashSet<Picture>(),
                null,
                new Date(),
                new Date(),
                "FIRST AD",
                true,
                p,
                null
        ));

        ad2 = Optional.of(new Advert(
                102l,
                car,
                null,
                new HashSet<Picture>(),
                null,
                new Date(),
                new Date(),
                "IS DELETED",
                false,
                p,
                null
        ));

        //this.entityManager.persist(ad1);
        //this.entityManager.persist(ad2);
        this.adRepository.save(ad1.orElse(null));
        this.adRepository.save(ad2.orElse(null));
        this.adRepository.flush();
    }

    @Test
    public void adActive() {
        Advert a = adRepository.findByIdAndIsActiveTrue(101l).orElse(null);

        assert(a.getOwnersCar().getConcreteCar().getCarModel().equals("MUSTANG"));
    }

    @Test
    public void adNotActive() {
        Advert a = adRepository.findByIdAndIsActiveTrue(102l).orElse(null);

        assert(a == null);
    }
}
