package com.example.exampub.controllers;

import com.example.exampub.exceptions.PurchaseException;
import com.example.exampub.exceptions.UserException;
import com.example.exampub.models.Buy;
import com.example.exampub.services.BuyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BuyController {
    private final BuyService buyService;

    @PostMapping("/buy")
    public ResponseEntity<?> buy(@RequestBody Buy buy) {
        try {
            return ResponseEntity.ok(buyService.buyDrink(buy));
        } catch (PurchaseException | UserException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
