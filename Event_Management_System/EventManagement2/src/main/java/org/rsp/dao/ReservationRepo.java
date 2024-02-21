package org.rsp.dao;

import org.rsp.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReservationRepo extends JpaRepository<Reservation, Integer> {
}
