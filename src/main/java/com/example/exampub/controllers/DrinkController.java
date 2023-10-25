package com.example.exampub.controllers;

import com.example.exampub.services.DrinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DrinkController {
    private final DrinkService drinkService;

    @GetMapping("/drink-menu")
    public ResponseEntity<?> getDrinksMenu() {
        return ResponseEntity.ok(drinkService.getAllDrinks());
    }
}
