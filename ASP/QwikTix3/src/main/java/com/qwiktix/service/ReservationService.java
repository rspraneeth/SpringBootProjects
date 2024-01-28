package com.qwiktix.service;

import com.qwiktix.data.Reservation;
import com.qwiktix.repository.ReservationRepository;
import com.qwiktix.response.AdminReservationResponse;
import com.qwiktix.response.UserReservationsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private  EmailService emailService;
    public AdminReservationResponse adminReservations() {
        try {
            BigDecimal sumOfAmounts = reservationRepository.getTotalReservationAmount();
            return new AdminReservationResponse(reservationRepository.findAll(),sumOfAmounts.doubleValue(),(int)reservationRepository.count());
        }catch (Exception e){
            return new AdminReservationResponse(new ArrayList<>(),0,0);
        }
    }

    public String addNewReservation(Reservation reservation) {
        try {
            Reservation rs = reservationRepository.save(reservation);
            String emailBody = "\nEvent Name:"+rs.getEvent().getEventName()
                    +"\nVenue:"+rs.getEvent().getVenue()+"\nLocation:"+rs.getEvent().getLocation();
//           emailService.sendEmail(reservation.getUser().getEmail(),"Booking Success",emailBody);
           return "success";
        }catch (Exception e){
            return "failed";
        }
    }

    public UserReservationsResponse getUserReservations(Long userId){
        try {
            return new UserReservationsResponse(reservationRepository.findByUserId(userId));
        }catch (Exception e){
            return new UserReservationsResponse();
        }
    }
}
