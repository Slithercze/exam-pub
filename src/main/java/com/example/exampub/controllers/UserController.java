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
    public ResponseEntity<?> getUserById(@PathVariable String id) {
        try {
            Long userId = Long.parseLong(id);
            return ResponseEntity.ok(userService.getUserById(userId));
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("Invalid ID format please provide a number");
        } catch (UserException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody User user) {
        return ResponseEntity.ok(userService.saveUser(user));
    }

}
