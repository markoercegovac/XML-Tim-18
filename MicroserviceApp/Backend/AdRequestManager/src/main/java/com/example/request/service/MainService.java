package com.example.request.service;

import org.springframework.stereotype.Service;

@Service
public interface MainService {
	
	boolean cancelBundle(Long bundleId);
}