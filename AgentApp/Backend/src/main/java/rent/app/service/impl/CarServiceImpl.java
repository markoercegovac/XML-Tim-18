package rent.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rent.app.model.*;
import rent.app.repository.*;
import rent.app.service.CarService;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarModelRepository carModelRepository;
    private final CarBrandRepository carBrandRepository;
    private final CarTransmissionRepository carTransmissionRepository;
    private final CarClassRepository carClassRepository;
    private final CarFuelRepository carFuelRepository;

    @Override
    public List<CarBrand> getCarBrands() {
        return carBrandRepository.findAll();
    }

    @Override
    public List<CarModel> getCarModels() {
        return carModelRepository.findAll();
    }

    @Override
    public List<CarFuelType> getFuelTypes() {
        return carFuelRepository.findAll();
    }

    @Override
    public List<CarClass> getCarClasses() {
        return carClassRepository.findAll();
    }

    @Override
    public List<CarTransmissionType> getTransmissions() {
        return carTransmissionRepository.findAll();
    }
}
