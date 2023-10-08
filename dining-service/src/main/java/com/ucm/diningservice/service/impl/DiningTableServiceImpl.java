package com.ucm.diningservice.service.impl;

import com.ucm.diningservice.dao.impl.DiningTableDaoImpl;
import com.ucm.diningservice.model.DiningTableDetails;
import com.ucm.diningservice.model.DinnerInfo;
import com.ucm.diningservice.model.ReservationDetails;
import com.ucm.diningservice.service.DiningTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiningTableServiceImpl implements DiningTableService {

    @Autowired
    private DiningTableDaoImpl diningTableDao;

    @Override
    public List<Integer> getReservedTablesList() {
        return diningTableDao.getBookedTables();
    }

    @Override
    public boolean saveTableReservation(ReservationDetails reservationDetails) {
        DiningTableDetails diningTableDetails = buildDiningTableDetails(reservationDetails);
        return diningTableDao.saveTableDetails(diningTableDetails);
    }


    @Override
    public boolean vacateTable(String phoneNumber) {
        return diningTableDao.clearTable(phoneNumber);
    }

    @Override
    public boolean updateTableDetails(ReservationDetails reservationDetails) {
        DiningTableDetails table = new DiningTableDetails();
        table.setReservationTime(reservationDetails.getReservationTime());
        table.setTableAvailability(reservationDetails.getReservationStatus());
        return  diningTableDao.updateTableDetailsInDb(table);
    }

    private DiningTableDetails buildDiningTableDetails(ReservationDetails reservationDetails) {
        DiningTableDetails details = new DiningTableDetails();
        details.setPhoneNumber(reservationDetails.getPhoneNumber());
        details.setTableNumber(reservationDetails.getTableNumber());
        details.setReservationTime(reservationDetails.getReservationTime());
        details.setTableAvailability(reservationDetails.getReservationStatus());
        return details;
    }
}
