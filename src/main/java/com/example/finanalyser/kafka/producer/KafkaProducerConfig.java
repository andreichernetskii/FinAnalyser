package com.example.finanalyser.kafka.producer;

import com.example.finanalyser.model.TransactionsRequest;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Value( value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    @Bean
    public ProducerFactory<String, TransactionsRequest> requestTransactionsProducerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put( ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress );

        return new DefaultKafkaProducerFactory<>( props, new StringSerializer(), new JsonSerializer<>() );
    }

    @Bean
    public KafkaTemplate<String, TransactionsRequest> requestTransactionsKafkaTemplate() {
        return new KafkaTemplate<>( requestTransactionsProducerFactory() );
    }

    @Bean
    public NewTopic createTransactionsRequestTopic() {
        return TopicBuilder
                .name( "transactions-request" )
                .partitions( 1 )
                .build();
    }
}
