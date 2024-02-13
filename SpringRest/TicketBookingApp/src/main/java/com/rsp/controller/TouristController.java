package com.rsp.controller;

import com.rsp.model.Tourist;
import com.rsp.service.ITouristMgmt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tourist-api")
public class TouristController {

    @Autowired
    private ITouristMgmt service;

    @PostMapping("/register")
    public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist){
        String msg = service.registerTourist(tourist);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @GetMapping("/tourists")
    public ResponseEntity<?> getAllTourists(){
        List<Tourist> tourists = service.fetchAllTourists();
        return new ResponseEntity<>(tourists, HttpStatus.OK);
    }
}
