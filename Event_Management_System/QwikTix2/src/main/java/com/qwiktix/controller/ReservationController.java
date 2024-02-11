package com.qwiktix.controller;

import com.qwiktix.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ReservationController {
    @Autowired
    private ReservationRepository reservationRepository;
}
