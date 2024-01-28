package com.qwiktix.service;

import com.qwiktix.data.Event;
import com.qwiktix.data.Image;
import com.qwiktix.interfaces.FileService;
import com.qwiktix.repository.EventRepository;
import com.qwiktix.repository.ImageRepository;
import com.qwiktix.request.NewEventRequest;
import com.qwiktix.response.AdminEventResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private FileServiceImpl fileService;

    public AdminEventResponse adminEvent(){
        try {
            return new AdminEventResponse(eventRepository.findAll(),(int)eventRepository.count());
        }catch (Exception e){
            return new AdminEventResponse(new ArrayList<>(),0);
        }
    }
    @Transactional
    public String addNewEvent(Event event, NewEventRequest newEventRequest) {
        try {
//            String fileName = fileService.uploadFile(newEventRequest.getImage());
//            String url = fileService.downloadFile(fileName).toString();
//            Image image = imageRepository.save(new Image(fileName,url));
//            event.setImage(image);
            eventRepository.save(event);
            return "success";
        }catch (Exception e){
            return "failed";
        }
    }
}
