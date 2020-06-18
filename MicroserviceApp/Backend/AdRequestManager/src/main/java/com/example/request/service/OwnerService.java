package com.example.request.service;

import java.util.List;

import com.example.request.dto.AdRequestForOwnerDTO;
import com.example.request.model.AdvertStateEnum;

import org.springframework.stereotype.Service;

@Service
public interface OwnerService {
	
	List<AdRequestForOwnerDTO> findOwnersAdByState(String email, AdvertStateEnum state) throws Exception;
	void approvBundle(Long bundleId) throws Exception;
}