package com.rsp.advice;


import com.rsp.exception.TouristNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class TouristErrorController {

    @ExceptionHandler(TouristNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleTouristNotFoundExceptionGlobally(Exception e){
        System.out.println("Advice controller, TouristNotFoundException");
        ErrorDetails error = new ErrorDetails("404 not found", e.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleExceptionGlobally(Exception e){

        ErrorDetails error = new ErrorDetails("404 not found", e.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
