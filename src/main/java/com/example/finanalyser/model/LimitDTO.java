package com.example.finanalyser.model;

import com.example.finanalyser.enums.LimitType;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Limit info from Kafka topic "new_limit"
 */
@Data
public class LimitDTO {
    private Long id;
    private String userId;
    private LimitType limitType;
    private BigDecimal limitAmount;
    private String category;
    private LocalDate creationDate;
}
