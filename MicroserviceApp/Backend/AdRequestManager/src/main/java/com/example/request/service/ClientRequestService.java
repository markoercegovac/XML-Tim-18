package com.example.request.service;

import com.example.request.dto.AdRequestForClientDTO;
import com.example.request.dto.CreateAdBundleRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientRequestService {

    void createNewRequestBundle(CreateAdBundleRequestDTO createBundle) throws RuntimeException, Exception;
    List<AdRequestForClientDTO> findAllBundlesByStatus(String clientEmail, String status);
    void clientPaid(Long bundleId) throws Exception, NullPointerException;
}
