package com.example.exampub.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Buy {
    private Long userId;
    private Long productId;
    private boolean price;
}
