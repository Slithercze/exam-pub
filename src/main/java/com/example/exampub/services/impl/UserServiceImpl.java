package com.example.exampub.services.impl;

import com.example.exampub.models.User;
import com.example.exampub.repositories.UserRepository;
import com.example.exampub.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


}
