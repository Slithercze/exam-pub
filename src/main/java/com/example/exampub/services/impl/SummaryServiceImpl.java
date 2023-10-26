package com.example.exampub.services.impl;

import com.example.exampub.DTOs.SummaryDTO;
import com.example.exampub.models.Order;
import com.example.exampub.models.User;
import com.example.exampub.repositories.OrderRepository;
import com.example.exampub.repositories.UserRepository;
import com.example.exampub.services.SummaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SummaryServiceImpl implements SummaryService {
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    @Override
    public List<SummaryDTO> countAllOrders() {
        List<Order> orders = orderRepository.findAll();
        Map<String, List<Order>> productGroups = orders.stream()
                .collect(Collectors.groupingBy(Order::getProductName));

        return productGroups.entrySet().stream()
                .map(entry -> {
                    String productName = entry.getKey();
                    List<Order> productOrders = entry.getValue();
                    int totalAmount = productOrders.stream().mapToInt(Order::getAmount).sum();
                    double unitPrice = productOrders.get(0).getPrice();
                    double summaryPrice = unitPrice * totalAmount;

                    SummaryDTO summaryDTO = new SummaryDTO();
                    summaryDTO.setProduct(productName);
                    summaryDTO.setAmount(totalAmount);
                    summaryDTO.setUnitPrice(unitPrice);
                    summaryDTO.setSummaryPrice(summaryPrice);

                    return summaryDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
