package com.team18.WebServiceManager.repository;

import com.team18.WebServiceManager.model.CarBrand;
import com.team18.WebServiceManager.model.CarFuelType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarFuelTypeRepository extends JpaRepository<CarFuelType, Long> {
	CarFuelType findByAgentAgentIdAndKeyMS(Long agId, Long keyMS);
	CarFuelType findByAgentAgentIdAndKeyAG(Long agId, Long keyAG);
}
