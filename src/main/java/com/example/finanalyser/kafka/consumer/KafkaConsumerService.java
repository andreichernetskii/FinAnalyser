package com.example.finanalyser.kafka.consumer;

import com.example.finanalyser.model.LimitDTO;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(
            topics = "new_limit",
            groupId = "${kafka.consumer.group1}",
            containerFactory = "limitsKafkaListenerContainerFactory"
    )
    public void consumeNewLimit( LimitDTO limit ) {
        System.out.println( limit );
    }
}
