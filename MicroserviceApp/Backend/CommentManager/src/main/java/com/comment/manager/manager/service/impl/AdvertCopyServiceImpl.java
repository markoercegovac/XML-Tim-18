package com.comment.manager.manager.service.impl;

import com.comment.manager.manager.model.AdvertCopy;
import com.comment.manager.manager.repository.AdvertCopyRepository;
import com.comment.manager.manager.service.AdvertCopyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AdvertCopyServiceImpl implements AdvertCopyService {

    private final AdvertCopyRepository advertCopyRepository;

    @Override
    public AdvertCopy getAdvertCopy(Long id) {

        return advertCopyRepository.findById(id).get();
    }
}
