package com.team18.WebServiceManager.repository;

import com.team18.WebServiceManager.model.Capture;
import com.team18.WebServiceManager.model.CarBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaptureRepository extends JpaRepository<Capture, Long> {
	Capture findByAgentAgentIdAndKeyMS(Long agId, Long keyMS);
	Capture findByAgentAgentIdAndKeyAG(Long agId, Long keyAG);
	List<Capture> findByAgentAgentIdOrderByKeyMSDesc(Long adId);
}
