package rent.app.aspect;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import rent.app.controller.ws.client.CarBrandClient;
import rent.app.controller.ws.generate.CarBrandRequest;
import rent.app.controller.ws.generate.SoapResponse;
import rent.app.model.CarBrand;

@Component
@Aspect
@RequiredArgsConstructor
public class CarBrandAspect {

	private final CarBrandClient carBrandClient;

	@AfterReturning(pointcut = "execution(* rent.app.service.impl.CarBrandServiceImpl.saveCarBrand(..))", returning = "carBrand")
	public void afterSavedCarBrand(JoinPoint joinPoint, CarBrand carBrand) {
		CarBrandRequest request = new CarBrandRequest();
		request.setId(carBrand.getId());
		request.setName(carBrand.getName());
		request.setDeleted(carBrand.isRemoved());
		request.setToken("firm@com");

		SoapResponse response = carBrandClient.handleCarBrand(request);
		System.out.println("STATUS: "+ response.getStatus());
	}
}
