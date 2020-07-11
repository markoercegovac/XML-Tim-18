package rent.app.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rent.app.model.CarModel;
import rent.app.repository.CarModelRepository;
import rent.app.service.CarModelService;

import java.util.List;

@AllArgsConstructor
@Service
public class CarModelServiceImpl implements CarModelService {

    private final CarModelRepository repository;

    @Override
    public void deleteCarModel(Long id) {
        repository.delete(repository.findById(id).get());
    }

    @Override
    public void saveCarModel(CarModel carModel) {
        repository.save(carModel);
    }

    @Override
    public List<CarModel> getAllCarModel() {
        return repository.findAll();
    }

}
