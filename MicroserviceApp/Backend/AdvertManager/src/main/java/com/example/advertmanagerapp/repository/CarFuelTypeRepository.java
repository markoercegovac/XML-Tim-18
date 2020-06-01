package com.example.advertmanagerapp.repository;

import com.example.advertmanagerapp.model.CarFuelType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarFuelTypeRepository extends JpaRepository<CarFuelType, Long> {
}
