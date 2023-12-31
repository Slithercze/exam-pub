package com.example.exampub.services;

import com.example.exampub.exceptions.UserException;
import com.example.exampub.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(String id) throws UserException;
    User saveUser(User user);
}
