package com.example.request.dto;

import java.util.Set;

import lombok.Data;

@Data
public class AdRequestForOwnerDTO {

    private Long requestBundleId;
    private Set<Long> adIds;
    private String requestingUserEmail;
    private String status;
    private double priceWithDiscount;
}
