package com.example.advertmanagerapp.service.impl;

import com.example.advertmanagerapp.dto.CarModelDto;
import com.example.advertmanagerapp.dto.mapper.DtoEntity;
import com.example.advertmanagerapp.dto.mapper.DtoUtils;
import com.example.advertmanagerapp.model.CarBrand;
import com.example.advertmanagerapp.model.CarModel;
import com.example.advertmanagerapp.repository.CarBrandRepository;
import com.example.advertmanagerapp.repository.CarModelRepository;
import com.example.advertmanagerapp.service.CarModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CarModelServiceImpl implements CarModelService {

    @Autowired
    public CarModelRepository repository;
    private final CarBrandRepository carBrandRepository;
    private final DtoUtils dtoUtils;
    @Override
    public List<DtoEntity> getModelForBrand(Long idBrand) {
        CarBrand carBrand = carBrandRepository.findById(idBrand).get();
        return carBrand.getCarModelSet().stream().map(m->dtoUtils.convertToDto(m,new CarModelDto())).collect(Collectors.toList());
    }
    @Override
    public void deleteCarModel(Long id) {
        repository.delete(repository.findById(id).get());
    }

    @Override
    public CarModel saveCarModel(CarModel carModel) {
        return repository.save(carModel);
    }

    @Override
    public List<CarModel> getAllCarModel() {
        return repository.findAll();
    }
}
