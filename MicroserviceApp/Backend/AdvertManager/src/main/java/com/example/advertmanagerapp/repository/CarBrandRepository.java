package com.example.advertmanagerapp.repository;

import com.example.advertmanagerapp.model.CarBrand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarBrandRepository extends JpaRepository<CarBrand,Long> {
}
