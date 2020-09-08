package com.team18.WebServiceManager.repository;

import com.team18.WebServiceManager.model.CarTransmission;
import com.team18.WebServiceManager.model.DriveReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriveReportRepository extends JpaRepository<DriveReport, Long> {

	DriveReport findByAgentAgentIdAndKeyMS(Long agId, Long keyMS);
	DriveReport findByAgentAgentIdAndKeyAG(Long agId, Long keyAG);
	List<DriveReport> findByAgentAgentIdOrderByKeyMSDesc(Long adId);

}
