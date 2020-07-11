package rent.app.aspect;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import rent.app.controller.ws.client.CarClient;
import rent.app.controller.ws.generate.CarRequest;
import rent.app.controller.ws.generate.SoapResponse;
import rent.app.dto.CarDto;
import rent.app.model.Advert;
import rent.app.model.Car;

@Component
@Aspect
@RequiredArgsConstructor
public class CarAspect {
    private final CarClient carClient;

    @AfterReturning(value = "execution(* com.example.advertmanagerapp.service.impl.CarServiceImpl.createCar(..))", returning = "car")
    public void  afterSavedCar(JoinPoint joinPoint, Car car){
        CarRequest request=new CarRequest();
        request.setId(car.getId());
        request.setCarBrandId(car.getCarBrand().getId());
        request.setCarClassId(car.getCarClass().getId());
        request.setCarFuelTypeId(car.getCarFuelType().getId());
        request.setCarModelId(car.getCarModel().getId());
        request.setCarTransmissionId(car.getCarTransmissionType().getId());
        request.setChildrenSitNumber(car.getChildrenSitNumber());
        request.setTraveledDistance(car.getTravelDistanceConstraint());
        request.setDeleted(false);
        request.setInsurance(true);
        request.setToken("firm@com");

        SoapResponse response = carClient.handleCar(request);
        System.out.println("STATUS: "+ response.getStatus());
    }


}
