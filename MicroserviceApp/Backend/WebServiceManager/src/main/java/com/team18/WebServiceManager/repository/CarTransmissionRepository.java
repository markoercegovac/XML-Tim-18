package com.team18.WebServiceManager.repository;

import com.team18.WebServiceManager.model.CarBrand;
import com.team18.WebServiceManager.model.CarTransmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarTransmissionRepository extends JpaRepository<CarTransmission, Long> {
	CarTransmission findByAgentAgentIdAndKeyMS(Long agId, Long keyMS);
	CarTransmission findByAgentAgentIdAndKeyAG(Long agId, Long keyAG);
}
