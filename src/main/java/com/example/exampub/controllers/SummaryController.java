package com.example.exampub.controllers;

import com.example.exampub.DTOs.SummaryUserDTO;
import com.example.exampub.services.SummaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/summary")
public class SummaryController {
    private final SummaryService summaryService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllOrders() {
        return ResponseEntity.ok(summaryService.countAllOrders());
    }

    @GetMapping("/user")
    public ResponseEntity<?> getUserSummary() {
        return ResponseEntity.ok(summaryService.getAllUsers().stream().map(SummaryUserDTO::new));
    }
}
