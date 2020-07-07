package com.example.advertmanagerapp.service;


import com.example.advertmanagerapp.dto.ClientCopyDto;
import com.example.advertmanagerapp.dto.ForbidReservationDto;
import com.example.advertmanagerapp.model.ClientCopy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientCopyService {


     List<ClientCopy> getAllUsers();

     void delete(ClientCopy clientCopy);

     void forbidReservation(ForbidReservationDto dto);

     void forbidCreation(ForbidReservationDto dto);
}
