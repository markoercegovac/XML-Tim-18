package com.example.advertmanagerapp.repository;

import com.example.advertmanagerapp.model.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarModelRepository extends JpaRepository<CarModel,Long> {
}
