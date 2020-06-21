package com.comment.manager.manager.service;

import com.comment.manager.manager.model.AdvertCopy;
import org.springframework.stereotype.Service;


public interface AdvertCopyService {

    AdvertCopy getAdvertCopy(Long id);
    void saveAdvertCopy(AdvertCopy advertCopy);
    void saveTest();
}
