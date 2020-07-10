package com.team18.WebServiceManager.repository;

import com.team18.WebServiceManager.model.Car;
import com.team18.WebServiceManager.model.CarBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
	Car findByAgentAgentIdAndKeyMS(Long agId, Long keyMS);
	Car findByAgentAgentIdAndKeyAG(Long agId, Long keyAG);
	List<Car> findByAgentAgentIdOrderByKeyMSDesc(Long adId);
}
