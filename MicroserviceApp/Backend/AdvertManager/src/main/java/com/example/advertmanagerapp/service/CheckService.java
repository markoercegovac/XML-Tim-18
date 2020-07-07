package com.example.advertmanagerapp.service;

public interface CheckService {

    boolean isForbiddenUser(String email);
    boolean checkUserReservation(String email);
    boolean checkCreationEnable(String email);
}
