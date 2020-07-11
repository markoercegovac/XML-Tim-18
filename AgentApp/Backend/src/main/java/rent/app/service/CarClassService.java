package rent.app.service;

import rent.app.model.CarClass;

import java.util.List;

public interface CarClassService {


    public void deleteCarClass(Long id);
    public CarClass saveCarClass(CarClass carClass);
    public List<CarClass> getAllCarClass();
}
