package com.rsp.dao;

import com.rsp.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPassengerRepo extends JpaRepository<Passenger, Integer> {
}
