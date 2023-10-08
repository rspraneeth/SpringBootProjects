package com.ucm.diningservice.service;

import com.ucm.diningservice.model.DinnerInfo;
import com.ucm.diningservice.model.ReservationDetails;

public interface ReservationService {

    boolean bookReservation(DinnerInfo dinnerInfo);

    boolean updateReservation(String phoneNumber);

    boolean cancelReservation(String phoneNumber);

    ReservationDetails findReservation(String phoneNumber);

}
