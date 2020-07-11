package rent.app.aspect;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import rent.app.controller.ws.client.CarModelClient;
import rent.app.controller.ws.generate.CarModelRequest;
import rent.app.controller.ws.generate.SoapResponse;
import rent.app.model.CarModel;

import javax.persistence.Column;

@Component
@Aspect
@RequiredArgsConstructor
public class CarModelAspect {
    private  final CarModelClient carModelClient;
    //cekamo maju
    @AfterReturning(value = "execution(* com.example.advertmanagerapp.service.impl.CarModelServiceImpl.saveCarModel(..))", returning = "carModel")
    public void afterSavedCarModel(JoinPoint joinPoint, CarModel carModel){
        CarModelRequest request=new CarModelRequest();
        request.setId(carModel.getId());
        request.setDeleted(carModel.isRemoved());
        request.setName(carModel.getModelName());
        request.setToken("firm@com");

        SoapResponse response=carModelClient.handleCarModel(request);
        System.out.println("STATUS: "+ response.getStatus());
    }
}
