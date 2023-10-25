package com.example.exampub.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "users")
@Entity
@Data
@NoArgsConstructor
public class User {

    @Id
    private Long id;
    private String name;
    private boolean isActive;
    private boolean isAdult;
    private double pocket;

}
