package com.example.exampub.DTOs;

import com.example.exampub.models.User;

public class UserDTO {
    private Long id;
    private String name;
    private boolean isActive;
    private boolean isAdult;
    private double pocket;

    public UserDTO(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.isActive = user.isActive();
        this.isAdult = user.isAdult();
        this.pocket = user.getPocket();
    }
}
