package rent.app.controller.ws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import rent.app.controller.ws.WsNameSpace;
import rent.app.controller.ws.generate.DriveReportRequest;
import rent.app.controller.ws.generate.SoapResponse;
import rent.app.model.DriveReport;
import rent.app.repository.DriveReportRepository;

@Endpoint
public class DriverReportWSService {

    @Autowired
    private DriveReportRepository driveReportRepository;

    @PayloadRoot(namespace = WsNameSpace.namespace, localPart = "driveReportRequest")
    @ResponsePayload
    public SoapResponse handleDriverReport(@RequestPayload DriveReportRequest request){
        DriveReport driveReport=new DriveReport();
        driveReport.setId(request.getId()==0?null:request.getId());
        driveReport.setDescribe(request.getDescription());
        driveReport.setDateOfReport(request.getDateOfReport().toGregorianCalendar().getTime());
        driveReport.setTraveledDistance(request.getTraveledDistance());
        System.out.println("WS RECEIVED DRIVE REPORT "+request);
        DriveReport saved=driveReportRepository.save(driveReport);
        SoapResponse response = new SoapResponse();
        if(request.getId()==0) {
            response.setAgId(saved.getId());
            response.setStatus("CREATED");
        } else {
            response.setAgId(saved.getId());
            response.setStatus("UPDATED");
        }

        return response;
    }

}
