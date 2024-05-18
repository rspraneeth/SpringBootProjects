package com.rsp.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service @Slf4j
public class WikiMediaConsumer {

    @KafkaListener(topics = "wikimediastream-rsp", groupId = "myGroup")
    public void consumeMsg(String msg){
        log.info(String.format("Consuming msg from wikimediastream-rsp Topic :: %s", msg));
    }

}
