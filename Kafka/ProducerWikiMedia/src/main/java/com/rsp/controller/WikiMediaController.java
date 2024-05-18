package com.rsp.controller;

import com.rsp.stream.WikiMediaStreamConsumer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/wikimedia")
public class WikiMediaController {

    private final WikiMediaStreamConsumer streamConsumer;

    @GetMapping
    public void startPublishing(){

        streamConsumer.consumeStreamAndPublish();
    }
}
