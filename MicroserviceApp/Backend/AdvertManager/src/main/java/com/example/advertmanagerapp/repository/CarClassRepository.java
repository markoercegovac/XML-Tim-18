package com.example.advertmanagerapp.repository;

import com.example.advertmanagerapp.model.CarClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarClassRepository extends JpaRepository<CarClass,Long> {
}
