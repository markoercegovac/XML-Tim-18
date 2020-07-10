package com.team18.WebServiceManager.repository;

import com.team18.WebServiceManager.model.CarBrand;
import com.team18.WebServiceManager.model.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarModelRepository extends JpaRepository<CarModel, Long> {
	CarModel findByAgentAgentIdAndKeyMS(Long agId, Long keyMS);
	CarModel findByAgentAgentIdAndKeyAG(Long agId, Long keyAG);
	List<CarModel> findByAgentAgentIdOrderByKeyMSDesc(Long adId);
}
