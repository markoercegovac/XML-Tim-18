package rent.app.service;

import rent.app.dto.CarDto;
import rent.app.dto.CarDtoMini;
import rent.app.dto.DTOEntity;
import rent.app.dto.DtoUtils;

import java.util.List;

public interface CarService {
    List<DTOEntity> getCarBrands();
    List<DTOEntity> getCarModels();
    List<DTOEntity> getFuelTypes();
    List<DTOEntity> getCarClasses();
    List<DTOEntity> getTransmissions();
    void createCar(CarDto car);
    List<CarDtoMini> allCars();
}
