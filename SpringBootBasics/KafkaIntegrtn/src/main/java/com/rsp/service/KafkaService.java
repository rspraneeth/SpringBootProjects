package com.rsp.service;

import com.rsp.model.Customer;
import com.rsp.util.AppConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String, Customer> kafkaTemplate;

    public String addMessage(Customer cx){
        kafkaTemplate.send(AppConstants.TOPIC_NAME, cx);
        return "Message published to kafka topic";
    }

    public String add(List<Customer> customers){
        if (!customers.isEmpty()){
            for (Customer c: customers){
                kafkaTemplate.send(AppConstants.TOPIC_NAME, c);
                System.out.println("***********Message published to Kafka topic**********");
            }
        }
        return "Customer records added to Kafka Queue Successfully";
    }
}
