package org.rsp.service;

import org.rsp.dao.EventRepo;
import org.rsp.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    @Autowired
    private EventRepo eventRepo;

    public void saveEvent(Event event) {
        eventRepo.save(event);
    }

    public List<Event> getAllEvents() {
        return eventRepo.findAll();
    }

    public Event getEventById(Long id) {
        return eventRepo.findById(id).orElse(null);
    }

    public Event findEventById(int eventId) {
        Optional<Event> opt = eventRepo.findById((long) eventId);
        if (opt.isPresent()) return opt.get();
        else return new Event();
    }
}
