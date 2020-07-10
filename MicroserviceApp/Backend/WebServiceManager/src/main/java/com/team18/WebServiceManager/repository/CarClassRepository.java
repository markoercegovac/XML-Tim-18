package com.team18.WebServiceManager.repository;

import com.team18.WebServiceManager.model.CarBrand;
import com.team18.WebServiceManager.model.CarClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarClassRepository extends JpaRepository<CarClass, Long> {
	CarClass findByAgentAgentIdAndKeyMS(Long agId, Long keyMS);
	CarClass findByAgentAgentIdAndKeyAG(Long agId, Long keyAG);
	List<CarClass> findByAgentAgentIdOrderByKeyMSDesc(Long adId);
}
