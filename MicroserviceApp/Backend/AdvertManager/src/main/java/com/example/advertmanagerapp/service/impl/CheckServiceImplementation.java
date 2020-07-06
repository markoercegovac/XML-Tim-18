package com.example.advertmanagerapp.service.impl;

import com.example.advertmanagerapp.model.ClientCopy;
import com.example.advertmanagerapp.repository.ClientCopyRepository;
import com.example.advertmanagerapp.service.CheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckServiceImplementation implements CheckService {

    private final ClientCopyRepository clientCopyRepository;

    @Override
    public boolean isForbiddenUser(String email) {
        ClientCopy clientCopy=clientCopyRepository.findByEmail(email);
        return (clientCopy.getAdverts().size()==3)?true:false;
    }
}
