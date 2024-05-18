package com.rsp.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service@Slf4j@RequiredArgsConstructor
public class WikiMediaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String msg){


        kafkaTemplate.send("wikimediastream-rsp", msg);
    }

}
