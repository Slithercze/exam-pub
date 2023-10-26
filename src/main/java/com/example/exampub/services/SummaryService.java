package com.example.exampub.services;

import com.example.exampub.DTOs.SummaryDTO;
import com.example.exampub.models.User;

import java.util.List;

public interface SummaryService {
    List<SummaryDTO> countAllOrders();
    List<User> getAllUsers();
}
