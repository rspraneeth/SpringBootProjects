package com.qwiktix.controller;

import com.qwiktix.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EventController {
    @Autowired
    private EventRepository eventRepository;
}
