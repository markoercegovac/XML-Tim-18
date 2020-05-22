package com.example.request.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreateAdBundleRequestDTO {

    private String advertOwnerEmail;
    private String requestingUserEmail;
    private double priceWithDiscount;
    List<AdRequestDTO> requestedAdverts;

}
