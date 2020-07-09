package com.team18.WebServiceManager.repository;

import com.team18.WebServiceManager.model.CarBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CarBrandRepository extends JpaRepository<CarBrand, Long> {

	CarBrand findByAgentAgentIdAndKeyMS(Long agId, Long keyMS);
	CarBrand findByAgentAgentIdAndKeyAG(Long agId, Long keyAG);
	List<CarBrand> findByAgentAgentIdOrderByKeyMSDesc(Long adId);
}
