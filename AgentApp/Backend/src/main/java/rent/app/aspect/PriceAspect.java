package rent.app.aspect;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import rent.app.controller.ws.client.PriceClient;
import rent.app.controller.ws.generate.PriceRequest;
import rent.app.controller.ws.generate.SoapResponse;
import rent.app.model.Price;

@Component
@Aspect
@RequiredArgsConstructor
public class PriceAspect {

    private final PriceClient priceClient;

    @AfterReturning(pointcut = "execution(* rent.app.service.impl.PriceServiceImpl.createPrice(..))", returning = "price")
    public void afterSavedPrice(JoinPoint joinPoint, Price price){
        PriceRequest request=new PriceRequest();
        request.setId(price.getId());
        request.setDeleted(false);
        request.setDiscount(price.getDiscount());
        request.setDistanceOverflowPrice(price.getDistanceOverflowPrice());
        request.setInsurancePrice(price.getInsurancePrice());
        request.setPricePerDay(price.getPricePerDay());
        request.setName(price.getName());
        request.setToken("firm@com");
        SoapResponse response=priceClient.handlePrice(request);
        System.out.println("STATUS: "+ response.getStatus());

    }

}
