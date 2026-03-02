package com.barnabas.finance_tracker.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ExpenseCreateRequest {
    // excludes `id` and `createdAt` as server generates those
    private String description;
    private BigDecimal amount;
    private String category;
}
