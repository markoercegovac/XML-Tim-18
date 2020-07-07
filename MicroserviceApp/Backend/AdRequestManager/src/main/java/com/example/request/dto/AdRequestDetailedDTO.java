package com.example.request.dto;

import lombok.Data;

import java.util.Set;

@Data
public class AdRequestDetailedDTO {

    private Long requestBundleId;
    private String advertOwnerEmail;
    private String status;
    private double priceWithDiscount;
    private Set<AdRequestDTO> advertRequests;

}
