package com.qwiktix.controller;

import com.qwiktix.interfaces.FileService;
import com.qwiktix.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EventController {
    @Autowired
    private EventService eventService;
    @Autowired
    private FileService fileService;
}
