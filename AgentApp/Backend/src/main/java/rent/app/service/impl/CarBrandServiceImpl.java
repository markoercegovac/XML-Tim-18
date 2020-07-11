package rent.app.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rent.app.model.CarBrand;
import rent.app.repository.CarBrandRepository;
import rent.app.service.CarBrandService;

import java.util.List;

@AllArgsConstructor
@Service
public class CarBrandServiceImpl implements CarBrandService {

    private final CarBrandRepository repository;

    @Override
    public void updateCarBrand(CarBrand carBrand) {

        repository.findById(carBrand.getId()).get().setName(carBrand.getName());
    }

    @Override
    public void deleteCarBrand(Long id) {

        repository.delete(repository.findById(id).get());
    }

    @Override
    public CarBrand saveCarBrand(CarBrand carBrand) {
        CarBrand carBrand1 =repository.save(carBrand);
        return carBrand1;
    }

    @Override
    public List<CarBrand> getAllCarBrand() {
        return repository.findAll();
    }

}
