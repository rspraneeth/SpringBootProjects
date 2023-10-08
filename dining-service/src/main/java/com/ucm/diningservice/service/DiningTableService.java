package com.ucm.diningservice.service;

import com.ucm.diningservice.model.ReservationDetails;

import java.util.List;

public interface DiningTableService {

    List<Integer> getReservedTablesList();

    boolean saveTableReservation(ReservationDetails details);

    boolean vacateTable(String phoneNumber);

    boolean updateTableDetails(ReservationDetails reservationDetails);
}
