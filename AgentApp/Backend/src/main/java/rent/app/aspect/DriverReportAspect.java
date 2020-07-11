package rent.app.aspect;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import rent.app.controller.ws.client.DriverReportClient;
import rent.app.controller.ws.generate.DriveReportRequest;
import rent.app.controller.ws.generate.SoapResponse;
import rent.app.model.Car;
import rent.app.model.DriveReport;
import rent.app.repository.CarRepository;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.util.List;

@Component
@Aspect
@RequiredArgsConstructor
public class DriverReportAspect {

    private final DriverReportClient driverReportClient;
    private final CarRepository carRepository;

    @AfterReturning(pointcut = "execution(* rent.app.service.impl.DriveReportImpl.addNewReport(..))", returning = "driveReport")
    public void afterSavedDriveReport(JoinPoint joinPoint, DriveReport driveReport) throws DatatypeConfigurationException {
        DriveReportRequest request=new DriveReportRequest();
        request.setId(driveReport.getId());
        request.setToken("firm@com");
        String dateTimeString = driveReport.getDateOfReport().toString();
        request.setDateOfReport(DatatypeFactory.newInstance().newXMLGregorianCalendar(dateTimeString));
        request.setDescription(driveReport.getDescribe());
        request.setTraveledDistance(driveReport.getTraveledDistance());
        request.setCarId(carRepository.findByReportsId(driveReport.getId()).getId());
        SoapResponse response= driverReportClient.handleDriverReport(request);
        System.out.println("STATUS: "+ response.getStatus());

    }
}
