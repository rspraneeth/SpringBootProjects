package com.rsp.dao;

import com.rsp.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITicketRepo extends JpaRepository<Passenger, Integer> {
}
