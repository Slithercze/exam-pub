package com.example.exampub.services.impl;

import com.example.exampub.models.Drink;
import com.example.exampub.repositories.DrinkRepository;
import com.example.exampub.services.DrinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DrinkServiceImpl implements DrinkService {
    private final DrinkRepository drinkRepository;

    public Iterable<Drink> getAllDrinks() {
        return drinkRepository.findAll();
    }
}
