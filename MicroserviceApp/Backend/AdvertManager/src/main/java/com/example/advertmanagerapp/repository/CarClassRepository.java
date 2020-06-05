package com.example.advertmanagerapp.repository;

import com.example.advertmanagerapp.model.CarClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarClassRepository extends JpaRepository<CarClass, Long> {

}
