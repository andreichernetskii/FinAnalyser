package com.example.finanalyser.mapper;

import com.example.finanalyser.entity.AnalysisData;
import com.example.finanalyser.enums.LimitType;
import com.example.finanalyser.model.LimitDTO;

import java.time.LocalDate;

public class Mapper {
    public static AnalysisData mapLimitDTOToAnalysisData( LimitDTO limitDTO ) {
        if (limitDTO == null ) return null;

        return AnalysisData
                .builder()
                .userId( limitDTO.getUserId() )
                .limitAmount( limitDTO.getLimitAmount() )
                .validUntil( calcValidUntilDate( limitDTO.getCreationDate(), limitDTO.getLimitType() ) )
                .category( limitDTO.getCategory() )
                .build();
    }

    private static LocalDate calcValidUntilDate( LocalDate creationDate, LimitType limitType ) {
        return switch ( limitType ) {
            case ZERO, BUDGET -> null;
            case YEAR -> creationDate.plusYears( 1 );
            case MONTH -> creationDate.plusMonths( 1 );
            case WEEK -> creationDate.plusWeeks( 1 );
            case DAY -> creationDate.plusDays( 1 );
        };
    }
}
