package rent.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rent.app.model.CarBrand;
import rent.app.repository.CarBrandRepository;
import rent.app.service.CarBrandService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CarBrandServiceImpl implements CarBrandService {

    @Autowired
    private CarBrandRepository repository;

    @Override
    public List<CarBrand> getAllCarBrands() {
        return repository.findAll();
    }
}
