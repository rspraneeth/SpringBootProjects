package com.rsp.dao;

import com.rsp.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITicketRepo extends JpaRepository<Ticket, Integer> {

}
