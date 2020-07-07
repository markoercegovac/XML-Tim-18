package com.example.advertmanagerapp.controller.rest;

import com.example.advertmanagerapp.dto.ForbidReservationDto;
import com.example.advertmanagerapp.service.ClientCopyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/advert-manager/forbid")
@RestController
public class ForbidController {

    private final ClientCopyService clientCopyService;

    @PostMapping
    public void forbidReservation(@RequestBody ForbidReservationDto forbidReservationDto){
        clientCopyService.forbidReservation(forbidReservationDto);
    }
    @PostMapping("/creation")
    public void forbidCreation(@RequestBody ForbidReservationDto forbidReservationDto){
        clientCopyService.forbidCreation(forbidReservationDto);
    }
}
