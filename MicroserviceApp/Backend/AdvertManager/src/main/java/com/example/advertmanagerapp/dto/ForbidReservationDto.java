package com.example.advertmanagerapp.dto;

import lombok.Data;

@Data
public class ForbidReservationDto {
    private String email;
    private boolean isForbidden;
}
