package rent.app.aspect;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import rent.app.controller.ws.client.CarClassClient;
import rent.app.controller.ws.generate.CarClassRequest;
import rent.app.controller.ws.generate.SoapResponse;
import rent.app.model.CarClass;

@Component
@Aspect
@RequiredArgsConstructor
public class CarClassAspect {
    private final CarClassClient classClient;

    @AfterReturning(value = "execution(* com.example.advertmanagerapp.service.impl.CarClassServiceImpl.saveCarClass(..))", returning = "carClass")
    public void afterSavedCarClass(JoinPoint joinPoint,CarClass carClass){
        CarClassRequest request=new CarClassRequest();
        request.setId(carClass.getId());
        request.setDeleted(carClass.isRemoved());
        request.setName(carClass.getClassName());
        request.setToken("firm@com");
        SoapResponse response= classClient.handleCarClass(request);
        System.out.println("STATUS: "+ response.getStatus());
    }
}
