package com.example.finanalyser.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Entity for tracking status of user funds.
 * For catching moment when limitAmount will be excited by actualAmount.
 * validUntil is for when limit amount will be reset.
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnalysisData {
    @Id
    @Nullable
    private Long id;
    private String userId;
    private BigDecimal limitAmount;
    @Nullable
    private BigDecimal actualAmount;
    private LocalDate validUntil;
    @Nullable
    private String category;
}
