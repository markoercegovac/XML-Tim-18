package rent.app.aspect;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import rent.app.controller.ws.client.CarFuelTypeClient;
import rent.app.controller.ws.generate.CarFuelTypeRequest;
import rent.app.controller.ws.generate.SoapResponse;
import rent.app.model.CarFuelType;

@Component
@Aspect
@RequiredArgsConstructor
public class CarFuelTypeAspect {
    private final CarFuelTypeClient carFuelTypeClient;

   // @AfterReturning(value = "execution(* com.example.advertmanagerapp.service.impl.CarServiceImpl.createCar(..))", returning = "car")
    public void afterSavedCarFuel(JoinPoint joinPoint, CarFuelType carFuelType){
        CarFuelTypeRequest request=new CarFuelTypeRequest();
        request.setDeleted(request.isDeleted());
        request.setId(request.getId());
        request.setName(request.getName());
        request.setToken("firm@com");

        SoapResponse response=carFuelTypeClient.handleCarFuelType(request);
        System.out.println("STATUS: "+ response.getStatus());

    }
}
