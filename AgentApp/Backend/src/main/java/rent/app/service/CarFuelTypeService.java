package rent.app.service;

import rent.app.model.CarFuelType;

import java.util.List;

public interface CarFuelTypeService {

    public void deleteFuelTypeService(Long id);
    public void saveFuelType(CarFuelType carFuelType);
    public List<CarFuelType> getAllCarFuelType();
}
