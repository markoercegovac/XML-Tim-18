package rent.app.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rent.app.model.Car;
import rent.app.model.CarClass;
import rent.app.repository.CarClassRepository;
import rent.app.service.CarClassService;

import java.util.List;

@AllArgsConstructor
@Service
public class CarClassServiceImpl implements CarClassService {

    private final CarClassRepository repository;

    @Override
    public void deleteCarClass(Long id) {
        repository.delete(repository.findById(id).get());
    }

    @Override
    public CarClass saveCarClass(CarClass carClass) {
        CarClass carClass1 =repository.save(carClass);
        return carClass1;
    }

    @Override
    public List<CarClass> getAllCarClass() {
        return repository.findAll();
    }
}
