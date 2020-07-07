package com.example.advertmanagerapp.service.impl;

import com.example.advertmanagerapp.dto.ForbidReservationDto;
import com.example.advertmanagerapp.model.ClientCopy;
import com.example.advertmanagerapp.repository.ClientCopyRepository;
import com.example.advertmanagerapp.service.ClientCopyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClientCopyServiceImpl implements ClientCopyService {

    private final ClientCopyRepository repository;

    @Override
    public List<ClientCopy> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public void delete(ClientCopy clientCopy) {
        clientCopy.setRemoved(false);
        repository.save(clientCopy);
    }

    @Override
    public void forbidReservation(ForbidReservationDto dto) {
        ClientCopy clientCopy=repository.findByEmail(dto.getEmail());
        clientCopy.setForbiddenAdvert(true);
        repository.save(clientCopy);
    }

    @Override
    public void forbidCreation(ForbidReservationDto dto) {
        ClientCopy clientCopy=repository.findByEmail(dto.getEmail());
        clientCopy.setCreationEnabled(false);
        repository.save(clientCopy);
    }


}
