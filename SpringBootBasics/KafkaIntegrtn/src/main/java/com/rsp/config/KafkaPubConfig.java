package com.rsp.config;

import com.rsp.model.Customer;
import com.rsp.util.AppConstants;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaPubConfig {
    /* Kafka Producer Configuration*/

    @Bean
    public ProducerFactory<String, Customer> producerFactory(){
        /* ProducerFactory bean for producing messages to a Kafka topic */
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, AppConstants.HOST_URL); // Kafka broker to connect to
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class); // serializer class for Kafka message keys, message keys are expected to be strings
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class); // serializer class for Kafka message values, serializes objects to JSON format.

        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean(name = "kafkaTemplate")
    public KafkaTemplate<String, Customer> kafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }
}
