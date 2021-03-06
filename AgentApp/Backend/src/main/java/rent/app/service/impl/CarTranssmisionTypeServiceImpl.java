package rent.app.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rent.app.model.CarTransmissionType;
import rent.app.repository.CarTransmissionRepository;
import rent.app.service.CarTranssmisionTypeService;

import java.util.List;

@AllArgsConstructor
@Service
public class CarTranssmisionTypeServiceImpl implements CarTranssmisionTypeService {

    private final CarTransmissionRepository repository;

    @Override
    public void deleteCarTranssmision(Long id) {
        repository.delete(repository.findById(id).get());
    }

    @Override
    public CarTransmissionType saveCarTranssmisionType(CarTransmissionType carTransmissionType) {

        CarTransmissionType ret=repository.save(carTransmissionType);
        return ret;
    }

    @Override
    public List<CarTransmissionType> getAllCarTranssmisionType() {
        return repository.findAll();
    }
}
