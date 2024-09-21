package com.example.finanalyser.kafka;

import com.example.finanalyser.model.LimitDTO;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {

    @Value( value = "${spring.kafka.bootstrap-servers}" )
    private String kafkaBootstrapAddress;

    @Value( value = "${kafka.consumer.group1}" )
    private String limitsGroupId;

    @Value( value = "${kafka.consumer.group2}" )
    private String transactionsGroupId;

    @Bean
    public ConsumerFactory<String, LimitDTO> limitsConsumerFactory() {
        Map<String, Object> props = new HashMap<>();

        props.put( ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBootstrapAddress );
        props.put( ConsumerConfig.GROUP_ID_CONFIG, limitsGroupId );
        props.put(JsonDeserializer.USE_TYPE_INFO_HEADERS, false);
        props.put( JsonDeserializer.TRUSTED_PACKAGES, "*" );

        return new DefaultKafkaConsumerFactory<>( props, new StringDeserializer(), new JsonDeserializer<>(LimitDTO.class) );
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, LimitDTO> limitsKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, LimitDTO> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory( limitsConsumerFactory() );

        return factory;
    }

}
