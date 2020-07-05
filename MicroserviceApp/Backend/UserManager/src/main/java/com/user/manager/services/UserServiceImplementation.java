package com.user.manager.services;


import com.user.manager.dto.UserDto;
import com.user.manager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserDto> allUsers() {
        return null;
    }
}
