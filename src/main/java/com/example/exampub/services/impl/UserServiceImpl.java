package com.example.exampub.services.impl;

import com.example.exampub.repositories.UserRepository;
import com.example.exampub.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;



}
