package rent.app.service;

import rent.app.dto.CarDto;
import rent.app.dto.CarDtoMini;
import rent.app.dto.DTOEntity;
import rent.app.dto.DtoUtils;
import rent.app.model.Car;

import java.util.List;

public interface CarService {
    List<DTOEntity> getCarBrands();
    List<DTOEntity> getCarModels();
    List<DTOEntity> getFuelTypes();
    List<DTOEntity> getCarClasses();
    List<DTOEntity> getTransmissions();
    Car createCar(CarDto car, String ownerEmail);
    List<CarDtoMini> allCars(String ownerEmail);
}
