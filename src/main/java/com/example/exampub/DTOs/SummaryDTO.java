package com.example.exampub.DTOs;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SummaryDTO {
    private String product;
    private int amount;
    private double unitPrice;
    private double summaryPrice;
}
