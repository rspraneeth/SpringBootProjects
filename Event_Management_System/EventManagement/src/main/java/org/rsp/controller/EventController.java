package org.rsp.controller;

import org.rsp.model.Event;
import org.rsp.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/addEvent")
    public String addEventForm(Model model){
        model.addAttribute("event", new Event());
        return "addEventForm";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/addEvent")
    public String addEvent(@ModelAttribute Event event, @RequestParam("imageFile")MultipartFile imageFile){

        eventService.saveEvent(event);
        return "admin-dashboard";
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
