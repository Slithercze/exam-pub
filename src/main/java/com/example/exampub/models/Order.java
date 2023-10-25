package com.example.exampub.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "orders")
@Entity
@Data
@NoArgsConstructor
public class Order {
    @Id
    @Column(name = "order_id")
    private Long id;
    private String productName;
    private int amount;
    private double price;
}
