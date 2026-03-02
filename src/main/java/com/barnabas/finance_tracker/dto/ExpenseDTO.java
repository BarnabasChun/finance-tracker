package com.barnabas.finance_tracker.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ExpenseDTO {
    private Long id;
    private String description;
    private BigDecimal amount;
    private String category;
    private LocalDateTime createdAt;
}
