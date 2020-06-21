package com.example.advertmanagerapp.aspect;

import com.example.advertmanagerapp.client.SoapClientCarBrand;
import com.example.advertmanagerapp.generate.CreateCarBrandResponse;
import com.example.advertmanagerapp.model.CarBrand;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
@RequiredArgsConstructor
public class CreateBrandSoapAspect {

    @Autowired
    private SoapClientCarBrand soap;

    @After(value = "execution(* com.example.advertmanagerapp.service.impl.CarBrandServiceImpl.saveCarBrand(..)) and args(carBrand)")
    public void afterSavedCarBrand(JoinPoint joinPoint, CarBrand carBrand) {

        CreateCarBrandResponse response = soap.createCarBrand(carBrand);
        System.out.println("STATUS: "+ response.getStatus());

    }

}
