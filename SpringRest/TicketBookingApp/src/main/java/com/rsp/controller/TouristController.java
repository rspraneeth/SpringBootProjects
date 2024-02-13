package com.rsp.controller;

import com.rsp.exception.TouristNotFoundException;
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

        try {
            String msg = service.registerTourist(tourist);
            return new ResponseEntity<>(msg, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("problem fetching records...", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/tourists")
    public ResponseEntity<?> getAllTourists(){
        try {
            List<Tourist> tourists = service.fetchAllTourists();
            return new ResponseEntity<>(tourists, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("problem fetching records...", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/tourist/{id}")
    public ResponseEntity<?> getTouristById(@PathVariable Integer id){
        try {
            Tourist tourist = service.fetchTouristById(id);
            return new ResponseEntity<>(tourist, HttpStatus.OK);
        } catch (TouristNotFoundException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("/update")
    public ResponseEntity<? extends String> updateTourist(@RequestBody Tourist tourist){
        try {
            String msg = service.updateTouristData(tourist);
            return new ResponseEntity<>(msg, HttpStatus.OK);
        }catch (TouristNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/update/{id}/{budget}")
    public ResponseEntity<? extends String> updateTourist(@PathVariable Integer id, @PathVariable Double budget){
        try {
            String msg = service.updateTouristById(id, budget);
            return new ResponseEntity<>(msg, HttpStatus.OK);
        }catch (TouristNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
