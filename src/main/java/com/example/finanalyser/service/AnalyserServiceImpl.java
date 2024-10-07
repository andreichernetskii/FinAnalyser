package com.example.finanalyser.service;

import com.example.finanalyser.mapper.Mapper;
import com.example.finanalyser.model.LimitDTO;
import com.example.finanalyser.repository.AnalyserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnalyserServiceImpl implements AnalyserService {
    private final AnalyserRepository analyserRepository;

    @Override
    public void addLimitToBase( LimitDTO limit ) {
        analyserRepository.save( Mapper.mapLimitDTOToAnalysisData( limit ) );
    }

}
