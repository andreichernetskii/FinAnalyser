package com.example.finanalyser.repository;

import com.example.finanalyser.entity.AnalysisData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalyserRepository extends JpaRepository<AnalysisData, Long> {
}
