package com.example.request.dto;

import lombok.Data;

@Data
public class AdRequestForOwnerDTO {

    private Long requestBundleId;
    private String requestingUserEmail;
    private String status;
    private double priceWithDiscount;
}
