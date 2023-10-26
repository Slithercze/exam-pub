package com.example.exampub.services;

import com.example.exampub.exceptions.PurchaseException;
import com.example.exampub.exceptions.UserException;
import com.example.exampub.models.Buy;

public interface BuyService {
    String buyDrink(Buy buy) throws PurchaseException, UserException;
}
