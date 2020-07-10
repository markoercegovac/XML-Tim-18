package com.team18.WebServiceManager.repository;

import com.team18.WebServiceManager.model.CarBrand;
import com.team18.WebServiceManager.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {
	Picture findByAgentAgentIdAndKeyMS(Long agId, Long keyMS);
	Picture findByAgentAgentIdAndKeyAG(Long agId, Long keyAG);
	List<Picture> findByAgentAgentIdOrderByKeyMSDesc(Long adId);
}
