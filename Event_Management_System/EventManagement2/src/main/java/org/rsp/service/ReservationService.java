package org.rsp.service;

import org.rsp.dao.ReservationRepo;
import org.rsp.model.Reservation;
import org.rsp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepo reservationRepo;
    public void addReservation(Reservation reservation) {
        reservationRepo.save(reservation);
    }


}
