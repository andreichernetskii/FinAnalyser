package com.example.finanalyser.model;


import jakarta.annotation.Nullable;
import lombok.Data;

import java.time.LocalDate;

/**
 * Object for sending request to Transactions microservice according to LimitDTO
 */
@Data
public class TransactionsRequest {
    private String userId;
    private LocalDate transactionsFromDate;
    @Nullable
    private String category;
}
