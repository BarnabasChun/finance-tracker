package com.barnabas.finance_tracker;

import lombok.AllArgsConstructor; // creates a constructor with one argument for every field in your class.
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class ErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private String detail;
    private String message;
    private String path;
}
