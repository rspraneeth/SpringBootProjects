package com.ucm.diningservice.dao;

import com.ucm.diningservice.model.DinnerInfo;
import com.ucm.diningservice.model.ReservationDetails;

public interface ReservationDao {

    ReservationDetails saveReservation(DinnerInfo dinnerInfo);

    boolean cancelReservation(String phoneNumber);

    ReservationDetails getReservation(String phoneNumber);

    ReservationDetails updateReservation(String phoneNumber);
}
