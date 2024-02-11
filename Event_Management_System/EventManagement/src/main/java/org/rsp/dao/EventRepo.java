package org.rsp.dao;

import org.rsp.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface EventRepo extends JpaRepository<Event, Long> {
    List<Event> findByDateTimeAfter(LocalDateTime dateTime);
}
