package org.rsp.controller;

import org.rsp.model.Event;
import org.rsp.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/addEvent")
    public String addEventForm(Model model){
        model.addAttribute("event", new Event());
        return "addEventForm";
    }

    @PostMapping("/addEvent")
    public String addEvent(@ModelAttribute Event event, @RequestParam("imageFile")MultipartFile imageFile){
        try {
            event.setImage(imageFile.getBytes());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        eventService.saveEvent(event);
        return "admin-dashboard";
    }

    @ModelAttribute("categories")
    public List<String> categories() {
        // Hardcoded list of categories
        return Arrays.asList("Concert", "Conference", "Exhibition", "Party", "Sports");
    }

    @GetMapping("/events")
    public String showEvents(Model model){
        model.addAttribute("events", eventService.getAllEvents());
        return "events";
    }

    @GetMapping("/events/{eventId}")
    public String showEventDetails(@PathVariable Long eventId, Model model){
        model.addAttribute("event", eventService.getEventById(eventId));
        return "eventDetails";
    }

}
