package com.team18.WebServiceManager.repository;

import com.team18.WebServiceManager.model.Advert;
import com.team18.WebServiceManager.model.CarBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertRepository extends JpaRepository<Advert, Long> {

	Advert findByAgentAgentIdAndKeyMS(Long agId, Long keyMS);
	Advert findByAgentAgentIdAndKeyAG(Long agId, Long keyAG);
}
