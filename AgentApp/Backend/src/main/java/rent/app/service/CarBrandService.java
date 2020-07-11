package rent.app.service;

import rent.app.model.CarBrand;

import java.util.List;

public interface CarBrandService {

    public void updateCarBrand(CarBrand carBrand);
    public void deleteCarBrand(Long id);
    public CarBrand saveCarBrand(CarBrand carBrand);
    public List<CarBrand> getAllCarBrand();

}
