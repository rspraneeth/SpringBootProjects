package com.qwiktix.controller;

import com.qwiktix.data.Event;
import com.qwiktix.helpers.ValidationHelper;
import com.qwiktix.request.NewEventRequest;
import com.qwiktix.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EventController {
    @Autowired
    private EventService eventService;
    @Autowired
    private ValidationHelper validationHelper;

    @PostMapping("/admin/events/store")
    public String addNewEvent(@ModelAttribute("newEventRequest")NewEventRequest newEventRequest, RedirectAttributes redirectAttributes){
       if(newEventRequest.getTicketPrice().isEmpty() || newEventRequest.getImage().isEmpty()){
           redirectAttributes.addFlashAttribute("errorMessage", "Data is Invalid, enter valid data");
           return "redirect:/admin/events/add";
       }
        Event event = new Event(
                newEventRequest.getEventName(),
                newEventRequest.getEventDate(),
                newEventRequest.getVenue(),
                newEventRequest.getDescription(),
                Double.parseDouble(newEventRequest.getTicketPrice()),
                newEventRequest.getCategory(),
                newEventRequest.getLocation()
        );
        if (!validationHelper.isValidNewEventData(event)){
            redirectAttributes.addFlashAttribute("errorMessage", "Data is Invalid, enter valid data");
            return "redirect:/admin/events/add";
        }
        try {
            String result = eventService.addNewEvent(event,newEventRequest);
            if (result.equalsIgnoreCase("success")) {
                redirectAttributes.addFlashAttribute("successMessage", "Event added successfully");
                return "redirect:/admin/events";
            } else {
                redirectAttributes.addFlashAttribute("errorMessage", "Failed to create event.Please try again");
                return "redirect:/admin/events/add";
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Failed to create event.Please try again");
            return "redirect:/admin/events/add";
        }
    }
}
