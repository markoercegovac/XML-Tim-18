package rent.app.service;

import rent.app.model.*;

import java.util.List;
import java.util.Set;

public interface CarService {
    List<CarBrand> getCarBrands();
    List<CarModel> getCarModels();
    List<CarFuelType> getFuelTypes();
    List<CarClass> getCarClasses();
    List<CarTransmissionType> getTransmissions();
}
