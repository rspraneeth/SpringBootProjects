package com.rsp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MultiDbCheckApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MultiDbCheckApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //can write code here that executes everytime app starts.
    }
}
