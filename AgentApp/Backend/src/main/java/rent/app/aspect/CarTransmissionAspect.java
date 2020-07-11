package rent.app.aspect;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import rent.app.controller.ws.client.CarModelClient;
import rent.app.controller.ws.client.CarTransmissionClient;
import rent.app.controller.ws.generate.CarTransmissionRequest;
import rent.app.controller.ws.generate.SoapResponse;
import rent.app.model.CarTransmissionType;

@Component
@Aspect
@RequiredArgsConstructor
public class CarTransmissionAspect {
    private final CarTransmissionClient carTransmissionClient;

    @AfterReturning(value = "execution(* com.example.advertmanagerapp.service.impl.CarTranssmisionTypeServiceImpl.saveCarTranssmisionType(..))", returning = "transmission")
    public void afterSavedCarTransminssion(JoinPoint joinPoint, CarTransmissionType transmission){
        CarTransmissionRequest request=new CarTransmissionRequest();
        request.setId(transmission.getId());
        request.setName(transmission.getTransmissionType());
        request.setToken("firm@com");

        SoapResponse response=carTransmissionClient.handleCarTransmission(request);
        System.out.println("STATUS: "+ response.getStatus());

    }
}
