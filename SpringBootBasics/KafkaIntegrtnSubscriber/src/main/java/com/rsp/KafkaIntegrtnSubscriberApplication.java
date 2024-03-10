package com.rsp;

import com.rsp.util.AppConstants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class KafkaIntegrtnSubscriberApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaIntegrtnSubscriberApplication.class, args);
    }


    @KafkaListener(topics = AppConstants.TOPIC_NAME, groupId = "group_rsp_customer")
    public void subscribeMsg(String cxData){
        System.out.println("***Message received from Kafka topic***");
        System.out.println(cxData);
    }

}
