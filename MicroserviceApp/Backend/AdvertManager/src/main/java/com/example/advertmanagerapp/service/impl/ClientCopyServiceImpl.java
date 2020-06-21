package com.example.advertmanagerapp.service.impl;

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


}
