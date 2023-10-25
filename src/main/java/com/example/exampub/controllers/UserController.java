package com.example.exampub.controllers;

import com.example.exampub.DTOs.UserDTO;
import com.example.exampub.exceptions.UserException;
import com.example.exampub.models.User;
import com.example.exampub.services.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;

    @GetMapping
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok(userService.getAllUsers().stream().map(UserDTO::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(new UserDTO(userService.getUserById(id)));
        } catch (UserException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody User user) {
        return ResponseEntity.ok(userService.saveUser(user));
    }

}
