package rent.app.service;

import rent.app.model.CarModel;

import java.util.List;

public interface CarModelService {

    public void deleteCarModel(Long id);
    public void saveCarModel(CarModel carModel);
    public List<CarModel> getAllCarModel();
}
