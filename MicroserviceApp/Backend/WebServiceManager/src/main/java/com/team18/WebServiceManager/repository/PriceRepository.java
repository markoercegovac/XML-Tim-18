package com.team18.WebServiceManager.repository;

import com.team18.WebServiceManager.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
	Price findByAgentAgentIdAndKeyMS(Long agId, Long keyMS);
	Price findByAgentAgentIdAndKeyAG(Long agId, Long keyAG);
}
