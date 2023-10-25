package com.example.exampub.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "orders")
@Entity
@Data
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long id;
    private String productName;
    private int amount;
    private double price;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    private User user;
}
