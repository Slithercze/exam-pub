package com.example.exampub.DTOs;

import com.example.exampub.models.Order;
import com.example.exampub.models.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class SummaryUserDTO {
    private Long userId;
    private List<Order> product;
    private double price;

    public SummaryUserDTO(User user) {
        this.userId = user.getId();
        this.product = user.getOrders();
        priceSummary(user);
    }

    private void priceSummary(User user){
        for(Order order : user.getOrders()){
            price+=order.getPrice();
        }
    }
}
