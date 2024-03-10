package com.rsp.controller;

import com.rsp.model.Customer;
import com.rsp.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private KafkaService kafkaService;

    @PostMapping("/addCx")
    public ResponseEntity<String> addCxtoKafka(@RequestBody Customer cx){

        return new ResponseEntity<>(kafkaService.addMessage(cx), HttpStatus.OK);
    }

    @PostMapping("/addManyCx")
    public ResponseEntity<String> addManyCxtoKafka(@RequestBody List<Customer> cxs){

        return new ResponseEntity<>(kafkaService.add(cxs), HttpStatus.OK);
    }
}
