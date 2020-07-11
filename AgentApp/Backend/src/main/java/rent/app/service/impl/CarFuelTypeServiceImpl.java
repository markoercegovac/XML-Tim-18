package rent.app.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rent.app.model.CarFuelType;
import rent.app.repository.CarFuelRepository;
import rent.app.service.CarFuelTypeService;

import java.util.List;

@AllArgsConstructor
@Service
public class CarFuelTypeServiceImpl implements CarFuelTypeService {

    private final CarFuelRepository repository;

    @Override
    public void deleteFuelTypeService(Long id) {
        repository.delete(repository.findById(id).get());
    }

    @Override
    public CarFuelType saveFuelType(CarFuelType carFuelType) {

        CarFuelType carFuelType1=repository.save(carFuelType);
        return carFuelType1;
    }

    @Override
    public List<CarFuelType> getAllCarFuelType() {
        return repository.findAll();
    }
}
