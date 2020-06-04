package com.example.advertmanagerapp.repository;

import com.example.advertmanagerapp.model.CarTransmissionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarTransmissionTypeRepository extends JpaRepository<CarTransmissionType, Long> {

}
