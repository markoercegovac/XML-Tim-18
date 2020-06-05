package com.example.request.services;

import static org.junit.jupiter.api.Assertions.*;
import com.example.request.dto.AdRequestDTO;
import com.example.request.dto.CreateAdBundleRequestDTO;
import com.example.request.model.AdvertCopy;
import com.example.request.repository.AdvertCopyRepository;
import com.example.request.repository.RequestBundleRepository;
import com.example.request.service.ClientRequestService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.*;

@SpringBootTest
class ClientRequestTest {

    @Autowired
    private ClientRequestService service;

    @Autowired
    private  RequestBundleRepository requestBundleRepository;

    @MockBean
    private AdvertCopyRepository advertCopyRepository;

    private CreateAdBundleRequestDTO bundle;
    private Optional<AdvertCopy> advert1;
    private Optional<AdvertCopy> advert2;
    private Optional<AdvertCopy> advert3;

    @BeforeEach
    private void setUp() {
        Calendar cal1 = Calendar.getInstance();
        cal1.set(2020, 5, 15, 16, 0, 0);

        Calendar cal2 = Calendar.getInstance();
        cal2.set(2020, 5, 25, 6, 0, 0);

        Calendar cal3 = Calendar.getInstance();
        cal3.set(2020, 5, 15, 15, 0, 0);

        Calendar cal4 = Calendar.getInstance();
        cal4.set(2020, 5, 17, 12, 30, 0);



        List<AdRequestDTO> adList = new ArrayList<>();
        adList.add(new AdRequestDTO(101L, cal1.getTime(), cal2.getTime()));
        adList.add(new AdRequestDTO(102L, cal3.getTime(), cal4.getTime()));

        bundle = new CreateAdBundleRequestDTO();
        bundle.setAdvertOwnerEmail("pera@mail");
        bundle.setPriceWithDiscount(256f);
        bundle.setRequestingUserEmail("svetlana@mail");
        bundle.setRequestedAdverts(adList);

        MockAdvertCopy();
    }

    private void MockAdvertCopy() {
        Calendar cal = Calendar.getInstance();
        cal.set(2021, 3, 3, 0, 0, 0);

        advert1 = Optional.of(new AdvertCopy(101L, cal.getTime(), "pera@mail", null, null));
        advert2 = Optional.of(new AdvertCopy(102L, cal.getTime(), "pera@mail", null, null));
        advert3 = Optional.of(new AdvertCopy(103L, cal.getTime(), "pera@mail", null, null));
    }

    @Test
    public void TwoAdPass() {
        Mockito.when(this.advertCopyRepository.findById(101l)).thenReturn(advert1);
        Mockito.when(this.advertCopyRepository.findById(102l)).thenReturn(advert2);

        int sizeBefore = requestBundleRepository.findAll().size();
        try {
            service.createNewRequestBundle(bundle);
        } catch (Exception e) {
            e.printStackTrace();
            assert(false);
        }

        int sizeAfter = requestBundleRepository.findAll().size();

        assert((sizeBefore+1)==sizeAfter);
    }

    @Test
    public void OneAdPass() {
        advertCopyRepository.deleteAll();

        Calendar cal3 = Calendar.getInstance();
        cal3.set(2020, 5, 15, 15, 0, 0);
        Calendar cal4 = Calendar.getInstance();
        cal4.set(2020, 5, 17, 12, 30, 0);

        List<AdRequestDTO> adList = new ArrayList<>();
        adList.add(new AdRequestDTO(103L, cal3.getTime(), cal4.getTime()));

        bundle.setRequestedAdverts(adList);

        Mockito.when(this.advertCopyRepository.findById(103l)).thenReturn(advert3);

        int sizeBefore = requestBundleRepository.findAll().size();
        try {
            service.createNewRequestBundle(bundle);
        } catch (Exception e) {
            e.printStackTrace();
            assert(false);
        }

        int sizeAfter = requestBundleRepository.findAll().size();

        assert((sizeBefore+1)==sizeAfter);
    }

    @Test
    public void NoAdPass() {
        bundle.setRequestedAdverts(null);

        Exception exception = assertThrows(NullPointerException.class, () -> {
            service.createNewRequestBundle(bundle);
        });

        assert(exception.getMessage() != "");
    }

    @Test
    public void startDateFall() {
        //Requested date is in past
        Calendar cal3 = Calendar.getInstance();
        cal3.set(2020, 3, 15, 15, 0, 0);
        Calendar cal4 = Calendar.getInstance();
        cal4.set(2020, 4, 17, 12, 30, 0);

        List<AdRequestDTO> adList = new ArrayList<>();
        adList.add(new AdRequestDTO(102L, cal3.getTime(), cal4.getTime()));

        bundle.setRequestedAdverts(adList);
        Mockito.when(this.advertCopyRepository.findById(102l)).thenReturn(advert2);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            service.createNewRequestBundle(bundle);
        });

        assert(exception.getMessage().contains("ADVERT DOSE NOT HAVE VALID START DATE"));
    }

    @Test
    public void dateIncorrectFall()  {
        //Requested date is in past
        Calendar cal3 = Calendar.getInstance();
        cal3.set(2020, 5, 15, 15, 0, 0);
        Calendar cal4 = Calendar.getInstance();
        cal4.set(2020, 5, 13, 12, 30, 0);

        List<AdRequestDTO> adList = new ArrayList<>();
        adList.add(new AdRequestDTO(102L, cal3.getTime(), cal4.getTime()));

        bundle.setRequestedAdverts(adList);

        Mockito.when(this.advertCopyRepository.findById(102l)).thenReturn(advert2);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            service.createNewRequestBundle(bundle);
        });

        assert(exception.getMessage().contains("ADVERT DOSE NOT HAVE VALID DATE"));
    }

    @Test
    public void wrongOwnerFall() {
        //Requested advert is from wrong owner
        bundle.setAdvertOwnerEmail("greska@mail");

        Mockito.when(this.advertCopyRepository.findById(101l)).thenReturn(advert1);
        Mockito.when(this.advertCopyRepository.findById(102l)).thenReturn(advert2);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            service.createNewRequestBundle(bundle);
        });

        assert(exception.getMessage().contains("ADVERT DOSE NOT HAVE APPROPRIATED OWNER"));
    }

}
