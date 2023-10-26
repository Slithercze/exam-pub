package com.example.exampub.services.impl;

import com.example.exampub.exceptions.PurchaseException;
import com.example.exampub.exceptions.UserException;
import com.example.exampub.models.Buy;
import com.example.exampub.models.Drink;
import com.example.exampub.models.User;
import com.example.exampub.repositories.DrinkRepository;
import com.example.exampub.repositories.UserRepository;
import com.example.exampub.services.BuyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BuyServiceImpl implements BuyService {
    private final UserRepository userRepository;
    private final DrinkRepository drinkRepository;

    public String buyDrink(Buy buy) throws PurchaseException, UserException {
        Optional<User> user = userRepository.findById(buy.getUserId());
        Optional<Drink> drink = drinkRepository.findById(buy.getProductId());

        if (user.isEmpty()) {
            throw new UserException("User with id " + buy.getUserId() + " does not exist");
        } else if (drink.isEmpty()) {
            throw new PurchaseException("Drink with id " + buy.getProductId() + " does not exist");
        } else if (!user.get().isAdult() && drink.get().isForAdult()){
            throw new PurchaseException("User with id " + buy.getUserId() + " is not adult");
        } else if (user.get().getPocket() < drink.get().getPrice()) {
            throw new PurchaseException("User with id " + buy.getUserId() + " does not have enough money");
        } else {
            user.get().setPocket(user.get().getPocket() - drink.get().getPrice());
            userRepository.save(user.get());
            return "User with id " + buy.getUserId() + " bought drink with id " + buy.getProductId();
        }
    }
}
