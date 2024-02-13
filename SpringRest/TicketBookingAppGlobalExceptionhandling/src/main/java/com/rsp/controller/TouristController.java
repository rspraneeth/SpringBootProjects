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

    @GetMapping("/tourist/{id}")
    public ResponseEntity<?> getTouristById(@PathVariable Integer id){

        Tourist tourist = service.fetchTouristById(id);
        return new ResponseEntity<>(tourist, HttpStatus.OK);


    }

    @PutMapping("/update")
    public ResponseEntity<? extends String> updateTourist(@RequestBody Tourist tourist){

        String msg = service.updateTouristData(tourist);
        return new ResponseEntity<>(msg, HttpStatus.OK);

    }

    @PatchMapping("/update/{id}/{budget}")
    public ResponseEntity<? extends String> updateTourist(@PathVariable Integer id, @PathVariable Double budget){

        String msg = service.updateTouristById(id, budget);
        return new ResponseEntity<>(msg, HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTourist(@PathVariable Integer id){

        String msg = service.deleteById(id);
        return new ResponseEntity<>(msg, HttpStatus.OK);

    }

}
