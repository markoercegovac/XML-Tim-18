package com.example.request.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdRequestForOwnerDTO {

    private Long requestBundleId;
    private Set<AdRequestDTO> requests;
    private String requestingUserEmail;
    private String status;
    private double priceWithDiscount;
}
