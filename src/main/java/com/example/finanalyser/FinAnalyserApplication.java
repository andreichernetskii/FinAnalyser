package com.example.finanalyser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class FinAnalyserApplication {

    public static void main( String[] args ) {
        SpringApplication.run( FinAnalyserApplication.class, args );
    }

}
