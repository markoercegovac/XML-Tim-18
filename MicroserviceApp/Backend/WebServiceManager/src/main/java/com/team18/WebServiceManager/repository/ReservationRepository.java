package com.team18.WebServiceManager.repository;

import com.team18.WebServiceManager.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	Reservation findByAgentAgentIdAndKeyMS(Long agId, Long keyMS);
	Reservation findByAgentAgentIdAndKeyAG(Long agId, Long keyAG);
	List<Reservation> findByAgentAgentIdOrderByKeyMSDesc(Long adId);
}
