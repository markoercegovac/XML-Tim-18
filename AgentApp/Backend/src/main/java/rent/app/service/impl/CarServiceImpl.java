package rent.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rent.app.model.CarBrand;
import rent.app.repository.CarBrandRepository;
import rent.app.service.CarService;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarBrandRepository carBrandRepository;
    @Override
    public List<CarBrand> getCarBrands() {
        return carBrandRepository.findAll();
    }
}
