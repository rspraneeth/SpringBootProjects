package com.rsp.consumer;

import com.rsp.payload.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

//    @KafkaListener(topics = "rsp", groupId = "myGroup")
//    public void consumeMsg(String msg){
//        log.info(String.format("Consuming the message from rsp topic:: %s", msg));
//    }

    @KafkaListener(topics = "rsp", groupId = "myGroup")
    public void consumeJsonMsg(Student msg){
        log.info(String.format("Consuming the message from rsp topic:: %s", msg));
    }
}
