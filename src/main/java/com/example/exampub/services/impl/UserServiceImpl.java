package com.example.exampub.services.impl;

import com.example.exampub.exceptions.UserException;
import com.example.exampub.models.User;
import com.example.exampub.repositories.UserRepository;
import com.example.exampub.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String id) throws UserException {
        try {
            Long userId = Long.valueOf(id);
            Optional<User> user = userRepository.findById(userId);

            if (user.isEmpty()) {
                throw new UserException("User with id " + userId + " does not exist");
            } else {
                return user.get();
            }
        } catch (NumberFormatException e) {
            throw new UserException("Invalid id format put a number please");
        }
    }


    public User saveUser(User user) {
        return userRepository.save(user);
    }


}
