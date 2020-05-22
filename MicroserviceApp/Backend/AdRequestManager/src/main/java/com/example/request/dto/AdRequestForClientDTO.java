package com.example.request.dto;

import lombok.Data;

@Data
public class AdRequestForClientDTO {

    private Long requestBundleId;
    private String advertOwnerEmail;
    private String status;
    private double priceWithDiscount;

}
