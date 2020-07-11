package rent.app.controller.ws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import rent.app.controller.ws.WsNameSpace;
import rent.app.controller.ws.generate.CarRequest;
import rent.app.controller.ws.generate.SoapResponse;
import rent.app.model.*;
import rent.app.repository.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Endpoint
public class CarWSService {
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarBrandRepository carBrandRepository;

    @Autowired
    private CarClassRepository carClassRepository;

    @Autowired
    private CarModelRepository carModelRepository;

    @Autowired
    private CarTransmissionRepository carTransmissionRepository;

    @Autowired
    private CarFuelRepository carFuelRepository;

    @Autowired
    private DriveReportRepository reportRepository;


    @PayloadRoot(namespace = WsNameSpace.namespace,localPart = "carRequest")
    @ResponsePayload
    public SoapResponse handleCar(@RequestPayload CarRequest request){
        Car car=new Car();
        car.setId(request.getId()==0?null:request.getId());
        CarBrand carBrand=carBrandRepository.getOne(request.getCarBrandId());
        CarClass carClass=carClassRepository.findById(request.getCarBrandId()).get();
        CarModel carModel=carModelRepository.findById(request.getCarModelId()).get();
        CarTransmissionType carTransmissionType=carTransmissionRepository.findById(request.getCarTransmissionId()).get();
        CarFuelType carFuelType=carFuelRepository.findById(request.getCarFuelTypeId()).get();
        Set<DriveReport> driveReports=new HashSet<>();
        car.setId(request.getId()==0?null:request.getId());
        car.setChildrenSitNumber(request.getChildrenSitNumber());
        car.setTravelDistanceConstraint(request.getTraveledDistanceConstraint());
        car.setReports(driveReports);
        car.setCarBrand(carBrand);
        car.setCarClass(carClass);
        car.setCarFuelType(carFuelType);
        car.setCarTransmissionType(carTransmissionType);
        car.setCarModel(carModel);
        System.out.println("WS RECEIVED CAR  "+request);
        Car saved=carRepository.save(car);
        request.setToken("firm@com");
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
