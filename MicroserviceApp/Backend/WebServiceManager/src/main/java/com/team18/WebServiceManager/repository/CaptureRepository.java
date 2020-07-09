package com.team18.WebServiceManager.repository;

import com.team18.WebServiceManager.model.Capture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaptureRepository extends JpaRepository<Capture, Long> {
	Capture findByAgentAgentIdAndKeyMS(Long agId, Long keyMS);
	Capture findByAgentAgentIdAndKeyAG(Long agId, Long keyAG);
}
