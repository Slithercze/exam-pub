package com.example.exampub.controllers;

import com.example.exampub.DTOs.UserDTO;
import com.example.exampub.exceptions.UserException;
import com.example.exampub.models.User;
import com.example.exampub.services.UserService;
import com.example.exampub.services.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok(userService.getAllUsers().stream().map(UserDTO::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable String id) {
        try {
            return ResponseEntity.ok(userService.getUserById(id));
        } catch (UserException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody User user) {
        return ResponseEntity.ok(userService.saveUser(user));
    }

}
