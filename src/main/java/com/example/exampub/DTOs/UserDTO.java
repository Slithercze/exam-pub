package com.example.exampub.DTOs;

import com.example.exampub.models.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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
